package christmas.constants;

import christmas.domain.Menu;
import christmas.domain.Menus;
import christmas.exception.OnlyBeverageOrderException;
import java.util.List;

public enum CategoryMenu {
    APPETIZER("에피타이저", MenuBoard.APPETIZER_MENU),
    MAIN("메인", MenuBoard.MAIN_MENU),
    DESSERT("디저트", MenuBoard.DESSERT_MENU),
    BEVERAGE("음료", MenuBoard.BEVERAGE_MENU);


    private final String category;
    private final MenuBoard menuBoard;

    CategoryMenu(final String category, final MenuBoard menuBoard) {
        this.category = category;
        this.menuBoard = menuBoard;
    }

    public static void validateOnlyBeverageOrder(final List<Menu> menus) {
        if (isOnlyBeverageOrder(menus)) {
            throw new OnlyBeverageOrderException();
        }
    }

    private static boolean isOnlyBeverageOrder(final List<Menu> menus) {
        Menus beverageMenus = MenuBoard.BEVERAGE_MENU.getMenus();
        return menus.stream()
                .map(Menu::getMenuName)
                .allMatch(beverageMenus::isContainMenuName);
    }

    public Long getDiscountMenuCount(final Menus orderMenus) {
        return this.menuBoard.matchingOrderMenuCount(orderMenus);
    }
}
