package christmas.repository;

import christmas.domain.ChristmasDDayDiscount;
import christmas.domain.DaysDiscount;
import christmas.domain.GiveawayMenu;
import christmas.domain.SpecialEventDiscount;
import christmas.domain.TotalDiscountPrice;
import christmas.exception.DomainNullException;
import java.util.Optional;
import java.util.function.Supplier;

public class BenefitDetailsRepository {

    private ChristmasDDayDiscount christmasDDayDiscount;
    private DaysDiscount daysDiscount;
    private SpecialEventDiscount specialEventDayDiscount;
    private GiveawayMenu giveawayMenu;
    private TotalDiscountPrice totalDiscountPrice;

    public void saveChristmasDDayDiscount(final ChristmasDDayDiscount christmasDDayDiscount) {
        this.christmasDDayDiscount = christmasDDayDiscount;
    }

    public void saveDaysDiscount(final DaysDiscount daysDiscount) {
        this.daysDiscount = daysDiscount;
    }

    public void saveSpecialEventDayDiscount(SpecialEventDiscount specialEventDayDiscount) {
        this.specialEventDayDiscount = specialEventDayDiscount;
    }

    public void saveGiveawayMenu(GiveawayMenu giveawayMenu) {
        this.giveawayMenu = giveawayMenu;
    }

    public void saveTotalDiscountPrice(TotalDiscountPrice totalDiscountPrice) {
        this.totalDiscountPrice = totalDiscountPrice;
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

    public TotalDiscountPrice getTotalDiscountPrice() {
        return get(() -> this.totalDiscountPrice);
    }

    private <T> T get(final Supplier<T> supplier) {
        return Optional.ofNullable(supplier.get())
                .orElseThrow(DomainNullException::new);
    }
}
