package christmas.domain;

import java.util.Objects;

public class Price {

    private final Integer menuPrice;

    private Price(Integer menuPrice) {
        this.menuPrice = menuPrice;
    }

    public static Price from(Integer menuPrice) {
        return new Price(menuPrice);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Price price = (Price) o;
        return menuPrice.equals(price.menuPrice);
    }

    @Override
    public int hashCode() {
        return Objects.hash(menuPrice);
    }
}
