package menu.view.input;

import java.util.List;

public interface InputView {

    List<String> inputCoachNames();

    List<String> inputUnableMenus(final String coachName);
}
