package lotto.model.exception;

import lotto.common.exception.CustomException;

public class LottoRankException extends IllegalStateException {

    private static final String CANNOT_CALCULATE_MESSAGE = "로또 당첨 결과를 계산하는 데에 실패했습니다.";

    private LottoRankException(final String message, final String... details) {
        super(CustomException.formatMessageWithDetails(message, details));
    }

    public static IllegalStateException cannotCalculate(final String... details) {
        return new LottoRankException(CANNOT_CALCULATE_MESSAGE, details);
    }
}
