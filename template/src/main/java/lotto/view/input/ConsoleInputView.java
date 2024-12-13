package lotto.view.input;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import lotto.view.exception.InvalidInputException;

public class ConsoleInputView implements InputView {

    public static final Pattern 숫자_패턴 = Pattern.compile("^[0-9]+$");
    public static final Pattern 한글_영어_패턴 = Pattern.compile("^[ㄱ-ㅎ가-힣A-Za-z]+$");

    @Override
    public int input() {
        System.out.println("입력해 주세요.");
        String input = Console.readLine();

        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw InvalidInputException.invalidInput("정수가 아닙니다.");
        }
    }

    private List<Integer> 문자열을_구분자로_나누어_정수_리스트로(final String input, final String delimiter) {
        return Arrays.stream(input.split(delimiter))
                .map(Integer::parseInt)
                .toList();
    }

    private void 구분자로_입력받기_검증(String value, String delimiter) {
        if (value.trim().isEmpty()) { // 비어있는지
            throw InvalidInputException.invalidInput("입력이 비어있습니다.");
        }
        if (value.startsWith(delimiter) || value.endsWith(delimiter)) { // 구분자로 시작하거나 끝나는지
            throw InvalidInputException.invalidInput("올바르지 않은 입력입니다.");
        }
        if (value.contains(delimiter.repeat(2))) { // 구분자가 연속 두 번 나오는지
            throw InvalidInputException.invalidInput("올바르지 않은 입력입니다.");
        }
    }
}
