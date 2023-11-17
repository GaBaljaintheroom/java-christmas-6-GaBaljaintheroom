package christmas.domain.preview;

public class TotalOrderPrice {

    private static final Integer EXPECTED_ORDER_PRICE = 120_000;
    private static final Integer EVENT_APPLIED_PRICE = 10_000;
    private final Integer orderPrice;

    private TotalOrderPrice(final Integer orderPrice) {
        this.orderPrice = orderPrice;
    }

    public static TotalOrderPrice from(final Integer orderPrice) {
        return new TotalOrderPrice(orderPrice);
    }

    public Boolean canGiveawayEvent() {
        return orderPrice >= EXPECTED_ORDER_PRICE;
    }

    public Boolean canApplyEvent() {
        return orderPrice >= EVENT_APPLIED_PRICE;
    }

    public Integer getOrderPrice() {
        return orderPrice;
    }
}
