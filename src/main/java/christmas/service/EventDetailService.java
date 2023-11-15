package christmas.service;

import christmas.constants.DaysEventCategory;
import christmas.constants.EventBadge;
import christmas.constants.SpecialEventDay;
import christmas.domain.VisitDate;
import christmas.domain.menu.Menus;
import christmas.domain.preview.ChristmasDDayDiscount;
import christmas.domain.preview.DaysDiscount;
import christmas.domain.preview.GiveawayMenu;
import christmas.domain.preview.SpecialEventDiscount;
import christmas.domain.preview.TotalDiscountPrice;
import christmas.domain.preview.TotalOrderPrice;
import christmas.formatter.BenefitDetailsFormatter;
import christmas.formatter.EventBadgeFormatter;
import christmas.formatter.GiveawayMenuFormatter;
import christmas.formatter.TotalBenefitPriceFormatter;
import christmas.repository.EventDetailsRepository;
import christmas.repository.OrderRepository;

public class EventDetailService {

    private final OrderRepository orderRepository;
    private final EventDetailsRepository eventDetailsRepository;

    public EventDetailService(final OrderRepository orderRepository,
                              final EventDetailsRepository benefitDetailsRepository) {
        this.orderRepository = orderRepository;
        this.eventDetailsRepository = benefitDetailsRepository;
    }

    public String showGiveawayMenuEvent() {
        TotalOrderPrice totalOrderPrice = orderRepository.getTotalOrderPrice();
        GiveawayMenu giveawayMenu = GiveawayMenu.from(totalOrderPrice.canGiveawayEvent());
        eventDetailsRepository.saveGiveawayMenu(giveawayMenu);

        return GiveawayMenuFormatter.showGiveawayMenu(giveawayMenu);
    }

    public void saveChristmasDDayDiscount() {
        VisitDate visitDate = orderRepository.getVisitDate();
        TotalOrderPrice totalOrderPrice = orderRepository.getTotalOrderPrice();

        ChristmasDDayDiscount christmasDDayDiscount = ChristmasDDayDiscount.from(totalOrderPrice, visitDate);
        eventDetailsRepository.saveChristmasDDayDiscount(christmasDDayDiscount);
    }

    public void saveDaysDiscount() {
        TotalOrderPrice totalOrderPrice = orderRepository.getTotalOrderPrice();

        VisitDate visitDate = orderRepository.getVisitDate();
        Menus orderMenus = orderRepository.getOrderMenus();

        Integer discountPrice = DaysEventCategory.daysDiscount(visitDate, orderMenus);
        DaysDiscount daysDiscount = DaysDiscount.from(totalOrderPrice, visitDate, discountPrice);
        eventDetailsRepository.saveDaysDiscount(daysDiscount);
    }

    public void saveSpecialEventDiscount() {
        TotalOrderPrice totalOrderPrice = orderRepository.getTotalOrderPrice();

        VisitDate visitDate = orderRepository.getVisitDate();
        Integer discountPrice = SpecialEventDay.specialDayEventDiscount(visitDate);
        SpecialEventDiscount specialEventDiscount = SpecialEventDiscount.from(totalOrderPrice, discountPrice);
        eventDetailsRepository.saveSpecialEventDayDiscount(specialEventDiscount);
    }

    public String showBenefitDetails() {
        ChristmasDDayDiscount christMasDDayDiscount = eventDetailsRepository.getChristMasDDayDiscount();
        DaysDiscount daysDiscount = eventDetailsRepository.getDaysDiscount();
        SpecialEventDiscount specialEventDiscount = eventDetailsRepository.getSpecialEventDiscount();
        GiveawayMenu giveawayMenu = eventDetailsRepository.getGiveawayMenu();

        TotalDiscountPrice totalDiscountPrice = TotalDiscountPrice.from(christMasDDayDiscount,
                daysDiscount, specialEventDiscount);
        eventDetailsRepository.saveTotalDiscountPrice(totalDiscountPrice);

        return BenefitDetailsFormatter.showBenefitDetails(christMasDDayDiscount, daysDiscount,
                specialEventDiscount, giveawayMenu);
    }

    public String showTotalBenefitPrice() {
        TotalDiscountPrice totalDiscountPrice = eventDetailsRepository.getTotalDiscountPrice();
        GiveawayMenu giveawayMenu = eventDetailsRepository.getGiveawayMenu();
        return TotalBenefitPriceFormatter.showExpectedOrderPrice(totalDiscountPrice, giveawayMenu);
    }

    public String showEventBadge() {
        TotalDiscountPrice totalDiscountPrice = eventDetailsRepository.getTotalDiscountPrice();
        GiveawayMenu giveawayMenu = eventDetailsRepository.getGiveawayMenu();
        String badge = EventBadge.getBadgeByTotalBenefitPrice(totalDiscountPrice, giveawayMenu);
        return EventBadgeFormatter.showEventBadge(badge);
    }
}