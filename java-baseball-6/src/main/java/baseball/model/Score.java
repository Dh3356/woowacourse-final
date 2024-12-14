package baseball.model;

import java.util.ArrayList;
import java.util.List;

public enum Score {
    BALL("볼"),
    STRIKE("스트라이크"),
    NOTING("낫싱");

    private final String name;

    Score(String name) {
        this.name = name;
    }

    public static List<Score> calculateScores(List<Integer> computer, List<Integer> player) {
        ArrayList<Integer> computerArrayList = new ArrayList<>(computer);
        ArrayList<Integer> playerArrayList = new ArrayList<>(player);

        List<Score> result = new ArrayList<>();
        result.addAll(getBallCount(computerArrayList, playerArrayList));
        result.addAll(getStrikeCount(computerArrayList, playerArrayList));

        if (result.isEmpty()) {
            return List.of(NOTING);
        }
        return result;
    }

    private static List<Score> getStrikeCount(ArrayList<Integer> computer, ArrayList<Integer> player) {
        List<Score> response = new ArrayList<>();
        for (int i = 0; i < player.size(); i++) {
            if (player.get(i).equals(computer.get(i))) {
                response.add(STRIKE);
            }
        }
        return response;
    }

    private static List<Score> getBallCount(ArrayList<Integer> computer, ArrayList<Integer> player) {
        List<Score> response = new ArrayList<>();
        for (int i = 0; i < player.size(); i++) {
            Integer value = player.get(i);
            if (computer.contains(value) && !computer.get(i).equals(value)) {
                response.add(BALL);
            }
        }
        return response;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Score{" +
                "name='" + name + '\'' +
                '}';
    }
}
