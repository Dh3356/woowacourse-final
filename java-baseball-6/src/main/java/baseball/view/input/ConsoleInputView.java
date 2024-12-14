package baseball.view.input;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class ConsoleInputView implements InputView {

    public static final Pattern NUMBER_PATTERN = Pattern.compile("^[0-9]+$");

    @Override
    public List<Integer> inputNumbers() {
        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine();
        validateNumberInput(input);

        return Arrays.stream(input.split("")).map(Integer::parseInt).toList();
    }

    @Override
    public boolean inputContinueGame() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String input = Console.readLine();
        validateNumberInput(input);

        int result = Integer.parseInt(input);
        if (result != 1 && result != 2) {
            throw new IllegalArgumentException("1 또는 2를 입력하세요.");
        }
        return result == 1;
    }

    private void validateNumberInput(String input) {
        if (!NUMBER_PATTERN.matcher(input).matches()) {
            throw new IllegalArgumentException("숫자가 아닙니다.");
        }
    }
}
