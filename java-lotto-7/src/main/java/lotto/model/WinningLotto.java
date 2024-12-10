package lotto.model;

import java.util.List;
import java.util.Set;
import lotto.model.exception.WinningLottoException;

public class WinningLotto {

    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private static final int WINNING_NUMBER_SIZE = 6;

    private final List<Integer> winningNumbers;
    private final int bonusNumber;

    private WinningLotto(final List<Integer> winningNumbers, final int bonusNumber) {
        validateWinningNumbers(winningNumbers);
        validateBonusNumber(winningNumbers, bonusNumber);
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public static WinningLotto make(final List<Integer> winningNumbers, final int bonusNumber) {
        return new WinningLotto(winningNumbers, bonusNumber);
    }

    private void validateWinningNumbers(final List<Integer> winningNumbers) {
        if (winningNumbers.size() != WINNING_NUMBER_SIZE) {
            throw WinningLottoException.invalidWinningNumberSize();
        }
        if (Set.copyOf(winningNumbers).size() != WINNING_NUMBER_SIZE) {
            throw WinningLottoException.duplicateWinningNumbers();
        }
        winningNumbers.forEach(this::validateNumberRange);
    }

    private void validateBonusNumber(final List<Integer> winningNumbers, final int bonusNumber) {
        if (winningNumbers.contains(bonusNumber)) {
            throw WinningLottoException.winningNumberContainsBonus();
        }
        validateNumberRange(bonusNumber);
    }

    private void validateNumberRange(final int number) {
        if (number < MIN_NUMBER || number > MAX_NUMBER) {
            throw WinningLottoException.invalidWinningNumberRange();
        }
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    @Override
    public String toString() {
        return "WinningLotto {"
                + "winningNumbers=" + winningNumbers
                + ", bonusNumber=" + bonusNumber;
    }
}
