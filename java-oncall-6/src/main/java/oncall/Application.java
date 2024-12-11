package oncall;

import oncall.controller.Controller;
import oncall.model.policy.DayOffPolicy;
import oncall.model.policy.DefaultDayOffPolicy;
import oncall.view.input.ConsoleInputView;
import oncall.view.input.InputView;
import oncall.view.output.ConsoleOutputView;
import oncall.view.output.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView consoleInputView = new ConsoleInputView();
        OutputView consoleOutputView = new ConsoleOutputView();

        DayOffPolicy defaultDayOffPolicy = new DefaultDayOffPolicy();

        Controller controller = new Controller(
                consoleInputView,
                consoleOutputView,
                defaultDayOffPolicy
        );

        controller.run();
    }
}
