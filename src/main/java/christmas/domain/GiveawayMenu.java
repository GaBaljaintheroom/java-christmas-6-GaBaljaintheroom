package christmas.domain;

public class GiveawayMenu {

    private static final Integer CHAMPAGNE_PRICE = 25_000;
    private static final Integer NO_CHAMPAGNE = 0;

    private final Integer price;

    private GiveawayMenu(Integer price) {
        this.price = price;
    }

    public static GiveawayMenu from(final Boolean canGiveawayEvent) {
        Integer price = applyDiscount(canGiveawayEvent);
        return new GiveawayMenu(price);
    }

    private static Integer applyDiscount(final Boolean canGiveawayEvent) {
        if (Boolean.TRUE.equals(canGiveawayEvent)) {
            return CHAMPAGNE_PRICE;
        }
        return NO_CHAMPAGNE;
    }

    public Integer getPrice() {
        return price;
    }
}
