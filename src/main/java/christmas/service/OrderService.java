package christmas.service;

import christmas.constants.MenuBoard;
import christmas.domain.preview.ExpectPaymentPrice;
import christmas.domain.menu.Menus;
import christmas.domain.preview.TotalDiscountPrice;
import christmas.domain.preview.TotalOrderPrice;
import christmas.domain.VisitDate;
import christmas.formatter.ExpectPaymentPriceFormatter;
import christmas.formatter.OrderMenuFormatter;
import christmas.formatter.TotalOrderPriceFormatter;
import christmas.repository.EventDetailsRepository;
import christmas.repository.OrderRepository;

public class OrderService {

    private final OrderRepository orderRepository;
    private final EventDetailsRepository benefitDetailsRepository;

    public OrderService(final OrderRepository orderRepository,
                        final EventDetailsRepository benefitDetailsRepository) {
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

    public String checkExpectPaymentPrice() {
        TotalOrderPrice totalOrderPrice = orderRepository.getTotalOrderPrice();
        TotalDiscountPrice totalDiscountPrice = benefitDetailsRepository.getTotalDiscountPrice();

        Integer price = totalOrderPrice.getOrderPrice() - totalDiscountPrice.getDiscountPrice();
        ExpectPaymentPrice expectPaymentPrice = ExpectPaymentPrice.from(price);

        orderRepository.saveExpectPaymentPrice(expectPaymentPrice);
        return ExpectPaymentPriceFormatter.showExpectPaymentPrice(expectPaymentPrice);
    }

}
