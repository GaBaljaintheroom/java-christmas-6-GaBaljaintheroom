package christmas.domain.preview;

public class ExpectPaymentPrice {

    private final Integer expectPrice;

    private ExpectPaymentPrice(final Integer expectOrderPrice) {
        this.expectPrice = expectOrderPrice;
    }

    public static ExpectPaymentPrice from(final Integer expectOrderPrice) {
        return new ExpectPaymentPrice(expectOrderPrice);
    }

    public Integer getExpectPrice() {
        return expectPrice;
    }
}
