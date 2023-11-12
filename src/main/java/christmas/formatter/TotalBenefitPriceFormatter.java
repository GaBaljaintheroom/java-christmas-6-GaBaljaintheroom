package christmas.formatter;

import christmas.domain.TotalBenefitPrice;

public final class TotalBenefitPriceFormatter {

    private static final String TOTAL_BENEFIT_PRICE = "<총혜택 금액>\n";
    private static final String TOTAL_BENEFIT_PRICE_FORM = "-%,d원\n";
    private static final String NONE = "0원\n";
    private static final StringBuilder sb = new StringBuilder();

    private TotalBenefitPriceFormatter() {
    }

    public static String showExpectedOrderPrice(TotalBenefitPrice totalBenefitPrice) {
        sb.append(TOTAL_BENEFIT_PRICE);
        appendTotalBenefitPrice(totalBenefitPrice);
        appendNoTotalBenefitPrice(totalBenefitPrice);

        return sb.toString();
    }

    private static void appendTotalBenefitPrice(TotalBenefitPrice totalBenefitPrice) {
        if (totalBenefitPrice.getPrice() != 0) {
            sb.append(String.format(TOTAL_BENEFIT_PRICE_FORM, totalBenefitPrice.getPrice()));
        }
    }

    private static void appendNoTotalBenefitPrice(TotalBenefitPrice totalBenefitPrice) {
        if (totalBenefitPrice.getPrice() == 0) {
            sb.append(NONE);
        }
    }
}
