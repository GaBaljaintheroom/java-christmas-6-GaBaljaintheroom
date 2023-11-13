package christmas.service;

import christmas.constants.DaysEventCategory;
import christmas.constants.EventBadge;
import christmas.constants.MenuBoard;
import christmas.constants.SpecialEventDay;
import christmas.domain.*;
import christmas.formatter.*;
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

    public String checkOrderMenus(final Menus orderMenus) {
        orderRepository.saveOrderMenus(orderMenus);
        return OrderMenuFormatter.showOrderMenus(orderMenus);
    }

    public Integer getVisitDate() {
        VisitDate visitDate = orderRepository.getVisitDate();
        return visitDate.getDayOfMonth();
    }

    public String checkTotalOrderPrice() {
        Menus orderMenus = orderRepository.getOrderMenus();
        Integer orderPrice = MenuBoard.calculateTotalOrderPrice(orderMenus);
        TotalOrderPrice totalOrderPrice = TotalOrderPrice.from(orderPrice);

        orderRepository.saveTotalOrderPrice(totalOrderPrice);
        return TotalOrderPriceFormatter.showTotalOrderPrice(totalOrderPrice);
    }

    public String showGiveawayMenuEvent() {
        TotalOrderPrice totalOrderPrice = orderRepository.getTotalOrderPrice();
        GiveawayMenu giveawayMenu = GiveawayMenu.from(totalOrderPrice.canGiveawayEvent());
        benefitDetailsRepository.saveGiveawayMenu(giveawayMenu);

        return GiveawayMenuFormatter.showGiveawayMenu(giveawayMenu);
    }

    public void saveChristmasDDayDiscount() {
        VisitDate visitDate = orderRepository.getVisitDate();
        TotalOrderPrice totalOrderPrice = orderRepository.getTotalOrderPrice();

        ChristmasDDayDiscount christmasDDayDiscount = ChristmasDDayDiscount.from(totalOrderPrice, visitDate);
        benefitDetailsRepository.saveChristmasDDayDiscount(christmasDDayDiscount);
    }

    public void saveDaysDiscount() {
        TotalOrderPrice totalOrderPrice = orderRepository.getTotalOrderPrice();

        VisitDate visitDate = orderRepository.getVisitDate();
        Menus orderMenus = orderRepository.getOrderMenus();

        Integer discountPrice = DaysEventCategory.daysDiscount(visitDate, orderMenus);
        DaysDiscount daysDiscount = DaysDiscount.from(totalOrderPrice, visitDate, discountPrice);
        benefitDetailsRepository.saveDaysDiscount(daysDiscount);
    }

    public void saveSpecialEventDiscount() {
        TotalOrderPrice totalOrderPrice = orderRepository.getTotalOrderPrice();

        VisitDate visitDate = orderRepository.getVisitDate();
        Integer discountPrice = SpecialEventDay.specialDayEventDiscount(visitDate);
        SpecialEventDiscount specialEventDiscount = SpecialEventDiscount.from(totalOrderPrice, discountPrice);
        benefitDetailsRepository.saveSpecialEventDayDiscount(specialEventDiscount);
    }

    public String showBenefitDetails() {
        ChristmasDDayDiscount christMasDDayDiscount = benefitDetailsRepository.getChristMasDDayDiscount();
        DaysDiscount daysDiscount = benefitDetailsRepository.getDaysDiscount();
        SpecialEventDiscount specialEventDiscount = benefitDetailsRepository.getSpecialEventDiscount();
        GiveawayMenu giveawayMenu = benefitDetailsRepository.getGiveawayMenu();

        TotalDiscountPrice totalDiscountPrice = TotalDiscountPrice.from(christMasDDayDiscount, daysDiscount, specialEventDiscount);
        benefitDetailsRepository.saveTotalDiscountPrice(totalDiscountPrice);

        return BenefitDetailsFormatter.showBenefitDetails(christMasDDayDiscount, daysDiscount, specialEventDiscount, giveawayMenu);
    }

    public String showTotalBenefitPrice() {
        TotalDiscountPrice totalDiscountPrice = benefitDetailsRepository.getTotalDiscountPrice();
        GiveawayMenu giveawayMenu = benefitDetailsRepository.getGiveawayMenu();
        return TotalBenefitPriceFormatter.showExpectedOrderPrice(totalDiscountPrice, giveawayMenu);
    }

    public void saveExpectOrderPrice() {
        TotalOrderPrice totalOrderPrice = orderRepository.getTotalOrderPrice();
        TotalDiscountPrice totalDiscountPrice = benefitDetailsRepository.getTotalDiscountPrice();
        int expectOrderPrice = totalOrderPrice.getOrderPrice() - totalDiscountPrice.getDiscountPrice();

        orderRepository.saveExpectOrderPrice(ExpectOrderPrice.from(expectOrderPrice));
    }

    public String showExpectOrderPrice() {
        ExpectOrderPrice expectOrderPrice = orderRepository.getExpectOrderPrice();
        return ExpectOrderPriceFormatter.showExpectOrderPrice(expectOrderPrice);
    }

    public String showEventBadge() {
        TotalDiscountPrice totalDiscountPrice = benefitDetailsRepository.getTotalDiscountPrice();
        GiveawayMenu giveawayMenu = benefitDetailsRepository.getGiveawayMenu();
        String badge = EventBadge.getBadgeByTotalBenefitPrice(totalDiscountPrice, giveawayMenu);
        return EventBadgeFormatter.showEventBadge(badge);
    }

}
