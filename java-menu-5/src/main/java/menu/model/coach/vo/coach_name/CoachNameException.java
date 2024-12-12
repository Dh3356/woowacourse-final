package menu.model.coach.vo.coach_name;

import static menu.model.coach.vo.coach_name.CoachName.COACH_NAME_LENGTH_MAX;
import static menu.model.coach.vo.coach_name.CoachName.COACH_NAME_LENGTH_MIN;

import menu.exception.CustomException;

public class CoachNameException extends IllegalArgumentException implements CustomException {

    private static final String COACH_NAME_TOO_SHORT_MESSAGE = "코치 이름은 " + COACH_NAME_LENGTH_MIN + "자 이상이어야 합니다.";
    private static final String COACH_NAME_TOO_LONG_MESSAGE = "코치 이름은 " + COACH_NAME_LENGTH_MAX + "자 이하여야 합니다.";

    private CoachNameException(final String message, final String... details) {
        super(CustomException.formatMessageWithDetails(message, details));
    }

    public static IllegalArgumentException tooShort(final String... details) {
        return new CoachNameException(COACH_NAME_TOO_SHORT_MESSAGE);
    }

    public static IllegalArgumentException tooLong(final String... details) {
        return new CoachNameException(COACH_NAME_TOO_LONG_MESSAGE);
    }
}
