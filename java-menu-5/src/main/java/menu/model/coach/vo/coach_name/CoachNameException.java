package menu.model.coach.vo.coach_name;

import static menu.model.coach.vo.coach_name.CoachName.MAX_LENGTH;
import static menu.model.coach.vo.coach_name.CoachName.MIN_LENGTH;

import menu.exception.CustomException;

public class CoachNameException extends IllegalArgumentException implements CustomException {

    private static final String TOO_SHORT_MESSAGE = "코치 이름은 " + MIN_LENGTH + "글자 이상이어야 합니다.";
    private static final String TOO_LONG_MESSAGE = "코치 이름은 " + MAX_LENGTH + "글자 이하여야 합니다.";

    private CoachNameException(final String message, final String... details) {
        super(CustomException.formatMessageWithDetails(message, details));
    }

    public static IllegalArgumentException tooShort(final String... details) {
        return new CoachNameException(TOO_SHORT_MESSAGE, details);
    }

    public static IllegalArgumentException tooLong(final String... details) {
        return new CoachNameException(TOO_LONG_MESSAGE, details);
    }
}
