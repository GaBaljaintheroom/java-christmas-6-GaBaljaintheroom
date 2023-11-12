package christmas.domain;

public class GiveawayMenu {

    private final Integer price;

    private GiveawayMenu(Integer price) {
        this.price = price;
    }

    public static GiveawayMenu from(Boolean canGiveawayEvent) {
        Integer price = getChampagnePrice(canGiveawayEvent);
        return new GiveawayMenu(price);
    }

    private static Integer getChampagnePrice(Boolean canGiveawayEvent) {
        if (Boolean.TRUE.equals(canGiveawayEvent)) {
            return 25_000;
        }
        return 0;
    }

    public Integer getPrice() {
        return price;
    }
}
