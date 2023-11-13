package christmas.domain;

public class ExpectOrderPrice {

    private final Integer expectPrice;

    private ExpectOrderPrice(Integer orderPrice) {
        this.expectPrice = orderPrice;
    }

    public static ExpectOrderPrice from(final Integer expectOrderPrice) {
        return new ExpectOrderPrice(expectOrderPrice);
    }

    public Integer getExpectPrice() {
        return expectPrice;
    }
}
