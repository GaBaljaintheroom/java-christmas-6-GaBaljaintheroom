package christmas.repository;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("레포지토리 객체에 대해")
class RepositoryTest {

    @Test
    @DisplayName("도메인이 null 이면 예외가 발생한다.")
    void When_Then_() {
        //when
        EventDetailsRepository eventDetailsRepository = EventDetailsRepository.INSTANCE;
        OrderRepository orderRepository = OrderRepository.INSTANCE;

        //then
        assertThatThrownBy(eventDetailsRepository::getTotalDiscountPrice)
                .isInstanceOf(IllegalStateException.class);
        assertThatThrownBy(orderRepository::getOrderMenus)
                .isInstanceOf(IllegalStateException.class);
    }
}
