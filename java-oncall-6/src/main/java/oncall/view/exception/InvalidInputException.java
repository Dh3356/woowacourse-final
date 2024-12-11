package oncall.view.exception;

import oncall.exception.CustomException;

public class InvalidInputException extends IllegalArgumentException implements CustomException {

    private static final String MESSAGE = "message";

    private InvalidInputException(final String message, final String... details) {
        super(CustomException.formatMessageWithDetails(message, details));
    }

    public static IllegalArgumentException invalidInput(final String... details) {
        return new InvalidInputException(MESSAGE, details);
    }
}