package christmas.domain;

public class Price {

    private final Integer menuPrice;

    private Price(final Integer menuPrice) {
        this.menuPrice = menuPrice;
    }

    public static Price from(final Integer menuPrice) {
        return new Price(menuPrice);
    }

    public Integer getMenuPrice() {
        return menuPrice;
    }
}
