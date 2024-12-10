package lotto.model.exception;

import lotto.common.exception.CustomException;

public class LottoException extends IllegalArgumentException implements CustomException {

    private static final String INVALID_NUMBER_SIZE_MESSAGE = "로또 번호의 갯수가 올바르지 않습니다.";
    private static final String NUMBER_DUPLICATE_MESSAGE = "로또 번호는 중복되어서는 안됩니다.";
    private static final String INVALID_NUMBER_RANGE_MESSAGE = "로또 번호의 범위가 잘못되었습니다.";

    private LottoException(final String message, final String... details) {
        super(CustomException.formatMessageWithDetails(message, details));
    }

    public static IllegalArgumentException invalidNumberSize(final String... details) {
        return new LottoException(INVALID_NUMBER_SIZE_MESSAGE, details);
    }

    public static IllegalArgumentException duplicateNumbers(final String... details) {
        return new LottoException(NUMBER_DUPLICATE_MESSAGE, details);
    }

    public static IllegalArgumentException invalidNumberRange(final String... details) {
        return new LottoException(INVALID_NUMBER_RANGE_MESSAGE, details);
    }
}
