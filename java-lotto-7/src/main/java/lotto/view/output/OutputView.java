package lotto.view.output;

import lotto.view.response.purchase.PurchaseLottoResponses;
import lotto.view.response.result.LottoRankResponses;
import lotto.view.response.result.LottoWinningRateResponse;

public interface OutputView {

    void printPurchasedLottos(final PurchaseLottoResponses response);

    void printLottoRanks(final LottoRankResponses response);

    void printWinningRate(final LottoWinningRateResponse response);
}
