package christmas.service;

import christmas.constants.DaysEventCategory;
import christmas.constants.EventBadge;
import christmas.constants.SpecialEventDay;
import christmas.domain.ChristmasDDayDiscount;
import christmas.domain.DaysDiscount;
import christmas.domain.GiveawayMenu;
import christmas.domain.Menus;
import christmas.domain.SpecialEventDiscount;
import christmas.domain.TotalDiscountPrice;
import christmas.domain.TotalOrderPrice;
import christmas.domain.VisitDate;
import christmas.formatter.BenefitDetailsFormatter;
import christmas.formatter.EventBadgeFormatter;
import christmas.formatter.GiveawayMenuFormatter;
import christmas.formatter.TotalBenefitPriceFormatter;
import christmas.repository.EventDetailsRepository;
import christmas.repository.OrderRepository;

public class EventDetailService {

    private final OrderRepository orderRepository;
    private final EventDetailsRepository benefitDetailsRepository;

    public EventDetailService(final OrderRepository orderRepository,
                              final EventDetailsRepository benefitDetailsRepository) {
        this.orderRepository = orderRepository;
        this.benefitDetailsRepository = benefitDetailsRepository;
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

        TotalDiscountPrice totalDiscountPrice = TotalDiscountPrice.from(christMasDDayDiscount,
                daysDiscount, specialEventDiscount);
        benefitDetailsRepository.saveTotalDiscountPrice(totalDiscountPrice);

        return BenefitDetailsFormatter.showBenefitDetails(christMasDDayDiscount, daysDiscount,
                specialEventDiscount, giveawayMenu);
    }

    public String showTotalBenefitPrice() {
        TotalDiscountPrice totalDiscountPrice = benefitDetailsRepository.getTotalDiscountPrice();
        GiveawayMenu giveawayMenu = benefitDetailsRepository.getGiveawayMenu();
        return TotalBenefitPriceFormatter.showExpectedOrderPrice(totalDiscountPrice, giveawayMenu);
    }

    public String showEventBadge() {
        TotalDiscountPrice totalDiscountPrice = benefitDetailsRepository.getTotalDiscountPrice();
        GiveawayMenu giveawayMenu = benefitDetailsRepository.getGiveawayMenu();
        String badge = EventBadge.getBadgeByTotalBenefitPrice(totalDiscountPrice, giveawayMenu);
        return EventBadgeFormatter.showEventBadge(badge);
    }
}