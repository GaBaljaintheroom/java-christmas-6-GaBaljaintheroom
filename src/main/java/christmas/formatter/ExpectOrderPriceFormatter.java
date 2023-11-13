package christmas.formatter;

import christmas.domain.ExpectOrderPrice;

public final class ExpectOrderPriceFormatter {

    private static final String EXPECT_ORDER_PRICE = "<할인 후 예상 결제 금액>\n";
    private static final String EXPECT_ORDER_PRICE_FORM = "%,d원\n";
    private static final StringBuilder sb = new StringBuilder();

    private ExpectOrderPriceFormatter() {
    }

    public static String showExpectOrderPrice(final ExpectOrderPrice expectOrderPrice) {
        sb.append(EXPECT_ORDER_PRICE)
                .append(String.format(EXPECT_ORDER_PRICE_FORM, expectOrderPrice.getExpectPrice()));
        return sb.toString();
    }

}
