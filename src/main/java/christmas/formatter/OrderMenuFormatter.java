package christmas.formatter;

import christmas.constants.PreviewElement;
import christmas.constants.PreviewElementForm;
import christmas.domain.Menu;
import christmas.domain.Menus;

public final class OrderMenuFormatter {

    private static final StringBuilder sb = new StringBuilder();

    private OrderMenuFormatter() {
    }

    public static String showOrderMenus(final Menus orderMenus) {
        sb.append(PreviewElement.ORDER_MENU.getElement());
        orderMenus.getValues()
                .forEach(OrderMenuFormatter::getAppend);
        return sb.toString();
    }

    private static void getAppend(final Menu menu) {
        sb.append(
                String.format(PreviewElementForm.ORDER_MENU_FORM.getForm(), menu.getMenuNameValue(), menu.getMenuAmountValue()));
    }
}
