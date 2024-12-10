package lotto.view.response.purchase;

import java.util.List;
import lotto.model.Lotto;

public class PurchaseLottoResponse {

    private final List<Integer> lottoNumbers;

    private PurchaseLottoResponse(final List<Integer> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public static PurchaseLottoResponse from(final Lotto lotto) {
        return new PurchaseLottoResponse(lotto.getNumbers());
    }

    public List<Integer> getLottoNumbers() {
        return lottoNumbers;
    }
}
