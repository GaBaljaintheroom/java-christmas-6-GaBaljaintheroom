package christmas.domain;

import java.util.Objects;

public class Menu {
    private final Name menuName;
    private final Price menuPrice;

    private Menu(final Name name, final Price price) {
        this.menuName = name;
        this.menuPrice = price;
    }

    public static Menu of(final Name name, final Price price) {
        return new Menu(name, price);
    }

    public Name getMenuName() {
        return menuName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Menu menu = (Menu) o;
        return menuName.equals(menu.menuName) && menuPrice.equals(menu.menuPrice);
    }

    @Override
    public int hashCode() {
        return Objects.hash(menuName, menuPrice);
    }
}
