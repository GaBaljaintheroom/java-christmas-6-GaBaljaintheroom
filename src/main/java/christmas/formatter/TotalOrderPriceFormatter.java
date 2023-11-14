package christmas.formatter;

import christmas.constants.PreviewElement;
import christmas.domain.TotalOrderPrice;

public final class TotalOrderPriceFormatter {

    private static final String TOTAL_ORDER_PRICE_FORM = "%,d원\n";
    private static final StringBuilder sb = new StringBuilder();

    private TotalOrderPriceFormatter() {
    }

    public static String showTotalOrderPrice(final TotalOrderPrice totalOrderPrice) {
        Integer orderPrice = totalOrderPrice.getOrderPrice();
        sb.append(PreviewElement.TOTAL_ORDER_PRICE.getElement())
                .append(String.format(TOTAL_ORDER_PRICE_FORM, orderPrice));
        return sb.toString();
    }
}
