package menu.view.output;

import java.util.List;
import menu.model.machine.MenuSuggestionResponse;

public interface OutputView {

    void printStartMessage();

    void printMenuSuggestionResponses(List<MenuSuggestionResponse> menuSuggestionResponses);

    void printEndMessage();
}
