package menu.view.input;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import menu.view.exception.InvalidInputException;

public class ConsoleInputView implements InputView {

    public static final Pattern 숫자_패턴 = Pattern.compile("^[0-9]+$");
    public static final Pattern 한글_영어_패턴 = Pattern.compile("^[ㄱ-ㅎ가-힣A-Za-z]+$");

    @Override
    public List<String> inputCoachNames() {
        System.out.println("코치의 이름을 입력해 주세요. (, 로 구분)");
        String input = Console.readLine();
        validateCoachNames(input, ",");

        try {
            return Arrays.stream(input.split(",")).collect(Collectors.toList());
        } catch (RuntimeException e) {
            throw InvalidInputException.invalidInput();
        }
    }

    @Override
    public List<String> inputUnableMenuNames(String coachName) {
        System.out.printf("%s(이)가 못 먹는 메뉴를 입력해 주세요.\n", coachName);
        String input = Console.readLine();
        if (input.isBlank()) {
            return List.of();
        }
        validateUnableMenuNames(input, ",");

        try {
            return Arrays.stream(input.split(","))
                    .collect(Collectors.toList());
        } catch (RuntimeException e) {
            throw InvalidInputException.invalidInput();
        }
    }

    private void validateCoachNames(String coachNames, String delimiter) {
        if (coachNames.trim().isEmpty()) {
            throw InvalidInputException.invalidInput("입력이 비어있습니다.");
        }
        if (coachNames.startsWith(delimiter) || coachNames.endsWith(delimiter)) {
            throw InvalidInputException.invalidInput("구분자로 시작하거나 구분자로 끝납니다.");
        }
        if (coachNames.contains(delimiter.repeat(2))) {
            throw InvalidInputException.invalidInput("구분자가 연속으로 존재합니다.");
        }
    }

    private void validateUnableMenuNames(String unableMenus, String delimiter) {
        if (unableMenus.startsWith(delimiter) || unableMenus.endsWith(delimiter)) {
            throw InvalidInputException.invalidInput("구분자로 시작하거나 구분자로 끝납니다.");
        }
        if (unableMenus.contains(delimiter.repeat(2))) {
            throw InvalidInputException.invalidInput("구분자가 연속으로 존재합니다.");
        }
    }

    private List<Integer> 문자열을_구분자로_나누어_정수_리스트로(final String input, final String delimiter) {
        return Arrays.stream(input.split(delimiter))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
