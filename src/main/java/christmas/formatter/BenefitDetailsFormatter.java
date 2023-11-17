package christmas.formatter;

import christmas.constants.ChristmasRule;
import christmas.constants.element.PreviewElement;
import christmas.constants.element.PreviewElementForm;
import christmas.domain.preview.ChristmasDDayDiscount;
import christmas.domain.preview.DaysDiscount;
import christmas.domain.preview.GiveawayMenu;
import christmas.domain.preview.SpecialEventDiscount;

public final class BenefitDetailsFormatter {

    private static final String CHRISTMAS_DDAY_DISCOUNT = "크리스마스 디데이 할인: ";
    private static final String DAYS_DISCOUNT = "%s 할인: ";
    private static final String SPECIAL_DISCOUNT = "특별 할인: ";
    private static final String GIVEAWAY_EVENT = "증정 이벤트: ";

    private static final StringBuilder sb = new StringBuilder();

    private BenefitDetailsFormatter() {
    }

    public static String showBenefitDetails(final ChristmasDDayDiscount christMasDDayDiscount,
                                            final DaysDiscount daysDiscount,
                                            final SpecialEventDiscount specialEventDiscount,
                                            final GiveawayMenu giveawayMenu) {
        sb.append(PreviewElement.BENEFIT_DETAILS.getElement());
        noDiscountCase(christMasDDayDiscount, daysDiscount, specialEventDiscount, giveawayMenu);
        christMasDDayDiscountCase(christMasDDayDiscount);
        daysDiscountCase(daysDiscount);
        specialEventDiscountCase(specialEventDiscount);
        giveawayMenuDiscountCase(giveawayMenu);
        return sb.toString();
    }

    private static void noDiscountCase(final ChristmasDDayDiscount christMasDDayDiscount,
                                       final DaysDiscount daysDiscount,
                                       final SpecialEventDiscount specialEventDiscount,
                                       final GiveawayMenu giveawayMenu) {
        if (getTotalDiscount(christMasDDayDiscount, daysDiscount, specialEventDiscount, giveawayMenu).equals(
                ChristmasRule.NO_DISCOUNT.getValue())) {
            sb.append(PreviewElement.NONE.getElement());
        }
    }

    private static Integer getTotalDiscount(final ChristmasDDayDiscount christMasDDayDiscount,
                                            final DaysDiscount daysDiscount,
                                            final SpecialEventDiscount specialEventDiscount,
                                            final GiveawayMenu giveawayMenu) {
        return christMasDDayDiscount.getDiscount() + daysDiscount.getDiscount()
                + specialEventDiscount.getDiscount() + giveawayMenu.getPrice();
    }

    private static void christMasDDayDiscountCase(final ChristmasDDayDiscount christMasDDayDiscount) {
        Integer discount = christMasDDayDiscount.getDiscount();
        if (isDiscountCase(discount)) {
            sb.append(CHRISTMAS_DDAY_DISCOUNT)
                    .append(String.format(PreviewElementForm.BENEFIT_PRICE_FORM.getForm(), discount));
        }
    }

    private static void daysDiscountCase(final DaysDiscount daysDiscount) {
        Integer discount = daysDiscount.getDiscount();
        if (isDiscountCase(discount)) {
            sb.append(String.format(DAYS_DISCOUNT, daysDiscount.getDayType()))
                    .append(String.format(PreviewElementForm.BENEFIT_PRICE_FORM.getForm(), discount));
        }
    }

    private static void specialEventDiscountCase(final SpecialEventDiscount specialEventDiscount) {
        Integer discount = specialEventDiscount.getDiscount();
        if (isDiscountCase(discount)) {
            sb.append(SPECIAL_DISCOUNT)
                    .append(String.format(PreviewElementForm.BENEFIT_PRICE_FORM.getForm(), discount));
        }
    }

    private static void giveawayMenuDiscountCase(final GiveawayMenu giveawayMenu) {
        Integer price = giveawayMenu.getPrice();
        if (isDiscountCase(price)) {
            sb.append(GIVEAWAY_EVENT)
                    .append(String.format(PreviewElementForm.BENEFIT_PRICE_FORM.getForm(), price));
        }
    }

    private static boolean isDiscountCase(Integer price) {
        return !price.equals(ChristmasRule.NO_DISCOUNT.getValue());
    }
}
