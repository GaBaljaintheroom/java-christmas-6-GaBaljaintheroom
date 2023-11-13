package christmas.domain;

public class SpecialEventDiscount {

    private static final Integer NO_DISCOUNT = 0;
    private final Integer discount;

    private SpecialEventDiscount(Integer discount) {
        this.discount = discount;
    }

    public static SpecialEventDiscount from(final TotalOrderPrice totalOrderPrice, final Integer discount) {
        Integer totalDiscount = applyDiscount(totalOrderPrice, discount);
        return new SpecialEventDiscount(totalDiscount);
    }

    private static Integer applyDiscount(final TotalOrderPrice totalOrderPrice, final Integer discount) {
        if (Boolean.TRUE.equals(totalOrderPrice.canApplyEvent())) {
            return discount;
        }
        return NO_DISCOUNT;
    }

    public Integer getDiscount() {
        return discount;
    }
}
