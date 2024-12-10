package lotto.view.response.purchase;

import java.util.List;
import lotto.model.Lotto;

public class PurchaseLottoResponses {

    private final List<PurchaseLottoResponse> purchaseLottoResponses;

    private PurchaseLottoResponses(final List<PurchaseLottoResponse> purchaseLottoResponses) {
        this.purchaseLottoResponses = purchaseLottoResponses;
    }

    public static PurchaseLottoResponses from(final List<Lotto> lottos) {
        List<PurchaseLottoResponse> purchaseLottoResponses = lottos.stream().map(PurchaseLottoResponse::from).toList();
        return new PurchaseLottoResponses(purchaseLottoResponses);
    }

    public List<PurchaseLottoResponse> getPurchaseLottoResponses() {
        return purchaseLottoResponses;
    }
}
