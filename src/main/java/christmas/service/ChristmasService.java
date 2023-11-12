package christmas.service;

import christmas.constants.DaysEventCategory;
import christmas.constants.MenuBoard;
import christmas.domain.GiveawayMenu;
import christmas.domain.Menus;
import christmas.domain.TotalOrderPrice;
import christmas.domain.VisitDate;
import christmas.formatter.GiveawayMenuFormatter;
import christmas.formatter.OrderMenuFormatter;
import christmas.formatter.TotalOrderPriceFormatter;
import christmas.repository.BenefitDetailsRepository;
import christmas.repository.ChristmasRepository;

public class ChristmasService {

    private final ChristmasRepository christmasRepository;
    private final BenefitDetailsRepository benefitDetailsRepository;

    public ChristmasService(final ChristmasRepository christmasRepository, final BenefitDetailsRepository benefitDetailsRepository) {
        this.christmasRepository = christmasRepository;
        this.benefitDetailsRepository = benefitDetailsRepository;
    }

    public void saveVisitDate(final VisitDate visitDate) {
        christmasRepository.saveVisitDate(visitDate);
    }

    public void saveOrderMenus(final Menus orderMenus) {
        christmasRepository.saveOrderMenus(orderMenus);
    }

    public Integer getVisitDate() {
        VisitDate visitDate = christmasRepository.getVisitDate();
        return visitDate.getDayOfMonth();
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

    public String checkTotalOrderPrice() {
        TotalOrderPrice totalOrderPrice = christmasRepository.getTotalOrderPrice();
        return TotalOrderPriceFormatter.showTotalOrderPrice(totalOrderPrice);
    }

    public void saveGiveawayMenu() {
        TotalOrderPrice totalOrderPrice = christmasRepository.getTotalOrderPrice();
        GiveawayMenu giveawayMenu = GiveawayMenu.from(totalOrderPrice.canGiveawayEvent());
        christmasRepository.saveGiveawayMenu(giveawayMenu);

    }

    public String checkGiveWayMenu() {
        GiveawayMenu giveawayMenu = christmasRepository.getGiveawayMenu();
        return GiveawayMenuFormatter.showGiveawayMenu(giveawayMenu);
    }

    public void christmasDDayDiscount() {
        VisitDate visitDate = christmasRepository.getVisitDate();
        TotalOrderPrice totalOrderPrice = christmasRepository.getTotalOrderPrice();
        Integer discountPrice = visitDate.christmasDDayDiscount(totalOrderPrice);
        benefitDetailsRepository.saveChristmasDDayDiscount(discountPrice);
    }

    public void daysDiscount() {
        VisitDate visitDate = christmasRepository.getVisitDate();
        String dayOfWeek = visitDate.getDayOfWeek();
        Menus orderMenus = christmasRepository.getOrderMenus();
        Integer discountPrice = DaysEventCategory.daysDiscount(dayOfWeek, orderMenus);
        benefitDetailsRepository.saveDaysDiscount(discountPrice);
    }

}
