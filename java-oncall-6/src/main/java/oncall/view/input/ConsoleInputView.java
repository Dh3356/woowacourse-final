package oncall.view.input;

import camp.nextstep.edu.missionutils.Console;
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.List;
import java.util.Map.Entry;
import java.util.regex.Pattern;
import oncall.view.exception.InvalidInputException;

public class ConsoleInputView implements InputView {

    public static final Pattern 숫자_패턴 = Pattern.compile("^[0-9]+$");
    public static final Pattern 한글_영어_패턴 = Pattern.compile("^[ㄱ-ㅎ가-힣A-Za-z]+$");

    @Override
    public Entry<Integer, String> inputSchedule() {
        System.out.print("비상 근무를 배정할 월과 시작 요일을 입력하세요> ");
        String input = Console.readLine();

        List<String> parsedInput = parseSchedule(input);

        try {
            return new AbstractMap.SimpleEntry<>(Integer.parseInt(parsedInput.get(0)), parsedInput.get(1));
        } catch (RuntimeException e) {
            throw InvalidInputException.invalidInput("올바르지 않은 입력입니다.");
        }
    }

    @Override
    public List<String> inputWeekDayWorkers() {
        System.out.print("평일 비상 근무 순번대로 사원 닉네임을 입력하세요> ");
        String input = Console.readLine();
        validateDelimiterSplit(input, ",");

        return Arrays.stream(input.split(",")).toList();
    }

    @Override
    public List<String> inputWeekEndWorkers() {
        System.out.print("휴일 비상 근무 순번대로 사원 닉네임을 입력하세요> ");
        String input = Console.readLine();
        validateDelimiterSplit(input, ",");

        return Arrays.stream(input.split(",")).toList();
    }

    private List<String> parseSchedule(final String input) {
        validateDelimiterSplit(input, ",");
        List<String> parsedInput = Arrays.stream(input.split(","))
                .toList();
        if (parsedInput.size() != 2) {
            throw InvalidInputException.invalidInput("올바르지 않은 입력입니다.");
        }
        return parsedInput;
    }

    private void validateDelimiterSplit(final String input, final String delimiter) {
        if (input.trim().isEmpty()) {
            throw InvalidInputException.invalidInput("입력이 비어있습니다.");
        }
        if (input.startsWith(delimiter) || input.endsWith(delimiter)) { // 구분자로 시작하거나 끝나는지
            throw InvalidInputException.invalidInput("올바르지 않은 입력입니다.");
        }
        if (input.contains(delimiter.repeat(2))) {
            throw InvalidInputException.invalidInput("올바르지 않은 입력입니다.");
        }
    }

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
        if (value.contains(delimiter.repeat(2))) {
            throw InvalidInputException.invalidInput("올바르지 않은 입력입니다.");
        }
    }
}
