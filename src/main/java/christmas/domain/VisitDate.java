package christmas.domain;

import christmas.exception.InvalidDateException;

import java.time.LocalDate;

public class VisitDate {

    private static final int CURRENT_YEAR = 2023;
    private static final int CURRENT_MONTH = 12;

    private static final int START_DAY = 1;
    private static final int LAST_DAY = 31;

    private final LocalDate currentDate;

    private VisitDate(final int currentDate) {
        validateDatePeriod(currentDate);
        this.currentDate = LocalDate.of(CURRENT_YEAR, CURRENT_MONTH, currentDate);
    }

    public static VisitDate from(final int currentDate) {
        return new VisitDate(currentDate);
    }

    private void validateDatePeriod(final int currentDate) {
        if (currentDate < START_DAY || currentDate > LAST_DAY) {
            throw new InvalidDateException();
        }
    }

    public Integer getDay() {
        return currentDate.getDayOfMonth();
    }

    public Integer christmasDDayDiscount(TotalOrderPrice totalOrderPrice) {
        int discount = 0;
        if (Boolean.TRUE.equals(totalOrderPrice.canApplyEvent()) && canApplyDDayDiscount()) {
            discount += 1000;
            for (int i = 1; i < currentDate.getDayOfMonth(); i++) {
                discount += 100;
            }
        }
        return discount;
    }

    private boolean canApplyDDayDiscount() {
        int day = currentDate.getDayOfMonth();
        return day <= 25;
    }
}
