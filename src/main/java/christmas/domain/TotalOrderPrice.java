package christmas.domain;

public class TotalOrderPrice {

    private static final Integer EXPECTED_ORDER_PRICE = 120_000;
    private final Integer orderPrice;

    private TotalOrderPrice(Integer orderPrice) {
        this.orderPrice = orderPrice;
    }

    public static TotalOrderPrice from(Integer orderPrice) {
        return new TotalOrderPrice(orderPrice);
    }

    public Boolean canGiveawayEvent() {
        return orderPrice >= EXPECTED_ORDER_PRICE;
    }

    public Integer getOrderPrice() {
        return orderPrice;
    }
}
