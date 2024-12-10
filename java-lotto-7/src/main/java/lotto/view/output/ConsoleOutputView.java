package lotto.view.output;

import java.util.List;
import java.util.Map;
import lotto.view.response.purchase.PurchaseLottoResponse;
import lotto.view.response.purchase.PurchaseLottoResponses;
import lotto.view.response.result.LottoRankResponse;
import lotto.view.response.result.LottoRankResponses;
import lotto.view.response.result.LottoWinningRateResponse;

public class ConsoleOutputView implements OutputView {

    private static final String LOTTO_FORMAT = "[%s]";

    @Override
    public void printPurchasedLottos(final PurchaseLottoResponses response) {

        List<PurchaseLottoResponse> purchaseLottoResponses = response.getPurchaseLottoResponses();

        System.out.printf("\n%d개를 구매했습니다.\n", purchaseLottoResponses.size());

        purchaseLottoResponses.forEach(this::printPurchasedLotto);
    }

    @Override
    public void printLottoRanks(final LottoRankResponses response) {
        System.out.println("당첨 통계");
        System.out.println("---");
        Map<LottoRankResponse, Integer> lottoRankResponses = response.getLottoRankResponses();
        lottoRankResponses.forEach(this::printLottoRank);
    }

    @Override
    public void printWinningRate(LottoWinningRateResponse response) {
        System.out.printf("총 수익률은 %.1f%%입니다.", response.getWinningRate());
    }

    private void printLottoRank(final LottoRankResponse response, final int amount) {
        int matchCount = response.getMatchCount();
        int prize = response.getPrize();

        if (response.isBonusMatch()) {
            System.out.printf("%d개 일치, 보너스 볼 일치 (%s원) - %d개\n",
                    matchCount,
                    formatToWon(prize),
                    amount
            );
            return;
        }
        System.out.printf("%d개 일치 (%s원) - %d개\n",
                matchCount,
                formatToWon(prize),
                amount
        );
    }

    private void printPurchasedLotto(final PurchaseLottoResponse response) {
        List<String> lottoNumbers = response.getLottoNumbers()
                .stream()
                .sorted()
                .map(String::valueOf)
                .toList();

        System.out.printf((LOTTO_FORMAT) + "%n", String.join(", ", lottoNumbers));
    }

    private String formatToWon(final int value) {
        return String.format("%,d", value);
    }
}
