package christmas.constants;

import christmas.domain.VisitDate;
import java.util.Arrays;

public enum SpecialEventDay {
    THREE(3),
    TEN(10),
    SEVENTEEN(17),
    TWENTY_FOUR(24),
    TWENTY_FIVE(25),
    THIRTY_ONE(31);

    private static final Integer SPECIAL_DISCOUNT = 1_000;
    private final Integer day;

    SpecialEventDay(final Integer day) {
        this.day = day;
    }

    public static Integer specialDayEventDiscount(final VisitDate visitDate) {
        return Arrays.stream(values())
                .filter(specialEventDay -> specialEventDay.day.equals(visitDate.getDayOfMonth()))
                .findFirst()
                .map(specialEventDay -> SPECIAL_DISCOUNT)
                .orElse(ChristmasRule.NO_DISCOUNT.getValue());
    }
}
