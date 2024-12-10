package lotto.view.output;

import lotto.view.response.ModelResponse;

public class ConsoleOutputView implements OutputView {


    @Override
    public void output(final ModelResponse response) {
        System.out.print(response.getData());
    }

    private String formatToWon(final int value) {
        return String.format("%,d", value);
    }
}
