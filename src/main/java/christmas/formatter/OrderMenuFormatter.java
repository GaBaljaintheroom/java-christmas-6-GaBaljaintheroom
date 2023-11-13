package christmas.formatter;

import christmas.domain.Menu;
import christmas.domain.Menus;

public final class OrderMenuFormatter {

    private static final String ORDER_MENU = "<주문 메뉴>\n";
    private static final String ORDER_MENU_FORM = "%s %s개\n";
    private static final StringBuilder sb = new StringBuilder();

    private OrderMenuFormatter() {
    }

    public static String showOrderMenus(final Menus orderMenus) {
        sb.append(ORDER_MENU);
        orderMenus.getValues()
                .forEach(OrderMenuFormatter::getAppend);
        return sb.toString();
    }

    private static void getAppend(final Menu menu) {
        sb.append(
                String.format(ORDER_MENU_FORM, menu.getMenuNameValue(), menu.getMenuAmountValue()));
    }
}
