package christmas.domain;

public class ExpectOrderPrice {
    private final Integer expectPrice;

    private ExpectOrderPrice(Integer orderPrice) {
        this.expectPrice = orderPrice;
    }

    public static ExpectOrderPrice from(TotalOrderPrice totalOrderPrice) {
        return new ExpectOrderPrice(totalOrderPrice.getOrderPrice());
    }

    public Integer getExpectPrice() {
        return expectPrice;
    }
}
