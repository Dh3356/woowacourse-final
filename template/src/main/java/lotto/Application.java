package lotto;

import lotto.controller.Controller;
import lotto.view.input.ConsoleInputView;
import lotto.view.input.InputView;
import lotto.view.output.ConsoleOutputView;
import lotto.view.output.OutputView;

public class Application {

    private static final String ERROR_FORM = "[ERROR] %s\n\n";

    public static void main(String[] args) {
        InputView consoleInputView = new ConsoleInputView();
        OutputView consoleOutputView = new ConsoleOutputView();

        Controller controller = new Controller(
                consoleInputView,
                consoleOutputView
        );

        controller.run();
        System.out.printf(ERROR_FORM, "hello");
        System.out.print("---");
    }
}
