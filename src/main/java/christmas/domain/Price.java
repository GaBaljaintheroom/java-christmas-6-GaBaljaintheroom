package christmas.domain;

public class Price {

    private final Integer menuPrice;

    private Price(Integer menuPrice) {
        this.menuPrice = menuPrice;
    }

    public static Price from(Integer menuPrice) {
        return new Price(menuPrice);
    }

    public Integer getMenuPrice() {
        return menuPrice;
    }
}
