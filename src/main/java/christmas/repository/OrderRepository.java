package christmas.repository;

import christmas.domain.preview.ExpectPaymentPrice;
import christmas.domain.menu.Menus;
import christmas.domain.preview.TotalOrderPrice;
import christmas.domain.VisitDate;
import christmas.exception.DomainNullException;

import java.util.Optional;
import java.util.function.Supplier;

public enum OrderRepository {

    INSTANCE;

    private VisitDate visitDate;
    private Menus orderMenus;
    private TotalOrderPrice totalOrderPrice;
    private ExpectPaymentPrice expectPaymentPrice;

    public void saveVisitDate(final VisitDate visitDate) {
        this.visitDate = visitDate;
    }

    public void saveOrderMenus(final Menus orderMenus) {
        this.orderMenus = orderMenus;
    }

    public void saveTotalOrderPrice(final TotalOrderPrice totalOrderPrice) {
        this.totalOrderPrice = totalOrderPrice;
    }

    public void saveExpectPaymentPrice(final ExpectPaymentPrice expectPaymentPrice) {
        this.expectPaymentPrice = expectPaymentPrice;
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
