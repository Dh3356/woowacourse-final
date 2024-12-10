package lotto.view.response.result;

import java.util.Map;

public class LottoWinningRateResponse {

    private final float winningRate;

    private LottoWinningRateResponse(final float winningRate) {
        this.winningRate = winningRate;
    }

    public static LottoWinningRateResponse from(final int purchaseMoney,
                                                final Map<LottoRankResponse, Integer> lottoRankResponses) {

        long totalProfit = 0;
        for (LottoRankResponse lottoRankResponse : lottoRankResponses.keySet()) {
            totalProfit += (long) lottoRankResponses.get(lottoRankResponse) * lottoRankResponse.getPrize();
        }

        return new LottoWinningRateResponse((float) totalProfit / purchaseMoney * 100);
    }

    public float getWinningRate() {
        return winningRate;
    }
}
