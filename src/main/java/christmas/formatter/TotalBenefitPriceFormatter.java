package christmas.formatter;

import christmas.constants.ChristmasRule;
import christmas.constants.element.PreviewElement;
import christmas.constants.element.PreviewElementForm;
import christmas.domain.preview.GiveawayMenu;
import christmas.domain.preview.TotalDiscountPrice;

public final class TotalBenefitPriceFormatter {

    private static final String NONE = "0원";
    private static final StringBuilder sb = new StringBuilder();

    private TotalBenefitPriceFormatter() {
    }

    public static String showExpectedOrderPrice(final TotalDiscountPrice totalDiscountPrice,
                                                final GiveawayMenu giveawayMenu) {
        sb.append(PreviewElement.TOTAL_BENEFIT_PRICE.getElement());
        Integer totalBenefitPrice = totalDiscountPrice.getDiscountPrice() + giveawayMenu.getPrice();
        appendTotalBenefitPrice(totalBenefitPrice);
        appendNoTotalBenefitPrice(totalBenefitPrice);

        return sb.toString();
    }

    private static void appendTotalBenefitPrice(final Integer totalBenefitPrice) {
        if (isDiscountCase(totalBenefitPrice)) {
            sb.append(String.format(PreviewElementForm.BENEFIT_PRICE_FORM.getForm(), totalBenefitPrice));
        }
    }

    private static boolean isDiscountCase(final Integer totalBenefitPrice) {
        return !totalBenefitPrice.equals(ChristmasRule.NO_DISCOUNT.getValue());
    }

    private static void appendNoTotalBenefitPrice(final Integer totalBenefitPrice) {
        if (isNotDiscountCase(totalBenefitPrice)) {
            sb.append(NONE).append(PreviewElementForm.NEXT_LINE);
        }
    }

    private static boolean isNotDiscountCase(final Integer totalBenefitPrice) {
        return totalBenefitPrice.equals(ChristmasRule.NO_DISCOUNT.getValue());
    }
}
