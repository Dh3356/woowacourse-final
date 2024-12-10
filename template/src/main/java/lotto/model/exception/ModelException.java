package lotto.model.exception;

import lotto.common.exception.CustomException;

public class ModelException extends RuntimeException implements CustomException {

    private static final String MESSAGE = "message";

    private ModelException(final String message, final String... details) {
        super(CustomException.formatMessageWithDetails(message, details));
    }

    public static RuntimeException factory(final String... details) {
        return new ModelException(MESSAGE);
    }
}
