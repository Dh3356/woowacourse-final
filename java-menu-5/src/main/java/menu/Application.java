package menu;

import menu.controller.Controller;
import menu.view.input.ConsoleInputView;
import menu.view.input.InputView;
import menu.view.output.ConsoleOutputView;
import menu.view.output.OutputView;

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
