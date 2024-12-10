package lotto.model;

import java.util.Arrays;
import java.util.List;
import lotto.model.exception.LottoRankException;

public enum LottoRank {

    NONE(0, 0, false),
    THREE(3, 5_000, false),
    FOUR(4, 50_000, false),
    FIVE(5, 1_500_000, false),
    FIVE_WITH_BONUS(5, 30_000_000, true),
    SIX(6, 2_000_000_000, false);

    private final int matchCount;
    private final int prize;
    private final boolean isBonusMatch;

    LottoRank(final int matchCount, final int prize, final boolean isBonusMatch) {
        this.matchCount = matchCount;
        this.prize = prize;
        this.isBonusMatch = isBonusMatch;
    }

    public static LottoRank calculate(final Lotto lotto, final WinningLotto winningLotto) {
        int matchCount = lotto.getMatchCount(winningLotto);
        boolean isBonusMatch = lotto.containsBonusNumber(winningLotto);

        if (matchCount < 3) {
            return NONE;
        }
        if (matchCount == 3) {
            return THREE;
        }
        if (matchCount == 4) {
            return FOUR;
        }
        if (matchCount == 5 && isBonusMatch) {
            return FIVE_WITH_BONUS;
        }
        if (matchCount == 5) {
            return FIVE;
        }
        if (matchCount == 6) {
            return SIX;
        }
        throw LottoRankException.cannotCalculate();
    }

    public static List<LottoRank> valuesWithoutNone() {
        return Arrays.stream(values()).filter(value -> value != NONE).toList();
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getPrize() {
        return prize;
    }

    public boolean isBonusMatch() {
        return isBonusMatch;
    }
}
