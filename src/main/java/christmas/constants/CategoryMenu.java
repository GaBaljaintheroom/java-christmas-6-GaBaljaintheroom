package christmas.constants;

import christmas.domain.Menu;
import christmas.domain.Menus;
import christmas.exception.InvalidOrderException;

import java.util.List;

public enum CategoryMenu {
    APPETIZER("에피타이저", MenuBoard.APPETIZER_MENU),
    MAIN("메인", MenuBoard.BEVERAGE_MENU),
    DESSERT("디저트", MenuBoard.BEVERAGE_MENU),
    BEVERAGE("음료", MenuBoard.BEVERAGE_MENU);


    private final String category;
    private final MenuBoard menuBoard;

    CategoryMenu(String category, MenuBoard menuBoard) {
        this.category = category;
        this.menuBoard = menuBoard;
    }

    public static void validateOnlyBeverageOrder(List<Menu> menus) {
        if (isOnlyBeverageOrder(menus)) {
            throw new InvalidOrderException();
        }
    }

    private static boolean isOnlyBeverageOrder(List<Menu> menus) {
        Menus beverageMenus = MenuBoard.BEVERAGE_MENU.getMenus();
        return menus.stream()
                .map(Menu::getMenuName)
                .allMatch(beverageMenus::isContainMenuName);
    }

}
