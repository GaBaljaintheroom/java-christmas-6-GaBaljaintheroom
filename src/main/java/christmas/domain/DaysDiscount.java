package christmas.domain;

public class DaysDiscount {

    private static final Integer NO_DISCOUNT = 0;
    private final Integer discount;

    private DaysDiscount(Integer discount) {
        this.discount = discount;
    }

    public static DaysDiscount from(TotalOrderPrice totalOrderPrice, Integer discount) {
        Integer totalDiscount = applyDiscount(totalOrderPrice, discount);
        return new DaysDiscount(totalDiscount);
    }

    private static Integer applyDiscount(TotalOrderPrice totalOrderPrice, Integer discount) {
        if (Boolean.TRUE.equals(totalOrderPrice.canApplyEvent())) {
            return discount;
        }
        return NO_DISCOUNT;
    }

}
