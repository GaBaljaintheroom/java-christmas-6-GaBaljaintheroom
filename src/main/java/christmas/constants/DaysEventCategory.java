package christmas.constants;

import christmas.domain.Menus;
import christmas.exception.NotFoundCategoryMenuByDay;

import java.util.Arrays;

public enum DaysEventCategory {
    MONDAY("월요일", CategoryMenu.DESSERT),
    TUESDAY("화요일", CategoryMenu.DESSERT),
    WEDNESDAY("수요일", CategoryMenu.DESSERT),
    THURSDAY("목요일", CategoryMenu.DESSERT),
    FRIDAY("금요일", CategoryMenu.MAIN),
    SATURDAY("토요일", CategoryMenu.MAIN);

    private static final Integer DISCOUNT_AMOUNT = 2_023;
    private final String day;
    private final CategoryMenu categoryMenu;

    DaysEventCategory(String day, CategoryMenu categoryMenu) {
        this.day = day;
        this.categoryMenu = categoryMenu;
    }

    public static Integer daysDiscount(String dayOfWeek, Menus orderMenus) {
        CategoryMenu categoryMenuByDay = findCategoryMenuByDay(dayOfWeek);
        Long discountMenuCount = categoryMenuByDay.getDiscountMenuCount(orderMenus);
        return discountMenuCount.intValue() * DISCOUNT_AMOUNT;
    }

    private static CategoryMenu findCategoryMenuByDay(String dayOfWeek) {
        return Arrays.stream(values())
                .filter(daysEventMenu -> daysEventMenu.day.equals(dayOfWeek))
                .findFirst()
                .map(daysEventMenu -> daysEventMenu.categoryMenu)
                .orElseThrow(NotFoundCategoryMenuByDay::new);
    }

}
