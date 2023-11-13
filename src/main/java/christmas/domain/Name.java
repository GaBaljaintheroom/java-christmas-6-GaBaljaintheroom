package christmas.domain;

import java.util.Objects;

public class Name {

    private final String menuName;

    private Name(final String menuName) {
        this.menuName = menuName;
    }

    public static Name from(final String menuName) {
        return new Name(menuName);
    }

    public String getMenuName() {
        return menuName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Name name = (Name) o;
        return menuName.equals(name.menuName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(menuName);
    }
}
