package lotto.controller;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import lotto.controller.retryer.Retryer;
import lotto.model.Lotto;
import lotto.model.LottoMachine;
import lotto.model.LottoRank;
import lotto.model.WinningLotto;
import lotto.model.generator.NumberGenerator;
import lotto.view.input.InputView;
import lotto.view.output.OutputView;
import lotto.view.response.purchase.PurchaseLottoResponses;
import lotto.view.response.result.LottoRankResponses;
import lotto.view.response.result.LottoWinningRateResponse;

public class LottoController {

    private final InputView inputView;
    private final OutputView outputView;

    private final LottoMachine lottoMachine;

    public LottoController(InputView inputView, OutputView outputView, NumberGenerator numberGenerator) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.lottoMachine = new LottoMachine(numberGenerator);
    }

    public void run() {
        AtomicInteger purchaseMoney = new AtomicInteger();
        List<Lotto> purchasedLottos = Retryer.retryOnCustomException(() -> purchaseLottos(purchaseMoney));

        outputView.printPurchasedLottos(PurchaseLottoResponses.from(purchasedLottos));

        WinningLotto winningLotto = Retryer.retryOnCustomException(this::makeWinningLotto);

        List<LottoRank> lottoRanks = calculateLottoRanks(purchasedLottos, winningLotto);

        LottoRankResponses lottoRankResponses = LottoRankResponses.from(lottoRanks);
        LottoWinningRateResponse lottoWinningRateResponse =
                LottoWinningRateResponse.from(purchaseMoney.get(), lottoRankResponses.getLottoRankResponses());

        outputView.printLottoRanks(lottoRankResponses);
        outputView.printWinningRate(lottoWinningRateResponse);
    }

    public List<Lotto> purchaseLottos(AtomicInteger purchaseMoney) {
        purchaseMoney.set(inputView.inputPurchaseMoney());
        return lottoMachine.purchaseLottos(purchaseMoney.get());
    }

    public WinningLotto makeWinningLotto() {
        List<Integer> winningNumbers = inputView.inputWinningNumbers();
        int bonusNumber = inputView.inputBonusNumber();

        return WinningLotto.make(winningNumbers, bonusNumber);
    }

    public List<LottoRank> calculateLottoRanks(List<Lotto> purchasedLottos, WinningLotto winningLotto) {
        return purchasedLottos.stream()
                .map(purchasedLotto -> LottoRank.calculate(purchasedLotto, winningLotto))
                .toList();
    }
}
