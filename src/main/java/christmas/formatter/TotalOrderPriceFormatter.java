package christmas.formatter;

import christmas.domain.TotalOrderPrice;

import java.text.NumberFormat;

public final class TotalOrderPriceFormatter {

    private static final String TOTAL_ORDER_PRICE = "<할인 전 총주문 금액>\n";
    private static final String TOTAL_ORDER_PRICE_FORM = "%s원\n";
    private static final StringBuilder sb = new StringBuilder();

    private TotalOrderPriceFormatter() {
    }

    public static String showTotalOrderPrice(TotalOrderPrice totalOrderPrice) {
        Integer orderPrice = totalOrderPrice.getOrderPrice();
        sb.append(TOTAL_ORDER_PRICE)
                .append(String.format(TOTAL_ORDER_PRICE_FORM, NumberFormat.getInstance().format(orderPrice)));
        return sb.toString();
    }
}
