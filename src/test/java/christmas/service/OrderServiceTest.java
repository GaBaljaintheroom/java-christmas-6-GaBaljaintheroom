package christmas.service;

import static org.assertj.core.api.Assertions.assertThat;

import christmas.domain.VisitDate;
import christmas.domain.menu.Amount;
import christmas.domain.menu.Menu;
import christmas.domain.menu.Menus;
import christmas.domain.menu.Name;
import christmas.repository.EventDetailsRepository;
import christmas.repository.OrderRepository;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("주문 서비스 객체에 대해")
class OrderServiceTest {

    private final OrderRepository orderRepository = OrderRepository.INSTANCE;
    private final EventDetailsRepository eventDetailsRepository = EventDetailsRepository.INSTANCE;
    private final OrderService orderService = new OrderService(orderRepository, eventDetailsRepository);

    @Test
    @DisplayName("방문 날짜 객체를 저장하여 일을 반환할 수 있다.")
    void Given_SaveVisitDate_When_GetDayOfMonth_Then_EqualExpect() {
        //given
        VisitDate visitDate = VisitDate.from(3);
        orderService.saveVisitDate(visitDate);

        //when
        Integer actual = orderService.getVisitDate();

        //then
        assertThat(actual).isEqualTo(3);
    }

    @Test
    @DisplayName("주문 내역을 확인 할 수 있다.")
    void Given_SaveOrderMenus_When_CheckOrderMenus_Then_EqualExpect() {
        //given
        Menus menus = Menus.from(normalMenuOrders());

        //when
        String actual = orderService.checkOrderMenus(menus);

        //then
        assertThat(actual).isEqualTo("""
                <주문 메뉴>
                제로콜라 1개
                레드와인 1개
                바비큐립 1개
                """);
    }

    @Test
    @DisplayName("총 주문 금액을 확인할 수 있다.")
    void Given_OrderMenus_When_CheckTotalOrderPrice_Then_EqualExpect() {
        //given
        Menus menus = Menus.from(normalMenuOrders());
        orderService.checkOrderMenus(menus);

        //when
        String actual = orderService.checkTotalOrderPrice();

        //then
        assertThat(actual).isEqualTo("""
                <할인 전 총주문 금액>
                117,000원
                """);
    }

    private List<Menu> normalMenuOrders() {
        return List.of(
                Menu.of(Name.from("제로콜라"), Amount.from(1)),
                Menu.of(Name.from("레드와인"), Amount.from(1)),
                Menu.of(Name.from("바비큐립"), Amount.from(1))
        );
    }
}
