package menu.controller;

import java.util.List;
import java.util.stream.Collectors;
import menu.controller.retryer.Retryer;
import menu.model.Coach;
import menu.view.input.InputView;
import menu.view.output.OutputView;

public class Controller {

    private final InputView inputView;
    private final OutputView outputView;

    public Controller(final InputView inputView, final OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        outputView.printStartMessage();
        List<Coach> coaches = Retryer.retryOnCustomException(this::makeCoaches);
    }

    private List<Coach> makeCoaches() {
        List<String> coachNames = Retryer.retryOnCustomException(inputView::inputCoachNames);
        return coachNames.stream().map(Coach::from).collect(Collectors.toList());
    }
}
