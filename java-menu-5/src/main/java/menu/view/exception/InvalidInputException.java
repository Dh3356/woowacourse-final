package menu.view.exception;

import menu.exception.CustomException;

public class InvalidInputException extends IllegalArgumentException implements CustomException {

    private static final String MESSAGE = "올바르지 않은 입력입니다.";

    private InvalidInputException(final String message, final String... details) {
        super(CustomException.formatMessageWithDetails(message, details));
    }

    public static IllegalArgumentException invalidInput(final String... details) {
        return new InvalidInputException(MESSAGE, details);
    }
}