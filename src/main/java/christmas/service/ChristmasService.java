package christmas.service;

import christmas.constants.DaysEventCategory;
import christmas.constants.MenuBoard;
import christmas.constants.SpecialEventDay;
import christmas.domain.*;
import christmas.formatter.GiveawayMenuFormatter;
import christmas.formatter.OrderMenuFormatter;
import christmas.formatter.TotalOrderPriceFormatter;
import christmas.repository.BenefitDetailsRepository;
import christmas.repository.OrderRepository;

public class ChristmasService {

    private final OrderRepository orderRepository;
    private final BenefitDetailsRepository benefitDetailsRepository;

    public ChristmasService(final OrderRepository orderRepository, final BenefitDetailsRepository benefitDetailsRepository) {
        this.orderRepository = orderRepository;
        this.benefitDetailsRepository = benefitDetailsRepository;
    }

    public void saveVisitDate(final VisitDate visitDate) {
        orderRepository.saveVisitDate(visitDate);
    }

    public void saveOrderMenus(final Menus orderMenus) {
        orderRepository.saveOrderMenus(orderMenus);
    }

    public Integer getVisitDate() {
        VisitDate visitDate = orderRepository.getVisitDate();
        return visitDate.getDayOfMonth();
    }

    public String checkOrderMenu() {
        Menus orderMenus = orderRepository.getOrderMenus();
        return OrderMenuFormatter.showOrderMenus(orderMenus);
    }

    public void saveTotalOrderPrice() {
        Menus orderMenus = orderRepository.getOrderMenus();
        Integer orderPrice = MenuBoard.calculateTotalOrderPrice(orderMenus);
        TotalOrderPrice totalOrderPrice = TotalOrderPrice.from(orderPrice);

        orderRepository.saveTotalOrderPrice(totalOrderPrice);
    }

    public String checkTotalOrderPrice() {
        TotalOrderPrice totalOrderPrice = orderRepository.getTotalOrderPrice();
        return TotalOrderPriceFormatter.showTotalOrderPrice(totalOrderPrice);
    }

    public void saveGiveawayMenu() {
        TotalOrderPrice totalOrderPrice = orderRepository.getTotalOrderPrice();
        GiveawayMenu giveawayMenu = GiveawayMenu.from(totalOrderPrice.canGiveawayEvent());
        benefitDetailsRepository.saveGiveawayMenu(giveawayMenu);

    }

    public String checkGiveWayMenu() {
        GiveawayMenu giveawayMenu = benefitDetailsRepository.getGiveawayMenu();
        return GiveawayMenuFormatter.showGiveawayMenu(giveawayMenu);
    }

    public void saveChristmasDDayDiscount() {
        VisitDate visitDate = orderRepository.getVisitDate();
        TotalOrderPrice totalOrderPrice = orderRepository.getTotalOrderPrice();

        ChristmasDDayDiscount christmasDDayDiscount = ChristmasDDayDiscount.from(totalOrderPrice, visitDate);
        benefitDetailsRepository.saveChristmasDDayDiscount(christmasDDayDiscount);
    }

    public void daysDiscount() {
        TotalOrderPrice totalOrderPrice = orderRepository.getTotalOrderPrice();

        VisitDate visitDate = orderRepository.getVisitDate();
        Menus orderMenus = orderRepository.getOrderMenus();

        Integer discountPrice = DaysEventCategory.daysDiscount(visitDate, orderMenus);
        DaysDiscount daysDiscount = DaysDiscount.from(totalOrderPrice, discountPrice);
        benefitDetailsRepository.saveDaysDiscount(daysDiscount);
    }

    public void specialEventDiscount() {
        TotalOrderPrice totalOrderPrice = orderRepository.getTotalOrderPrice();

        VisitDate visitDate = orderRepository.getVisitDate();
        Integer discountPrice = SpecialEventDay.specialDayEventDiscount(visitDate);
        SpecialEventDiscount specialEventDiscount = SpecialEventDiscount.from(totalOrderPrice, discountPrice);
        benefitDetailsRepository.saveSpecialEventDayDiscount(specialEventDiscount);
    }


}
