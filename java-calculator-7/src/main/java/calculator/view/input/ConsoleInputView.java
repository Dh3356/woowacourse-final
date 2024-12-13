package calculator.view.input;

import camp.nextstep.edu.missionutils.Console;
import java.util.regex.Pattern;

public class ConsoleInputView implements InputView {

    public static final Pattern 숫자_패턴 = Pattern.compile("^[0-9]+$");
    public static final Pattern 한글_영어_패턴 = Pattern.compile("^[ㄱ-ㅎ가-힣A-Za-z]+$");

    @Override
    public String input() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();

        if (input.trim().isEmpty()) {
            throw new IllegalArgumentException("입력이 비어있습니다.");
        }

        return input;
    }

    //private void 구분자로_입력받기_검증(String value, String delimiter) {
    //    if (value.trim().isEmpty()) { // 비어있는지
    //        throw InvalidInputException.invalidInput("입력이 비어있습니다.");
    //    }
    //    if (value.startsWith(delimiter) || value.endsWith(delimiter)) { // 구분자로 시작하거나 끝나는지
    //        throw InvalidInputException.invalidInput("올바르지 않은 입력입니다.");
    //    }
    //    if (value.contains(delimiter.repeat(2))) { // 구분자가 연속 두 번 나오는지
    //        throw InvalidInputException.invalidInput("올바르지 않은 입력입니다.");
    //    }
    //}
}
