package christmas.formatter;

import christmas.domain.ChristmasDDayDiscount;
import christmas.domain.DaysDiscount;
import christmas.domain.GiveawayMenu;
import christmas.domain.SpecialEventDiscount;

public final class BenefitDetailsFormatter {

    private static final String BENEFIT_DETAILS = "<혜택 내역>\n";
    private static final String NONE = "없음\n";
    private static final String CHRISTMAS_DDAY_DISCOUNT = "크리스마스 디데이 할인: ";
    private static final String DAYS_DISCOUNT = "%s 할인: ";
    private static final String SPECIAL_DISCOUNT = "특별 할인: ";
    private static final String GIVEAWAY_EVENT = "증정 이벤트: ";
    private static final String BENEFIT_DETAILS_FORMAT = "-%,d원\n";

    private static final StringBuilder sb = new StringBuilder();

    private BenefitDetailsFormatter() {
    }

    public static String showBenefitDetails(ChristmasDDayDiscount christMasDDayDiscount, DaysDiscount daysDiscount,
                                            SpecialEventDiscount specialEventDiscount, GiveawayMenu giveawayMenu) {
        sb.append(BENEFIT_DETAILS);
        noDiscountCase(christMasDDayDiscount, daysDiscount, specialEventDiscount, giveawayMenu);
        christMasDDayDiscountCase(christMasDDayDiscount);
        daysDiscountCase(daysDiscount);
        specialEventDiscountCase(specialEventDiscount);
        giveawayMenuDiscountCase(giveawayMenu);
        return sb.toString();
    }

    private static void noDiscountCase(ChristmasDDayDiscount christMasDDayDiscount, DaysDiscount daysDiscount,
                                       SpecialEventDiscount specialEventDiscount, GiveawayMenu giveawayMenu) {
        if (christMasDDayDiscount.getDiscount() + daysDiscount.getDiscount()
                + specialEventDiscount.getDiscount() + giveawayMenu.getPrice() == 0) {
            sb.append(NONE);
        }
    }

    private static void christMasDDayDiscountCase(ChristmasDDayDiscount christMasDDayDiscount) {
        Integer discount = christMasDDayDiscount.getDiscount();
        if (discount != 0) {
            sb.append(CHRISTMAS_DDAY_DISCOUNT)
                    .append(String.format(BENEFIT_DETAILS_FORMAT, discount));
        }
    }

    private static void daysDiscountCase(DaysDiscount daysDiscount) {
        Integer discount = daysDiscount.getDiscount();
        if (discount != 0) {
            sb.append(String.format(DAYS_DISCOUNT, daysDiscount.getDayType()))
                    .append(String.format(BENEFIT_DETAILS_FORMAT, discount));
        }
    }

    private static void specialEventDiscountCase(SpecialEventDiscount specialEventDiscount) {
        Integer discount = specialEventDiscount.getDiscount();
        if (discount != 0) {
            sb.append(SPECIAL_DISCOUNT)
                    .append(String.format(BENEFIT_DETAILS_FORMAT, discount));
        }
    }

    private static void giveawayMenuDiscountCase(GiveawayMenu giveawayMenu) {
        Integer price = giveawayMenu.getPrice();
        if (price != 0) {
            sb.append(GIVEAWAY_EVENT)
                    .append(String.format(BENEFIT_DETAILS_FORMAT, price));
        }
    }
}
