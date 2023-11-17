package christmas.domain.preview;

import christmas.constants.ChristmasRule;
import christmas.constants.DaysEventCategory;
import christmas.domain.VisitDate;

public class DaysDiscount {

    private final Integer discount;
    private final String dayType;

    private DaysDiscount(final Integer discount, final String dayType) {
        this.discount = discount;
        this.dayType = dayType;
    }

    public static DaysDiscount from(final TotalOrderPrice totalOrderPrice, final VisitDate visitDate,
                                    final Integer discount) {
        Integer totalDiscount = applyDiscount(totalOrderPrice, discount);
        String dayType = DaysEventCategory.distinctionDayType(visitDate);
        return new DaysDiscount(totalDiscount, dayType);
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

    public String getDayType() {
        return dayType;
    }
}
