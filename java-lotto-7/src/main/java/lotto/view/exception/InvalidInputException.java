package lotto.view.exception;

import lotto.common.exception.CustomException;

public class InvalidInputException extends IllegalArgumentException implements CustomException {

    private static final String INVALID_PURCHASE_MONEY = "구입 금액 입력이 잘못되었습니다.";
    private static final String INVALID_WINNING_NUMBER = "당첨 번호 입력이 잘못되었습니다.";
    private static final String INVALID_BONUS_NUMBER = "보너스 번호 입력이 잘못되었습니다.";

    private InvalidInputException(final String message, final String... details) {
        super(CustomException.formatMessageWithDetails(message, details));
    }

    public static IllegalArgumentException invalidPurchaseMoney(final String... details) {
        return new InvalidInputException(INVALID_PURCHASE_MONEY, details);
    }

    public static IllegalArgumentException invalidWinningNumber(final String... details) {
        return new InvalidInputException(INVALID_WINNING_NUMBER, details);
    }

    public static IllegalArgumentException invalidBonusNumber(final String... details) {
        return new InvalidInputException(INVALID_BONUS_NUMBER, details);
    }
}