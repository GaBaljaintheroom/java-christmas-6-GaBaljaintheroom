package christmas.domain;

import christmas.constants.DaysEventCategory;

public class DaysDiscount {

    private static final Integer NO_DISCOUNT = 0;
    private final Integer discount;
    private final String dayType;

    private DaysDiscount(Integer discount, String dayType) {
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
        return NO_DISCOUNT;
    }

    public Integer getDiscount() {
        return discount;
    }

    public String getDayType() {
        return dayType;
    }
}
