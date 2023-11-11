package christmas.domain;

public class TotalOrderPrice {

    private final Integer orderPrice;

    private TotalOrderPrice(Integer orderPrice) {
        this.orderPrice = orderPrice;
    }

    public static TotalOrderPrice from(Integer orderPrice) {
        return new TotalOrderPrice(orderPrice);
    }

    public Integer getOrderPrice() {
        return orderPrice;
    }
}
