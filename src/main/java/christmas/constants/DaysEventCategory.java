package christmas.constants;

import christmas.domain.Menus;
import christmas.domain.TotalOrderPrice;
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

    public static Integer daysDiscount(TotalOrderPrice totalOrderPrice, String dayOfWeek, Menus orderMenus) {
        if (Boolean.TRUE.equals(totalOrderPrice.canApplyEvent())) {
            CategoryMenu categoryMenuByDay = findCategoryMenuByDay(dayOfWeek);
            Long discountMenuCount = categoryMenuByDay.getDiscountMenuCount(orderMenus);
            return discountMenuCount.intValue() * DISCOUNT_AMOUNT;
        }
        return 0;
    }

    private static CategoryMenu findCategoryMenuByDay(String dayOfWeek) {
        return Arrays.stream(values())
                .filter(daysEventMenu -> daysEventMenu.day.equals(dayOfWeek))
                .findFirst()
                .map(daysEventMenu -> daysEventMenu.categoryMenu)
                .orElseThrow(NotFoundCategoryMenuByDay::new);
    }

}
