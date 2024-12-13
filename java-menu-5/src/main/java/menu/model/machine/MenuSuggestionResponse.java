package menu.model.machine;

import java.time.DayOfWeek;
import java.util.List;
import java.util.Objects;
import menu.model.category.Category;

public class MenuSuggestionResponse {

    private final DayOfWeek dayOfWeek;
    private final Category category;
    private final List<MenuResponse> menuResponses;

    public MenuSuggestionResponse(DayOfWeek dayOfWeek, Category category,
                                  List<MenuResponse> menuResponses) {
        this.dayOfWeek = dayOfWeek;
        this.category = category;
        this.menuResponses = menuResponses;
    }

    public DayOfWeek getDayOfWeek() {
        return dayOfWeek;
    }

    public Category getCategory() {
        return category;
    }

    public List<MenuResponse> getMenuResponses() {
        return menuResponses;
    }

    @Override
    public String toString() {
        return "MenuSuggestionResponse{" +
                "dayOfWeek=" + dayOfWeek +
                ", category=" + category +
                ", menuResponses=" + menuResponses +
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
        MenuSuggestionResponse that = (MenuSuggestionResponse) o;
        return dayOfWeek == that.dayOfWeek && category == that.category && Objects.equals(menuResponses,
                that.menuResponses);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dayOfWeek, category, menuResponses);
    }
}
