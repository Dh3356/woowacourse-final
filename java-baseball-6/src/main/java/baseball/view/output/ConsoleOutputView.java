package baseball.view.output;

import static baseball.model.Score.BALL;
import static baseball.model.Score.NOTING;
import static baseball.model.Score.STRIKE;

import baseball.model.Score;
import java.util.List;

public class ConsoleOutputView implements OutputView {

    @Override
    public void printStartMessage() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    @Override
    public void printResult(List<Score> scores) {
        List<Score> balls = scores.stream().filter(score -> score == BALL).toList();
        List<Score> strikes = scores.stream().filter(score -> score == STRIKE).toList();

        if (balls.isEmpty() && strikes.isEmpty()) {
            System.out.println(NOTING.getName());
            return;
        }
        if (!balls.isEmpty()) {
            System.out.printf("%d%s ", balls.size(), BALL.getName());
        }
        if (!strikes.isEmpty()) {
            System.out.printf("%d%s ", strikes.size(), STRIKE.getName());
        }
        System.out.println();
    }

    @Override
    public void printEndMessage() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }
}
