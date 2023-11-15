package christmas.service;

import static org.assertj.core.api.Assertions.assertThat;

import christmas.domain.VisitDate;
import christmas.domain.menu.Amount;
import christmas.domain.menu.Menu;
import christmas.domain.menu.Menus;
import christmas.domain.menu.Name;
import christmas.domain.preview.ChristmasDDayDiscount;
import christmas.domain.preview.DaysDiscount;
import christmas.domain.preview.SpecialEventDiscount;
import christmas.domain.preview.TotalOrderPrice;
import christmas.repository.EventDetailsRepository;
import christmas.repository.OrderRepository;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("이벤트 상세 서비스 객체에 대해")
class EventDetailServiceTest {

    private final OrderRepository orderRepository = OrderRepository.INSTANCE;
    private final EventDetailsRepository eventDetailsRepository = EventDetailsRepository.INSTANCE;

    private final EventDetailService eventDetailService = new EventDetailService(orderRepository,
            eventDetailsRepository);

    @Test
    @DisplayName("크리스마스 디데이 할인 객체를 저장할 수 있다.")
    void Given_SaveChritmasDDayDiscount_When_GetDiscount_Then_EqualActual() {
        //given
        orderRepository.saveVisitDate(VisitDate.from(3));
        orderRepository.saveTotalOrderPrice(TotalOrderPrice.from(120_000));
        eventDetailService.saveChristmasDDayDiscount();

        //when
        ChristmasDDayDiscount christMasDDayDiscount = eventDetailsRepository.getChristMasDDayDiscount();
        Integer actual = christMasDDayDiscount.getDiscount();

        //then
        assertThat(actual).isEqualTo(1200);
    }

    @Test
    @DisplayName("요일 할인 객체를 저장할 수 있다.")
    void Given_SaveDaysDiscount_When_GetDiscount_Then_EqualActual() {
        //given
        orderRepository.saveVisitDate(VisitDate.from(3));
        orderRepository.saveTotalOrderPrice(TotalOrderPrice.from(120_000));
        orderRepository.saveOrderMenus(Menus.from(List.of(Menu.of(Name.from("초코케이크"), Amount.from(1)))));
        eventDetailService.saveDaysDiscount();

        //when
        DaysDiscount daysDiscount = eventDetailsRepository.getDaysDiscount();
        Integer discount = daysDiscount.getDiscount();

        //then
        assertThat(discount).isEqualTo(2023);
    }

    @Test
    @DisplayName("특별 이벤트 할인 객체를 저장할 수 있다.")
    void Given_SaveSpecialEventDiscount_When_GetDiscount_Then_EqualActual() {
        //given
        orderRepository.saveTotalOrderPrice(TotalOrderPrice.from(120_000));
        orderRepository.saveVisitDate(VisitDate.from(3));
        eventDetailService.saveSpecialEventDiscount();

        //when
        SpecialEventDiscount specialEventDiscount = eventDetailsRepository.getSpecialEventDiscount();
        Integer discount = specialEventDiscount.getDiscount();

        //then
        assertThat(discount).isEqualTo(1000);
    }

}
