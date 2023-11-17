package christmas.domain.preview;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("총 주문 금액 객체에 대해")
class TotalOrderPriceTest {

    @Test
    @DisplayName("총 주문 금액을 저장한다.")
    void Given_CreateTotalOrderPrice_When_GetOrderPrice_Then_EqualExpect() {
        //given
        TotalOrderPrice totalOrderPrice = TotalOrderPrice.from(20000);

        //when
        Integer actual = totalOrderPrice.getOrderPrice();

        //then
        assertThat(actual).isEqualTo(20000);
    }

    @Test
    @DisplayName("증정 이벤트를 참여할 수 있으면 true를 반환한다.")
    void Given_CreateTotalOrderPrice_When_CanGiveawayEvent_Then_ReturnTrue() {
        //given
        TotalOrderPrice totalOrderPrice = TotalOrderPrice.from(200000);

        //when
        Boolean actual = totalOrderPrice.canGiveawayEvent();

        //then
        assertTrue(actual);
    }

    @Test
    @DisplayName("증정 이벤트를 참여할 수 없으면 false를 반환한다.")
    void Given_CreateTotalOrderPrice_When_CanGiveawayEvent_Then_ReturnFalse() {
        //given
        TotalOrderPrice totalOrderPrice = TotalOrderPrice.from(1000);

        //when
        Boolean actual = totalOrderPrice.canGiveawayEvent();

        //then
        assertFalse(actual);
    }

    @Test
    @DisplayName("총 혜택이 10,000 이상이면 true를 반환한다.")
    void Given_CreateTotalOrderPrice_When_CahApplyEvent_Then_ReturnTrue() {
        //given
        TotalOrderPrice totalOrderPrice = TotalOrderPrice.from(10000);

        //when
        Boolean actual = totalOrderPrice.canApplyEvent();

        //then
        assertTrue(actual);
    }

    @Test
    @DisplayName("총 혜택이 10,000 미만이면 false를 반환한다.")
    void Given_CreateTotalOrderPrice_When_CahNotApplyEvent_Then_ReturnFalse() {
        //given
        TotalOrderPrice totalOrderPrice = TotalOrderPrice.from(5000);

        //when
        Boolean actual = totalOrderPrice.canApplyEvent();

        //then
        assertFalse(actual);
    }
}
