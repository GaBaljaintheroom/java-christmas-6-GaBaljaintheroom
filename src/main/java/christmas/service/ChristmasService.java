package christmas.service;

import christmas.constants.MenuBoard;
import christmas.domain.Menus;
import christmas.domain.TotalOrderPrice;
import christmas.domain.VisitDate;
import christmas.formatter.OrderMenuFormatter;
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

    public String checkOrderMenu() {
        Menus orderMenus = christmasRepository.getOrderMenus();
        return OrderMenuFormatter.showOrderMenus(orderMenus);
    }

    public void saveTotalOrderPrice() {
        Menus orderMenus = christmasRepository.getOrderMenus();
        Integer orderPrice = MenuBoard.calculateTotalOrderPrice(orderMenus);
        TotalOrderPrice totalOrderPrice = TotalOrderPrice.from(orderPrice);

        christmasRepository.saveTotalOrderPrice(totalOrderPrice);
    }

}
