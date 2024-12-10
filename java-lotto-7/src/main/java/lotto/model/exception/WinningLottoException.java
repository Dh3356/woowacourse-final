package lotto.model.exception;

import lotto.common.exception.CustomException;

public class WinningLottoException extends IllegalArgumentException implements CustomException {

    private static final String INVALID_WINNING_NUMBER_SIZE_MESSAGE = "당첨 로또 번호의 갯수가 올바르지 않습니다.";
    private static final String WINNING_NUMBER_DUPLICATE_MESSAGE = "당첨 로또 번호는 중복되어서는 안됩니다.";
    private static final String INVALID_WINNING_NUMBER_RANGE_MESSAGE = "당첨 로또 번호의 범위가 잘못되었습니다.";
    private static final String WINNING_NUMBER_CONTAINS_BONUS_MESSAGE = "보너스 번호는 당첨 번호에 포함되어서는 안됩니다.";

    private WinningLottoException(final String message, final String... details) {
        super(CustomException.formatMessageWithDetails(message, details));
    }

    public static IllegalArgumentException invalidWinningNumberSize(final String... details) {
        return new WinningLottoException(INVALID_WINNING_NUMBER_SIZE_MESSAGE, details);
    }

    public static IllegalArgumentException duplicateWinningNumbers(final String... details) {
        return new WinningLottoException(WINNING_NUMBER_DUPLICATE_MESSAGE, details);
    }

    public static IllegalArgumentException invalidWinningNumberRange(final String... details) {
        return new WinningLottoException(INVALID_WINNING_NUMBER_RANGE_MESSAGE, details);
    }

    public static IllegalArgumentException winningNumberContainsBonus(final String... details) {
        return new WinningLottoException(WINNING_NUMBER_CONTAINS_BONUS_MESSAGE, details);
    }
}
