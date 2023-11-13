package christmas.domain;

import christmas.exception.InvalidDateException;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;

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

    public Integer getDayOfMonth() {
        return currentDate.getDayOfMonth();
    }

    public String getDayOfWeek() {
        return currentDate.getDayOfWeek()
                .getDisplayName(TextStyle.FULL, Locale.KOREAN);
    }
}
