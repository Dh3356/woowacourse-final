package menu.controller;

import java.util.List;
import java.util.stream.Collectors;
import menu.controller.retryer.Retryer;
import menu.model.coach.Coach;
import menu.model.menu.Menu;
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

        Retryer.retryOnCustomException(() -> setUnableMenus(coaches));
    }

    private List<Coach> makeCoaches() {
        List<String> coachNames = Retryer.retryOnCustomException(inputView::inputCoachNames);
        return coachNames.stream()
                .map(Coach::from)
                .collect(Collectors.toList());
    }

    private void setUnableMenus(final List<Coach> coaches) {
        coaches.forEach(coach -> {
            inputView.inputUnableMenus(coach.getName())
                    .forEach(menu -> coach.addUnableMenu(Menu.from(menu)));
        });
    }
}
