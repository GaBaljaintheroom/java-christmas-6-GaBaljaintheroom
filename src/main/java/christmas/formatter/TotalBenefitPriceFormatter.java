package christmas.formatter;

import christmas.domain.GiveawayMenu;
import christmas.domain.TotalDiscountPrice;

public final class TotalBenefitPriceFormatter {

    private static final String TOTAL_BENEFIT_PRICE = "<총혜택 금액>\n";
    private static final String TOTAL_BENEFIT_PRICE_FORM = "-%,d원\n";
    private static final String NONE = "0원\n";
    private static final StringBuilder sb = new StringBuilder();
    private static final Integer NO_DISCOUNT = 0;

    private TotalBenefitPriceFormatter() {
    }

    public static String showExpectedOrderPrice(final TotalDiscountPrice totalDiscountPrice,
                                                final GiveawayMenu giveawayMenu) {
        sb.append(TOTAL_BENEFIT_PRICE);
        Integer totalBenefitPrice = totalDiscountPrice.getDiscountPrice() + giveawayMenu.getPrice();
        appendTotalBenefitPrice(totalBenefitPrice);
        appendNoTotalBenefitPrice(totalBenefitPrice);

        return sb.toString();
    }

    private static void appendTotalBenefitPrice(final Integer totalBenefitPrice) {
        if (isDiscountCase(totalBenefitPrice)) {
            sb.append(String.format(TOTAL_BENEFIT_PRICE_FORM, totalBenefitPrice));
        }
    }

    private static boolean isDiscountCase(final Integer totalBenefitPrice) {
        return !totalBenefitPrice.equals(NO_DISCOUNT);
    }

    private static void appendNoTotalBenefitPrice(final Integer totalBenefitPrice) {
        if (isNotDiscountCase(totalBenefitPrice)) {
            sb.append(NONE);
        }
    }

    private static boolean isNotDiscountCase(final Integer totalBenefitPrice) {
        return totalBenefitPrice.equals(NO_DISCOUNT);
    }
}
