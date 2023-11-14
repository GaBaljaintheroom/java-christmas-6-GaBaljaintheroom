package christmas.formatter;

import christmas.constants.PreviewElement;
import christmas.domain.ExpectOrderPrice;

public final class ExpectOrderPriceFormatter {

    private static final String EXPECT_ORDER_PRICE_FORM = "%,d원\n";
    private static final StringBuilder sb = new StringBuilder();

    private ExpectOrderPriceFormatter() {
    }

    public static String showExpectOrderPrice(final ExpectOrderPrice expectOrderPrice) {
        sb.append(PreviewElement.EXPECT_ORDER_PRICE.getElement())
                .append(String.format(EXPECT_ORDER_PRICE_FORM, expectOrderPrice.getExpectPrice()));
        return sb.toString();
    }

}
