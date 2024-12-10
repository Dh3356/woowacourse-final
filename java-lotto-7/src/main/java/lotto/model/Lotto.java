package lotto.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.model.exception.LottoException;
import lotto.model.generator.NumberGenerator;

public class Lotto {

    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private static final int NUMBER_SIZE = 6;
    private final List<Integer> numbers;

    private Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public static Lotto make(final List<Integer> numbers) {
        return new Lotto(numbers);
    }

    public static Lotto generate(final NumberGenerator numberGenerator) {
        return new Lotto(numberGenerator.generate(MIN_NUMBER, MAX_NUMBER, NUMBER_SIZE));
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != NUMBER_SIZE) {
            throw LottoException.invalidNumberSize();
        }
        if (Set.copyOf(numbers).size() != NUMBER_SIZE) {
            throw LottoException.duplicateNumbers();
        }
        numbers.forEach(this::validateNumberRange);
    }

    private void validateNumberRange(final int number) {
        if (number < MIN_NUMBER || number > MAX_NUMBER) {
            throw LottoException.invalidNumberRange();
        }
    }

    public List<Integer> getNumbers() {
        return List.copyOf(numbers);
    }

    public int getMatchCount(final WinningLotto winningLotto) {
        Set<Integer> currentNumbers = new HashSet<>(this.numbers);
        long matchCount = winningLotto.getWinningNumbers()
                .stream()
                .filter(currentNumbers::contains)
                .count();

        return (int) matchCount;
    }

    public boolean containsBonusNumber(final WinningLotto winningLotto) {
        return this.numbers.contains(winningLotto.getBonusNumber());
    }

    @Override
    public String toString() {
        return "Lotto {"
                + "numbers=" + numbers;
    }
}
