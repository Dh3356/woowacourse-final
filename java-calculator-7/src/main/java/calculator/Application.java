package calculator;

import calculator.controller.Controller;
import calculator.view.input.ConsoleInputView;
import calculator.view.input.InputView;
import calculator.view.output.ConsoleOutputView;
import calculator.view.output.OutputView;

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
