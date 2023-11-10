package christmas.repository;

import christmas.domain.VisitDate;
import christmas.exception.DomainNullException;

import java.util.Optional;
import java.util.function.Supplier;

public class ChristmasRepository {

    private VisitDate visitDate;

    public void saveVisitDate(final VisitDate visitDate) {
        this.visitDate = visitDate;
    }


    private <T> T get(final Supplier<T> supplier) {
        return Optional.ofNullable(supplier.get())
                .orElseThrow(DomainNullException::new);
    }
}
