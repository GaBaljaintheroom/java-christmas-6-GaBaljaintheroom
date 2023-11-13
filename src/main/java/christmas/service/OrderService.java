package christmas.service;

import christmas.constants.MenuBoard;
import christmas.domain.ExpectOrderPrice;
import christmas.domain.Menus;
import christmas.domain.TotalDiscountPrice;
import christmas.domain.TotalOrderPrice;
import christmas.domain.VisitDate;
import christmas.formatter.ExpectOrderPriceFormatter;
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
        ExpectOrderPrice expectOrderPrice = ExpectOrderPrice.from(price);

        orderRepository.saveExpectOrderPrice(expectOrderPrice);
        return ExpectOrderPriceFormatter.showExpectOrderPrice(expectOrderPrice);
    }

}
