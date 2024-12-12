package menu.model.coach;

import menu.model.coach.vo.coach_name.CoachName;
import menu.model.menu.Menu;
import menu.model.menu.Menus;

public class Coach {

    private final CoachName name;
    private final Menus unableMenus = Menus.empty();

    private Coach(final String name) {
        this.name = CoachName.from(name);
    }

    public static Coach from(final String name) {
        return new Coach(name);
    }

    public void addUnableMenu(final Menu menu) {
        unableMenus.add(menu);
    }

    public String getName() {
        return name.getValue();
    }

    @Override
    public String toString() {
        return "Coach{" +
                "name=" + name +
                ", unableMenus=" + unableMenus +
                '}';
    }
}
