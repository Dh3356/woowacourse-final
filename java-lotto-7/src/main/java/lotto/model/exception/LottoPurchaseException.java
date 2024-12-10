package lotto.model.exception;

import lotto.common.exception.CustomException;

public class LottoPurchaseException extends IllegalArgumentException implements CustomException {

    private static final String PURCHASE_MONEY_TOO_SMALL_MESSAGE = "로또 구입 금액이 너무 적습니다.";
    private static final String PURCHASE_MONEY_NOT_DIVIDABLE_MESSAGE = "로또 구입 금액이 나누어떨어지지 않습니다.";

    private LottoPurchaseException(final String message, final String... details) {
        super(CustomException.formatMessageWithDetails(message, details));
    }

    public static IllegalArgumentException purchaseMoneyTooSmall(final String... details) {
        return new LottoPurchaseException(PURCHASE_MONEY_TOO_SMALL_MESSAGE, details);
    }

    public static IllegalArgumentException purchaseMoneyNotDividable(final String... details) {
        return new LottoPurchaseException(PURCHASE_MONEY_NOT_DIVIDABLE_MESSAGE, details);
    }
}
