package christmas.service;

import christmas.domain.Menus;
import christmas.domain.VisitDate;
import christmas.repository.ChristmasRepository;

public class ChristmasService {

    private final ChristmasRepository christmasRepository;

    public ChristmasService(final ChristmasRepository christmasRepository) {
        this.christmasRepository = christmasRepository;
    }

    public void saveVisitDate(final VisitDate visitDate) {
        christmasRepository.saveVisitDate(visitDate);
    }

    public void saveOrderMenus(final Menus orderMenus) {
        christmasRepository.saveOrderMenus(orderMenus);
    }

    public Integer getVisitDate() {
        VisitDate visitDate = christmasRepository.getVisitDate();
        return visitDate.getDay();
    }

}
