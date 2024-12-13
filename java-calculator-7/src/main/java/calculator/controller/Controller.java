package calculator.controller;

import calculator.model.CustomDelimiterExtractor;
import calculator.model.DelimiterFactory;
import calculator.model.Delimiters;
import calculator.view.input.InputView;
import calculator.view.output.OutputView;
import java.util.List;

public class Controller {

    private final InputView inputView;
    private final OutputView outputView;

    private final CustomDelimiterExtractor customDelimiterExtractor = new CustomDelimiterExtractor();
    private final DelimiterFactory delimiterFactory = new DelimiterFactory(customDelimiterExtractor);

    public Controller(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        String input = inputView.input();
        Delimiters delimiters = Delimiters.fromFactory(input, delimiterFactory);
        String delimiterFormatRemovedInput = customDelimiterExtractor.removeCustomDelimiterFormat(input);
        List<Integer> numbers = delimiters.extract(delimiterFormatRemovedInput);
        System.out.println(numbers);
    }
}
