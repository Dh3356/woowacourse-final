package menu.controller;

import java.util.List;
import java.util.stream.Collectors;
import menu.controller.retryer.Retryer;
import menu.model.coach.Coach;
import menu.model.machine.MenuMachine;
import menu.model.machine.MenuSuggestionResponse;
import menu.model.menu.Menu;
import menu.view.input.InputView;
import menu.view.output.OutputView;

public class Controller {

    private final InputView inputView;
    private final OutputView outputView;

    private final MenuMachine menuMachine;

    public Controller(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.menuMachine = new MenuMachine();
    }

    public void run() {
        outputView.printStartMessage();
        List<Coach> coaches = Retryer.retryOnCustomException(this::getCoaches);
        Retryer.retryOnCustomException(() -> addUnableMenus(coaches));

        List<MenuSuggestionResponse> menuSuggestionResponses = menuMachine.suggestMenus(coaches);
        outputView.printMenuSuggestionResponses(menuSuggestionResponses);
        outputView.printEndMessage();
    }

    private List<Coach> getCoaches() {
        List<String> coachNames = Retryer.retryOnCustomException(inputView::inputCoachNames);
        List<Coach> coaches = coachNames.stream()
                .map(Coach::from)
                .collect(Collectors.toList());
        menuMachine.validateCoaches(coaches);
        return coaches;
    }

    private void addUnableMenus(List<Coach> coaches) {
        coaches.forEach(coach -> Retryer.retryOnCustomException(() -> addUnableMenu(coach)));
    }

    private void addUnableMenu(Coach coach) {
        List<Menu> unableMenus = Retryer.retryOnCustomException(() -> inputView.inputUnableMenuNames(coach.getName()))
                .stream()
                .map(Menu::from)
                .collect(Collectors.toList());
        coach.addUnableMenus(unableMenus);
    }
}
