package christmas.domain;

import java.util.List;

public class Menus {

    private final List<Menu> values;

    private Menus(final List<Menu> values) {
        this.values = values;
    }

    public static Menus from(final List<Menu> values) {
        return new Menus(values);
    }

    public boolean isContainMenuName(final Name name) {
        return values.stream()
                .map(Menu::getMenuName)
                .anyMatch(menuName -> menuName.equals(name));
    }
}
