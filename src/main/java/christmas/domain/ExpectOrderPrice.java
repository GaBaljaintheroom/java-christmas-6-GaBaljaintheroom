package christmas.domain;

public class ExpectOrderPrice {

    private final Integer expectPrice;

    private ExpectOrderPrice(Integer orderPrice) {
        this.expectPrice = orderPrice;
    }

    public static ExpectOrderPrice from(Integer expectOrderPrice) {
        return new ExpectOrderPrice(expectOrderPrice);
    }

    public Integer getExpectPrice() {
        return expectPrice;
    }
}
