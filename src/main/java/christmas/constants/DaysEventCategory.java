package christmas.constants;

import christmas.domain.menu.Menus;
import christmas.domain.VisitDate;
import christmas.exception.NotFoundCategoryMenuByDay;
import java.util.Arrays;

public enum DaysEventCategory {
    SUNDAY("일요일", CategoryMenu.DESSERT),
    MONDAY("월요일", CategoryMenu.DESSERT),
    TUESDAY("화요일", CategoryMenu.DESSERT),
    WEDNESDAY("수요일", CategoryMenu.DESSERT),
    THURSDAY("목요일", CategoryMenu.DESSERT),
    FRIDAY("금요일", CategoryMenu.MAIN),
    SATURDAY("토요일", CategoryMenu.MAIN);

    private static final Integer DISCOUNT_AMOUNT = 2_023;
    private static final String WEEKEND = "주말";
    private static final String WEEKDAY = "평일";
    private final String day;
    private final CategoryMenu categoryMenu;

    DaysEventCategory(final String day, final CategoryMenu categoryMenu) {
        this.day = day;
        this.categoryMenu = categoryMenu;
    }

    public static Integer daysDiscount(final VisitDate visitDate, final Menus orderMenus) {
        CategoryMenu categoryMenuByDay = findCategoryMenuByDay(visitDate.getDayOfWeek());
        Long discountMenuCount = categoryMenuByDay.getDiscountMenuCount(orderMenus);
        return discountMenuCount.intValue() * DISCOUNT_AMOUNT;
    }

    private static CategoryMenu findCategoryMenuByDay(final String dayOfWeek) {
        return Arrays.stream(values())
                .filter(daysEventMenu -> daysEventMenu.day.equals(dayOfWeek))
                .findFirst()
                .map(daysEventMenu -> daysEventMenu.categoryMenu)
                .orElseThrow(NotFoundCategoryMenuByDay::new);
    }

    public static String distinctionDayType(final VisitDate visitDate) {
        String dayOfWeek = visitDate.getDayOfWeek();
        if (FRIDAY.day.equals(dayOfWeek) || SATURDAY.day.equals(dayOfWeek)) {
            return WEEKEND;
        }
        return WEEKDAY;
    }
}
