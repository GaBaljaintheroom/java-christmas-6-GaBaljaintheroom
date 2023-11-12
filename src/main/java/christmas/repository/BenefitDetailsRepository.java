package christmas.repository;

import christmas.domain.ChristmasDDayDiscount;
import christmas.domain.GiveawayMenu;
import christmas.exception.DomainNullException;

import java.util.Optional;
import java.util.function.Supplier;

public class BenefitDetailsRepository {

    private ChristmasDDayDiscount christmasDDayDiscount;
    private Integer daysDiscount;
    private Integer specialEventDayDiscount;
    private GiveawayMenu giveawayMenu;

    public void saveChristmasDDayDiscount(ChristmasDDayDiscount christmasDDayDiscount) {
        this.christmasDDayDiscount = christmasDDayDiscount;
    }

    public void saveDaysDiscount(Integer daysDiscount) {
        this.daysDiscount = daysDiscount;
    }

    public void saveSpecialEventDayDiscount(Integer specialEventDayDiscount) {
        this.specialEventDayDiscount = specialEventDayDiscount;
    }

    public void saveGiveawayMenu(GiveawayMenu giveawayMenu) {
        this.giveawayMenu = giveawayMenu;
    }

    public GiveawayMenu getGiveawayMenu() {
        return get(() -> this.giveawayMenu);
    }

    private <T> T get(final Supplier<T> supplier) {
        return Optional.ofNullable(supplier.get())
                .orElseThrow(DomainNullException::new);
    }
}
