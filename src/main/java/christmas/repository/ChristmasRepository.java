package christmas.repository;

import christmas.domain.Menus;
import christmas.domain.TotalOrderPrice;
import christmas.domain.VisitDate;
import christmas.exception.DomainNullException;

import java.util.Optional;
import java.util.function.Supplier;

public class ChristmasRepository {

    private VisitDate visitDate;
    private Menus orderMenus;
    private TotalOrderPrice totalOrderPrice;

    public void saveVisitDate(final VisitDate visitDate) {
        this.visitDate = visitDate;
    }

    public void saveOrderMenus(final Menus orderMenus) {
        this.orderMenus = orderMenus;
    }

    public void saveTotalOrderPrice(TotalOrderPrice totalOrderPrice) {
        this.totalOrderPrice = totalOrderPrice;
    }

    public VisitDate getVisitDate() {
        return get(() -> this.visitDate);
    }

    public Menus getOrderMenus() {
        return get(() -> this.orderMenus);
    }

    public TotalOrderPrice getTotalOrderPrice() {
        return get(() -> this.totalOrderPrice);
    }

    private <T> T get(final Supplier<T> supplier) {
        return Optional.ofNullable(supplier.get())
                .orElseThrow(DomainNullException::new);
    }
}
