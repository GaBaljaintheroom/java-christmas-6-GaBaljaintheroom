package christmas.io;

import christmas.constants.CategoryMenu;
import christmas.constants.MenuBoard;
import christmas.domain.*;

import java.util.Arrays;
import java.util.List;

public class InputMapper {

    private static final String DIVISION_COMMA = ",";
    private static final String DIVISION_MINUS = "-";
    private static final int FIRST_ELEMENT = 0;
    private static final int SECOND_ELEMENT = 1;

    public VisitDate toVisitDate(final String visitDate) {
        return VisitDate.from(Integer.parseInt(visitDate));
    }

    public Menus toMenus(final String orders) {
        List<Menu> menus = getSplitMenus(orders);
        MenuBoard.validateExistMenu(menus);
        CategoryMenu.validateOnlyBeverageOrder(menus);
        return Menus.from(menus);
    }

    private List<Menu> getSplitMenus(String orders) {
        return Arrays.stream(orders.split(DIVISION_COMMA))
                .map(this::toMenu)
                .toList();
    }

    private Menu toMenu(final String order) {
        String[] split = order.split(DIVISION_MINUS);
        Name name = Name.from(split[FIRST_ELEMENT]);
        Amount amount = Amount.from(Integer.parseInt(split[SECOND_ELEMENT]));
        return Menu.of(name, amount);
    }
}
