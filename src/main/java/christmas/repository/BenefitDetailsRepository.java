package christmas.repository;

import christmas.exception.DomainNullException;

import java.util.Optional;
import java.util.function.Supplier;

public class BenefitDetailsRepository {

    private Integer christmasDDayDiscount;
    private Integer daysDiscount;

    public void saveChristmasDDayDiscount(Integer christmasDDayDiscount) {
        this.christmasDDayDiscount = christmasDDayDiscount;
    }

    public void saveDaysDiscount(Integer daysDiscount) {
        this.daysDiscount = daysDiscount;
    }

    private <T> T get(final Supplier<T> supplier) {
        return Optional.ofNullable(supplier.get())
                .orElseThrow(DomainNullException::new);
    }
}
