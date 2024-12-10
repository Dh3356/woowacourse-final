package lotto.model.generator;

import java.util.List;

public interface NumberGenerator {

    List<Integer> generate(final int startInclusive, final int endInclusive, final int count);
}
