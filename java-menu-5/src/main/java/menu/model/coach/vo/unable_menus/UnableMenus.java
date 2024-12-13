package menu.model.coach.vo.unable_menus;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import menu.model.menu.Menu;

public class UnableMenus {

    protected static final int MAX_SIZE = 2;
    private final List<Menu> values;

    private UnableMenus(List<Menu> values) {
        this.values = values;
    }

    public static UnableMenus empty() {
        return new UnableMenus(new ArrayList<>());
    }

    public void addAll(List<Menu> menus) {
        validate(menus);
        if (values.size() + menus.size() > MAX_SIZE) {
            throw UnableMenusException.sizeOver();
        }
        values.addAll(menus);
    }

    public boolean contains(Menu menu) {
        return values.contains(menu);
    }

    private void validate(List<Menu> values) {
        if (Set.copyOf(values).size() != values.size()) {
            throw UnableMenusException.conflict();
        }
    }

    public List<Menu> getValues() {
        return values;
    }

    @Override
    public String toString() {
        return "UnableMenus{" +
                "values=" + values +
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
        UnableMenus that = (UnableMenus) o;
        return Objects.equals(values, that.values);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(values);
    }
}
