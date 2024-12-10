package lotto.view.response.result;

import static lotto.model.LottoRank.NONE;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import lotto.model.LottoRank;

public class LottoRankResponses {

    private final Map<LottoRankResponse, Integer> lottoRankResponses;

    private LottoRankResponses(final Map<LottoRankResponse, Integer> lottoRankResponses) {
        this.lottoRankResponses = lottoRankResponses;
    }

    public static LottoRankResponses from(final List<LottoRank> lottoRanks) {
        Map<LottoRankResponse, Integer> lottoRankResponses = getDefaultLottoRankResponses();

        lottoRanks.stream()
                .filter(lottoRank -> lottoRank != NONE)
                .map(LottoRankResponse::from)
                .forEach(lottoRankResponse -> {
                    lottoRankResponses.put(lottoRankResponse,
                            lottoRankResponses.get(lottoRankResponse) + 1);
                });

        return new LottoRankResponses(lottoRankResponses);
    }

    private static Map<LottoRankResponse, Integer> getDefaultLottoRankResponses() {
        Map<LottoRankResponse, Integer> lottoRankResponses = new LinkedHashMap<>();
        LottoRank.valuesWithoutNone().forEach(lottoRank -> {
            lottoRankResponses.put(LottoRankResponse.from(lottoRank), 0);
        });

        return lottoRankResponses;
    }

    public Map<LottoRankResponse, Integer> getLottoRankResponses() {
        return lottoRankResponses;
    }
}
