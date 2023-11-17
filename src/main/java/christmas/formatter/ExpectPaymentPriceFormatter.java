package christmas.formatter;

import christmas.constants.element.PreviewElement;
import christmas.constants.element.PreviewElementForm;
import christmas.domain.preview.ExpectPaymentPrice;

public final class ExpectPaymentPriceFormatter {

    private static final StringBuilder sb = new StringBuilder();

    private ExpectPaymentPriceFormatter() {
    }

    public static String showExpectPaymentPrice(final ExpectPaymentPrice expectPaymentPrice) {
        sb.append(PreviewElement.EXPECT_ORDER_PRICE.getElement())
                .append(String.format(PreviewElementForm.ORDER_PRICE_FORM.getForm(), expectPaymentPrice.getExpectPrice()));
        return sb.toString();
    }

}
