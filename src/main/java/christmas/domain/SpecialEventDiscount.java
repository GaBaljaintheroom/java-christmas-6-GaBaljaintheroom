package christmas.domain;

import christmas.constants.ChristmasRule;

public class SpecialEventDiscount {

    private final Integer discount;

    private SpecialEventDiscount(final Integer discount) {
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
        return ChristmasRule.NO_DISCOUNT.getValue();
    }

    public Integer getDiscount() {
        return discount;
    }
}
