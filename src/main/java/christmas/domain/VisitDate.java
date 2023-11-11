package christmas.domain;

import christmas.exception.InvalidDateException;

import java.time.LocalDate;

public class VisitDate {

    private static final int CURRENT_YEAR = 2023;
    private static final int CURRENT_MONTH = 12;

    private static final int START_DAY = 1;
    private static final int LAST_DAY = 31;

    private final LocalDate currentDate;

    public VisitDate(final int currentDate) {
        validateDatePeriod(currentDate);
        this.currentDate = LocalDate.of(CURRENT_YEAR, CURRENT_MONTH, currentDate);
    }

    private void validateDatePeriod(final int currentDate) {
        if (currentDate < START_DAY || currentDate > LAST_DAY) {
            throw new InvalidDateException();
        }
    }

    public Integer getDay() {
        return currentDate.getDayOfMonth();
    }
}
