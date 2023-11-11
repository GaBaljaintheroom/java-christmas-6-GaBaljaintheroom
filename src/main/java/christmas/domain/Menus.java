package christmas.domain;

import christmas.constants.MenuBoard;

import java.util.List;

public class Menus {

    private final List<Menu> values;

    private Menus(final List<Menu> values) {
        MenuBoard.validateExistMenu(values);
        this.values = values;
    }

    public static Menus from(final List<Menu> values) {
        return new Menus(values);
    }

    public boolean isContainMenuBoard(final Menu menu) {
        return values.contains(menu);
    }
}
