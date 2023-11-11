package christmas.repository;

import christmas.domain.Menus;
import christmas.domain.VisitDate;
import christmas.exception.DomainNullException;

import java.util.Optional;
import java.util.function.Supplier;

public class ChristmasRepository {

    private VisitDate visitDate;
    private Menus orderMenus;

    public void saveVisitDate(final VisitDate visitDate) {
        this.visitDate = visitDate;
    }

    public void saveOrderMenus(final Menus orderMenus) {
        this.orderMenus = orderMenus;
    }

    public VisitDate getVisitDate() {
        return get(() -> this.visitDate);
    }

    public Menus getOrderMenus() {
        return get(() -> this.orderMenus);
    }

    private <T> T get(final Supplier<T> supplier) {
        return Optional.ofNullable(supplier.get())
                .orElseThrow(DomainNullException::new);
    }


}
