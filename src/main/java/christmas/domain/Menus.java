package christmas.domain;

import christmas.exception.InvalidOrderException;

import java.util.List;

public class Menus {

    private final List<Menu> values;

    private Menus(final List<Menu> values) {
        validateDuplicateMenu(values);
        this.values = values;
    }

    public static Menus from(final List<Menu> values) {
        return new Menus(values);
    }

    private void validateDuplicateMenu(List<Menu> values) {
        if (isDuplicatedMenus(values)) {
            throw new InvalidOrderException();
        }
    }

    private boolean isDuplicatedMenus(List<Menu> values) {
        return values.size() != getMenuCount(values);
    }

    private long getMenuCount(List<Menu> values) {
        return values.stream()
                .map(Menu::getMenuName)
                .distinct()
                .count();
    }

    public boolean isContainMenuName(final Name name) {
        return values.stream()
                .map(Menu::getMenuName)
                .anyMatch(menuName -> menuName.equals(name));
    }
}
