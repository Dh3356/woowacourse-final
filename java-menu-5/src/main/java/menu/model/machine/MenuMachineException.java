package menu.model.machine;

import static menu.model.machine.MenuMachine.MAX_COACH_SIZE;
import static menu.model.machine.MenuMachine.MIN_COACH_SIZE;

import menu.exception.CustomException;

public class MenuMachineException extends IllegalArgumentException implements CustomException {

    private static final String COACH_CONFLICT_MESSAGE = "중복된 코치가 존재합니다.";
    private static final String TOO_MINI_COACHES_MESSAGE = "코치는 최소 " + MIN_COACH_SIZE + "명 이상 입력해야 합니다.";
    private static final String TOO_MANY_COACHES_MESSAGE = "코치는 최대 " + MAX_COACH_SIZE + "명 까지 입력 가능합니다.";

    private MenuMachineException(final String message, final String... details) {
        super(CustomException.formatMessageWithDetails(message, details));
    }

    public static IllegalArgumentException coachConflict(final String... details) {
        return new MenuMachineException(COACH_CONFLICT_MESSAGE, details);
    }

    public static IllegalArgumentException tooMiniCoaches(final String... details) {
        return new MenuMachineException(TOO_MINI_COACHES_MESSAGE, details);
    }

    public static IllegalArgumentException tooManyCoaches(final String... details) {
        return new MenuMachineException(TOO_MANY_COACHES_MESSAGE, details);
    }
}
