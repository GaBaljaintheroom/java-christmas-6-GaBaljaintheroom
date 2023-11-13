package christmas.repository;

import christmas.domain.ExpectOrderPrice;
import christmas.domain.Menus;
import christmas.domain.TotalOrderPrice;
import christmas.domain.VisitDate;
import christmas.exception.DomainNullException;
import java.util.Optional;
import java.util.function.Supplier;

public class OrderRepository {

    private VisitDate visitDate;
    private Menus orderMenus;
    private TotalOrderPrice totalOrderPrice;
    private ExpectOrderPrice expectOrderPrice;

    public void saveVisitDate(final VisitDate visitDate) {
        this.visitDate = visitDate;
    }

    public void saveOrderMenus(final Menus orderMenus) {
        this.orderMenus = orderMenus;
    }

    public void saveTotalOrderPrice(TotalOrderPrice totalOrderPrice) {
        this.totalOrderPrice = totalOrderPrice;
    }

    public void saveExpectOrderPrice(ExpectOrderPrice expectOrderPrice) {
        this.expectOrderPrice = expectOrderPrice;
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

    public ExpectOrderPrice getExpectOrderPrice() {
        return get(() -> this.expectOrderPrice);
    }

    private <T> T get(final Supplier<T> supplier) {
        return Optional.ofNullable(supplier.get())
                .orElseThrow(DomainNullException::new);
    }
}
