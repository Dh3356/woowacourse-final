package menu.model.machine;

import java.util.Objects;
import menu.model.coach.Coach;
import menu.model.menu.Menu;

public class MenuResponse {

    private final Coach coach;
    private final Menu menu;

    public MenuResponse(Coach coach, Menu menu) {
        this.coach = coach;
        this.menu = menu;
    }

    public Coach getCoach() {
        return coach;
    }

    public Menu getMenu() {
        return menu;
    }

    @Override
    public String toString() {
        return "MenuResponse{" +
                "coach=" + coach +
                ", menu=" + menu +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        MenuResponse that = (MenuResponse) o;
        return Objects.equals(coach, that.coach) && menu == that.menu;
    }

    @Override
    public int hashCode() {
        return Objects.hash(coach, menu);
    }
}
