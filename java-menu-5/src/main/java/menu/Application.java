package menu;

import menu.controller.Controller;
import menu.view.output.ConsoleOutputView;
import menu.view.output.OutputView;

public class Application {
    public static void main(String[] args) {
        OutputView consoleOutputView = new ConsoleOutputView();

        Controller controller = new Controller(
                consoleOutputView
        );

        controller.run();
    }
}
