package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class Computer {

    private final List<Integer> numbers;

    private Computer() {
        List<Integer> numbers = new ArrayList<>();
        while (numbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!numbers.contains(randomNumber)) {
                numbers.add(randomNumber);
            }
        }
        this.numbers = numbers;
    }

    public static Computer create() {
        return new Computer();
    }

    public List<Score> calculateScores(List<Integer> player) {
        validatePlayer(player);
        return Score.calculateScores(numbers, player);
    }

    public boolean isGameEnd(List<Score> scores) {
        return scores.stream().allMatch(score -> score == Score.STRIKE);
    }

    private void validatePlayer(List<Integer> player) {
        if (player.size() != 3) {
            throw new IllegalArgumentException("세 자리 정수가 아닙니다.");
        }
        if (Set.copyOf(player).size() != 3) {
            throw new IllegalArgumentException("중복되는 숫자가 존재합니다.");
        }
    }

    @Override
    public String toString() {
        return "Computer{" +
                "numbers=" + numbers +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Computer computer = (Computer) o;
        return Objects.equals(numbers, computer.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(numbers);
    }
}
