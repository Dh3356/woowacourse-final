package menu.view.exception;

import menu.exception.CustomException;

public class InvalidInputException extends IllegalArgumentException implements CustomException {

    private InvalidInputException(final String detail) {
        super(detail);
    }

    public static IllegalArgumentException invalidInput(final String detail) {
        return new InvalidInputException(detail);
    }
}