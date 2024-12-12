package menu.view.input;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import menu.view.exception.InvalidInputException;

public class ConsoleInputView implements InputView {

    @Override
    public List<String> inputCoachNames() {
        System.out.println("코치의 이름을 입력해 주세요. (, 로 구분)");
        String input = Console.readLine();
        validateSplittable(input, ",");

        List<String> coachNames = Arrays.stream(input.split(",")).collect(Collectors.toList());
        validateCoachNames(coachNames);

        return coachNames;
    }

    @Override
    public List<String> inputUnableMenus(final String coachName) {
        System.out.println(coachName + "(이)가 못 먹는 메뉴를 입력해 주세요.");
        String input = Console.readLine();
        if (input.trim().isEmpty()) {
            return List.of();
        }
        validateUnableMenusSplittable(input, ",");

        return Arrays.stream(input.split(",")).collect(Collectors.toList());
    }

    private void validateUnableMenusSplittable(final String input, final String delimiter) {
        if (input.startsWith(delimiter) || input.endsWith(delimiter)) {
            throw InvalidInputException.invalidInput("올바르지 않은 입력입니다.");
        }
        if (input.contains(delimiter.repeat(2))) {
            throw InvalidInputException.invalidInput("올바르지 않은 입력입니다.");
        }
    }

    private void validateSplittable(final String value, final String delimiter) {
        if (value.trim().isEmpty()) { // 비어있는지
            throw InvalidInputException.invalidInput("입력이 비어있습니다.");
        }
        if (value.startsWith(delimiter) || value.endsWith(delimiter)) {
            throw InvalidInputException.invalidInput("올바르지 않은 입력입니다.");
        }
        if (value.contains(delimiter.repeat(2))) {
            throw InvalidInputException.invalidInput("올바르지 않은 입력입니다.");
        }
    }

    private void validateCoachNames(final List<String> coachNames) {
        if (Set.copyOf(coachNames).size() != coachNames.size()) {
            throw InvalidInputException.invalidInput("중복된 코치 이름이 존재합니다.");
        }
        if (coachNames.size() < 2) {
            throw InvalidInputException.invalidInput("코치는 최소 2명 이상 입력해야 합니다.");
        }
        if (coachNames.size() > 5) {
            throw InvalidInputException.invalidInput("코치는 최대 5명 까지만 입력해야 합니다.");
        }
    }
}
