package baseball.view.output;

import baseball.model.Score;
import java.util.List;

public interface OutputView {

    void printStartMessage();

    void printResult(List<Score> scores);

    void printEndMessage();
}
