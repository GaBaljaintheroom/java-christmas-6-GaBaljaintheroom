package christmas.domain.preview;

import christmas.constants.ChristmasRule;
import christmas.domain.VisitDate;

public class ChristmasDDayDiscount {

    private static final Integer FIRST_EVENT_DAY = 1;
    private static final Integer LAST_EVENT_DAY = 25;
    private static final Integer DEFAULT_DISCOUNT = 1000;
    private static final Integer BONUS = 100;
    private final Integer discount;

    private ChristmasDDayDiscount(final Integer discount) {
        this.discount = discount;
    }

    public static ChristmasDDayDiscount from(final TotalOrderPrice totalOrderPrice, final VisitDate visitDate) {
        Integer discount = applyDiscount(totalOrderPrice, visitDate);
        return new ChristmasDDayDiscount(discount);
    }

    private static Integer applyDiscount(final TotalOrderPrice totalOrderPrice, final VisitDate visitDate) {
        if (Boolean.TRUE.equals(totalOrderPrice.canApplyEvent()) && canApplyDDayDiscount(visitDate)) {
            return getDiscount(visitDate);
        }
        return ChristmasRule.NO_DISCOUNT.getValue();
    }

    private static boolean canApplyDDayDiscount(final VisitDate visitDate) {
        return visitDate.getDayOfMonth() <= LAST_EVENT_DAY;
    }

    private static Integer getDiscount(final VisitDate visitDate) {
        Integer additionalDiscount = (visitDate.getDayOfMonth() - FIRST_EVENT_DAY) * BONUS;
        return DEFAULT_DISCOUNT + additionalDiscount;
    }

    public Integer getDiscount() {
        return discount;
    }
}
