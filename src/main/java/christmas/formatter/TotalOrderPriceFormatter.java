package christmas.formatter;

import christmas.constants.PreviewElement;
import christmas.constants.PreviewElementForm;
import christmas.domain.TotalOrderPrice;

public final class TotalOrderPriceFormatter {

    private static final StringBuilder sb = new StringBuilder();

    private TotalOrderPriceFormatter() {
    }

    public static String showTotalOrderPrice(final TotalOrderPrice totalOrderPrice) {
        Integer orderPrice = totalOrderPrice.getOrderPrice();
        sb.append(PreviewElement.TOTAL_ORDER_PRICE.getElement())
                .append(String.format(PreviewElementForm.ORDER_PRICE_FORM.getForm(), orderPrice));
        return sb.toString();
    }
}
