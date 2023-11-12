package christmas.formatter;

import christmas.domain.GiveawayMenu;
import christmas.domain.TotalDiscountPrice;

public final class TotalBenefitPriceFormatter {

    private static final String TOTAL_BENEFIT_PRICE = "<총혜택 금액>\n";
    private static final String TOTAL_BENEFIT_PRICE_FORM = "-%,d원\n";
    private static final String NONE = "0원\n";
    private static final StringBuilder sb = new StringBuilder();

    private TotalBenefitPriceFormatter() {
    }

    public static String showExpectedOrderPrice(TotalDiscountPrice totalDiscountPrice, GiveawayMenu giveawayMenu) {
        sb.append(TOTAL_BENEFIT_PRICE);
        int totalBenefitPrice = totalDiscountPrice.getDiscountPrice() + giveawayMenu.getPrice();
        appendTotalBenefitPrice(totalBenefitPrice);
        appendNoTotalBenefitPrice(totalBenefitPrice);

        return sb.toString();
    }

    private static void appendTotalBenefitPrice(int totalBenefitPrice) {
        if (totalBenefitPrice != 0) {
            sb.append(String.format(TOTAL_BENEFIT_PRICE_FORM, totalBenefitPrice));
        }
    }

    private static void appendNoTotalBenefitPrice(int totalBenefitPrice) {
        if (totalBenefitPrice == 0) {
            sb.append(NONE);
        }
    }
}
