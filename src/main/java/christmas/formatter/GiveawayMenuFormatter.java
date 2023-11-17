package christmas.formatter;

import christmas.constants.element.PreviewElement;
import christmas.constants.element.PreviewElementForm;
import christmas.domain.preview.GiveawayMenu;

public final class GiveawayMenuFormatter {

    private static final String ONE_CHAMPAGNE = "샴페인 1개";
    private static final Integer CHAMPAGNE_PRICE = 25_000;
    private static final StringBuilder sb = new StringBuilder();

    private GiveawayMenuFormatter() {
    }

    public static String showGiveawayMenu(final GiveawayMenu giveawayMenu) {
        sb.append(PreviewElement.GIVEAWAY_MENU.getElement());

        Integer orderPrice = giveawayMenu.getPrice();
        appendChampagne(orderPrice);
        appendNone(orderPrice);

        return sb.toString();
    }

    private static void appendChampagne(final Integer orderPrice) {
        if (orderPrice.equals(CHAMPAGNE_PRICE)) {
            sb.append(ONE_CHAMPAGNE).append(PreviewElementForm.NEXT_LINE);
        }
    }

    private static void appendNone(final Integer orderPrice) {
        if (!orderPrice.equals(CHAMPAGNE_PRICE)) {
            sb.append(PreviewElement.NONE.getElement());
        }
    }
}
