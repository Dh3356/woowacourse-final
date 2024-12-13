package calculator.view.output;

public class ConsoleOutputView implements OutputView {

    private String formatToWon(final int value) {
        return String.format("%,d", value);
    }
}
