package lotto.model;

import java.util.ArrayList;
import java.util.List;
import lotto.model.exception.LottoPurchaseException;
import lotto.model.generator.NumberGenerator;

public class LottoMachine {

    private static final int LOTTO_PRICE = 1_000;
    private final NumberGenerator numberGenerator;

    public LottoMachine(final NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    public List<Lotto> purchaseLottos(final int money) {
        validateMoney(money);
        int size = money / LOTTO_PRICE;
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            lottos.add(Lotto.generate(numberGenerator));
        }

        return lottos;
    }

    private void validateMoney(final int money) {
        if (money < LOTTO_PRICE) {
            throw LottoPurchaseException.purchaseMoneyTooSmall();
        }
        if (money % LOTTO_PRICE != 0) {
            throw LottoPurchaseException.purchaseMoneyNotDividable();
        }
    }
}
