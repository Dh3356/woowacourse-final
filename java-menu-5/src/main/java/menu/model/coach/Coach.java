package menu.model.coach;

import java.util.List;
import java.util.Objects;
import menu.model.coach.vo.coach_name.CoachName;
import menu.model.coach.vo.unable_menus.UnableMenus;
import menu.model.menu.Menu;

public class Coach {

    private final CoachName name;
    private final UnableMenus unableMenus = UnableMenus.empty();

    private Coach(CoachName name) {
        this.name = name;
    }

    public static Coach from(String name) {
        return new Coach(CoachName.from(name));
    }

    public void addUnableMenus(List<Menu> menu) {
        unableMenus.addAll(menu);
    }

    public boolean isUnableMenu(Menu menu) {
        return unableMenus.contains(menu);
    }

    public String getName() {
        return name.getValue();
    }

    public List<Menu> getUnableMenus() {
        return unableMenus.getValues();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Coach coach = (Coach) o;
        return Objects.equals(name, coach.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }

    @Override
    public String toString() {
        return "Coach{" +
                "name=" + name +
                ", unableMenus=" + unableMenus +
                '}';
    }
}
