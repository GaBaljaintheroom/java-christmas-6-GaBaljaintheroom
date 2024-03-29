package christmas.repository;

import christmas.domain.preview.ChristmasDDayDiscount;
import christmas.domain.preview.DaysDiscount;
import christmas.domain.preview.GiveawayMenu;
import christmas.domain.preview.SpecialEventDiscount;
import christmas.domain.preview.TotalDiscountPrice;
import christmas.exception.DomainNullException;
import java.util.Optional;
import java.util.function.Supplier;

public enum EventDetailsRepository {

    INSTANCE;

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

    public void saveSpecialEventDayDiscount(final SpecialEventDiscount specialEventDayDiscount) {
        this.specialEventDayDiscount = specialEventDayDiscount;
    }

    public void saveGiveawayMenu(final GiveawayMenu giveawayMenu) {
        this.giveawayMenu = giveawayMenu;
    }

    public void saveTotalDiscountPrice(final TotalDiscountPrice totalDiscountPrice) {
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
