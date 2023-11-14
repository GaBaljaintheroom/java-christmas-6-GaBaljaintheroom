package christmas.domain.preview;

public class ExpectOrderPrice {

    private final Integer expectPrice;

    private ExpectOrderPrice(final Integer expectOrderPrice) {
        this.expectPrice = expectOrderPrice;
    }

    public static ExpectOrderPrice from(final Integer expectOrderPrice) {
        return new ExpectOrderPrice(expectOrderPrice);
    }

    public Integer getExpectPrice() {
        return expectPrice;
    }
}
