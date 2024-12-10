package lotto.view.response.result;

import java.util.Objects;
import lotto.model.LottoRank;

public class LottoRankResponse {

    private final int matchCount;
    private final int prize;
    private final boolean isBonusMatch;

    private LottoRankResponse(final int matchCount, final int prize, final boolean isBonusMatch) {
        this.matchCount = matchCount;
        this.prize = prize;
        this.isBonusMatch = isBonusMatch;
    }

    public static LottoRankResponse from(final LottoRank lottoRank) {
        return new LottoRankResponse(
                lottoRank.getMatchCount(),
                lottoRank.getPrize(),
                lottoRank.isBonusMatch()
        );
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LottoRankResponse that = (LottoRankResponse) o;
        return matchCount == that.matchCount && prize == that.prize && isBonusMatch == that.isBonusMatch;
    }

    @Override
    public int hashCode() {
        return Objects.hash(matchCount, prize, isBonusMatch);
    }
}
