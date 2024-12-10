package lotto;

import lotto.controller.LottoController;
import lotto.model.generator.DefaultNumberGenerator;
import lotto.model.generator.NumberGenerator;
import lotto.view.input.ConsoleInputView;
import lotto.view.input.InputView;
import lotto.view.output.ConsoleOutputView;
import lotto.view.output.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView consoleInputView = new ConsoleInputView();
        OutputView consoleOutputView = new ConsoleOutputView();
        NumberGenerator defaultNumberGenerator = new DefaultNumberGenerator();

        LottoController controller = new LottoController(
                consoleInputView,
                consoleOutputView,
                defaultNumberGenerator
        );

        controller.run();
    }
}
