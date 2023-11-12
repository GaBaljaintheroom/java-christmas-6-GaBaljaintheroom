package christmas.constants;

import christmas.domain.TotalOrderPrice;

import java.util.Arrays;

public enum SpecialEventDay {
    THREE(3),
    TEN(10),
    SEVENTEEN(17),
    TWENTY_FOUR(24),
    TWENTY_FIVE(25),
    THIRTY_ONE(31);

    private final Integer day;

    SpecialEventDay(Integer day) {
        this.day = day;
    }

    public static Integer specialDayEventDiscount(TotalOrderPrice totalOrderPrice, Integer dayOfMonth) {
        if (Boolean.TRUE.equals(totalOrderPrice.canApplyEvent())) {
            return Arrays.stream(values())
                    .filter(specialEventDay -> specialEventDay.day.equals(dayOfMonth))
                    .findFirst()
                    .map(specialEventDay -> 1_000)
                    .orElse(0);
        }
        return 0;
    }
}
