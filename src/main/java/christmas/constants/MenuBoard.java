package christmas.constants;

import christmas.domain.Menu;
import christmas.domain.Menus;
import christmas.domain.Name;
import christmas.domain.Price;
import christmas.exception.InvalidOrderException;

import java.util.List;
import java.util.stream.Stream;

public enum MenuBoard {
    APPETIZER_MENU(Menus.from(Stream.of(
                    Menu.of(Name.from("양송이수프"), Price.from(6_000)),
                    Menu.of(Name.from("타파스"), Price.from(5_500)),
                    Menu.of(Name.from("시저샐러드"), Price.from(8_000)))
            .toList())),
    MAIN_MENU(Menus.from(Stream.of(
                    Menu.of(Name.from("티본스테이크"), Price.from(55_000)),
                    Menu.of(Name.from("바비큐립"), Price.from(54_000)),
                    Menu.of(Name.from("해산물파스타"), Price.from(35_000)),
                    Menu.of(Name.from("크리스마스파스타"), Price.from(25_000)))
            .toList())),
    DESSERT_MENU(Menus.from(Stream.of(
                    Menu.of(Name.from("초코케이크"), Price.from(15_000)),
                    Menu.of(Name.from("아이스크림"), Price.from(5_000)))
            .toList())),
    BEVERAGE_MENU(Menus.from(Stream.of(
                    Menu.of(Name.from("제로콜라"), Price.from(15_000)),
                    Menu.of(Name.from("레드와인"), Price.from(5_000)),
                    Menu.of(Name.from("샴페인"), Price.from(25_000)))
            .toList()));

    private final Menus menus;

    MenuBoard(Menus menus) {
        this.menus = menus;
    }

    public static void validateExistMenu(List<Menu> orderMenus) {
        if (isNotExistOrder(orderMenus)) {
            throw new InvalidOrderException();
        }
    }

    private static boolean isNotExistOrder(List<Menu> orderMenus) {
        return !orderMenus.stream()
                .map(Menu::getMenuName)
                .allMatch(name -> Stream.of(MenuBoard.values())
                        .anyMatch(menuBoard -> menuBoard.menus.isContainMenuName(name)));
    }

    public static Integer calculateTotalOrderPrice(Menus orderMenus) {
        return orderMenus.getValues().stream()
                .mapToInt(MenuBoard::calculateMenuPrice)
                .sum();
    }

    private static Integer calculateMenuPrice(Menu orderMenu) {
        return Stream.of(MenuBoard.values())
                .filter(menuBoard -> menuBoard.menus.isContainMenuName(orderMenu.getMenuName()))
                .findFirst()
                .map(menuBoard -> menuBoard.menus.getPriceValueByMenuName(orderMenu))
                .orElse(0);
    }


    public Menus getMenus() {
        return menus;
    }
}
