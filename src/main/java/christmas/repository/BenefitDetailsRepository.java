package christmas.repository;

import christmas.domain.*;
import christmas.exception.DomainNullException;

import java.util.Optional;
import java.util.function.Supplier;

public class BenefitDetailsRepository {

    private ChristmasDDayDiscount christmasDDayDiscount;
    private DaysDiscount daysDiscount;
    private SpecialEventDiscount specialEventDayDiscount;
    private GiveawayMenu giveawayMenu;
    private TotalBenefitPrice totalBenefitPrice;

    public void saveChristmasDDayDiscount(ChristmasDDayDiscount christmasDDayDiscount) {
        this.christmasDDayDiscount = christmasDDayDiscount;
    }

    public void saveDaysDiscount(DaysDiscount daysDiscount) {
        this.daysDiscount = daysDiscount;
    }

    public void saveSpecialEventDayDiscount(SpecialEventDiscount specialEventDayDiscount) {
        this.specialEventDayDiscount = specialEventDayDiscount;
    }

    public void saveGiveawayMenu(GiveawayMenu giveawayMenu) {
        this.giveawayMenu = giveawayMenu;
    }

    public void saveTotalBenefitPrice(TotalBenefitPrice totalBenefitPrice) {
        this.totalBenefitPrice = totalBenefitPrice;
    }

    public ChristmasDDayDiscount getChristMasDDayDiscount() {
        return get(() -> this.christmasDDayDiscount);
    }

    public DaysDiscount getDaysDiscount() {
        return get(() -> this.daysDiscount);
    }

    public SpecialEventDiscount getSpecialEventDiscount() {
        return get(() -> this.specialEventDayDiscount);
    }

    public GiveawayMenu getGiveawayMenu() {
        return get(() -> this.giveawayMenu);
    }

    public TotalBenefitPrice getTotalBenefitPrice() {
        return get(() -> this.totalBenefitPrice);
    }

    private <T> T get(final Supplier<T> supplier) {
        return Optional.ofNullable(supplier.get())
                .orElseThrow(DomainNullException::new);
    }
}
