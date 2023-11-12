package christmas.formatter;

import christmas.domain.GiveawayMenu;

public final class GiveawayMenuFormatter {

    private static final String GIVEAWAY_MENU = "<증정 메뉴>\n";
    private static final String ONE_CHAMPAGNE = "샴페인 1개\n";
    private static final String NONE = "없음\n";
    private static final Integer CHAMPAGNE_PRICE = 25_000;
    private static final StringBuilder sb = new StringBuilder();

    private GiveawayMenuFormatter() {
    }

    public static String showGiveawayMenu(GiveawayMenu giveawayMenu) {
        sb.append(GIVEAWAY_MENU);

        Integer orderPrice = giveawayMenu.getPrice();
        appendChampagne(orderPrice);
        appendNone(orderPrice);

        return sb.toString();
    }

    private static void appendChampagne(Integer orderPrice) {
        if (orderPrice.equals(CHAMPAGNE_PRICE)) {
            sb.append(ONE_CHAMPAGNE);
        }
    }

    private static void appendNone(Integer orderPrice) {
        if (!orderPrice.equals(CHAMPAGNE_PRICE)) {
            sb.append(NONE);
        }
    }
}
