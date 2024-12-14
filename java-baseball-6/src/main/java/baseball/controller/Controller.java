package baseball.controller;

import baseball.model.Computer;
import baseball.model.Score;
import baseball.view.input.InputView;
import baseball.view.output.OutputView;
import java.util.List;

public class Controller {

    private final InputView inputView;
    private final OutputView outputView;
    private boolean isGameEnd = false;

    public Controller(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        outputView.printStartMessage();
        Computer computer = Computer.create();
        while (!isGameEnd) {
            List<Integer> inputNumbers = inputView.inputNumbers();
            List<Score> scores = computer.calculateScores(inputNumbers);
            outputView.printResult(scores);

            isGameEnd = computer.isGameEnd(scores);
            if (isGameEnd) {
                outputView.printEndMessage();
                isGameEnd = !inputView.inputContinueGame();
                if (!isGameEnd) {
                    computer = Computer.create();
                }
            }
        }
    }
}
