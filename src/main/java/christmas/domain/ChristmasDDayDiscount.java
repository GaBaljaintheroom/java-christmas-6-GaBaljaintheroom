package christmas.domain;

public class ChristmasDDayDiscount {

    private final Integer discount;

    private ChristmasDDayDiscount(Integer discount) {
        this.discount = discount;
    }

    public static ChristmasDDayDiscount from(TotalOrderPrice totalOrderPrice, VisitDate visitDate) {
        Integer discount = calculateDiscount(totalOrderPrice, visitDate);
        return new ChristmasDDayDiscount(discount);
    }

    private static Integer calculateDiscount(TotalOrderPrice totalOrderPrice, VisitDate visitDate) {
        if (Boolean.TRUE.equals(totalOrderPrice.canApplyEvent()) && canApplyDDayDiscount(visitDate)) {
            return getDiscount(visitDate);
        }
        return 0;
    }

    private static boolean canApplyDDayDiscount(VisitDate visitDate) {
        return visitDate.getDayOfMonth() <= 25;
    }

    private static Integer getDiscount(VisitDate visitDate) {
        Integer baseDiscount = 1000;
        Integer additionalDiscount = (visitDate.getDayOfMonth() - 1) * 100;
        return baseDiscount + additionalDiscount;
    }
}
