package christmas.constants;

import christmas.domain.GiveawayMenu;
import christmas.domain.TotalDiscountPrice;
import java.util.Arrays;

public enum EventBadge {

    SANTA("산타", 20_000),
    TREE("트리", 10_000),
    STAR("별", 5_000),
    NONE("없음", 0);

    private final String badge;
    private final Integer totalBenefitPrice;

    EventBadge(String badge, Integer totalBenefitPrice) {
        this.badge = badge;
        this.totalBenefitPrice = totalBenefitPrice;
    }

    public static String getBadgeByTotalBenefitPrice(TotalDiscountPrice totalDiscountPrice,
                                                     GiveawayMenu giveawayMenu) {
        int totalBenefitPrice = totalDiscountPrice.getDiscountPrice() + giveawayMenu.getPrice();
        return Arrays.stream(values())
                .filter(eventBadge -> eventBadge.totalBenefitPrice <= totalBenefitPrice)
                .findFirst()
                .map(eventBadge -> eventBadge.badge)
                .orElse(NONE.badge);
    }
}
