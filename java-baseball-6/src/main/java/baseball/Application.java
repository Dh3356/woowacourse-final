package baseball;

import baseball.controller.Controller;
import baseball.view.input.ConsoleInputView;
import baseball.view.input.InputView;
import baseball.view.output.ConsoleOutputView;
import baseball.view.output.OutputView;

public class Application {

    public static void main(String[] args) {
        InputView consoleInputView = new ConsoleInputView();
        OutputView consoleOutputView = new ConsoleOutputView();

        Controller controller = new Controller(
                consoleInputView,
                consoleOutputView
        );

        controller.run();
    }
}
