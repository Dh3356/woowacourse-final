package lotto.model.generator;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class DefaultNumberGenerator implements NumberGenerator {
    
    @Override
    public List<Integer> generate(final int startInclusive, final int endInclusive, final int count) {
        return Randoms.pickUniqueNumbersInRange(startInclusive, endInclusive, count);
    }
}
