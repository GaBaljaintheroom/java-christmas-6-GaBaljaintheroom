package christmas.formatter;

import christmas.constants.PreviewElement;
import christmas.constants.PreviewElementForm;
import christmas.domain.ExpectOrderPrice;

public final class ExpectOrderPriceFormatter {

    private static final StringBuilder sb = new StringBuilder();

    private ExpectOrderPriceFormatter() {
    }

    public static String showExpectOrderPrice(final ExpectOrderPrice expectOrderPrice) {
        sb.append(PreviewElement.EXPECT_ORDER_PRICE.getElement())
                .append(String.format(PreviewElementForm.ORDER_PRICE_FORM.getForm(), expectOrderPrice.getExpectPrice()));
        return sb.toString();
    }

}
