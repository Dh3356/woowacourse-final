package menu.model.menu;

import java.util.HashSet;
import java.util.Set;

public class Menus {

    private final Set<Menu> value;

    private Menus(final Set<Menu> menus) {
        this.value = menus;
    }

    public static Menus empty() {
        return new Menus(new HashSet<>());
    }

    public void add(final Menu menu) {
        if (value.contains(menu)) {
            throw MenuException.conflict();
        }
        value.add(menu);
    }

    @Override
    public String toString() {
        return "Menus{" +
                "value=" + value +
                '}';
    }
}
