package christmas.domain.preview;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("예상 주문 금액 객체에 대해")
class ExpectOrderPriceTest {

    @Test
    @DisplayName("예상 주문 금액을 저장할 수 있다.")
    void Given_When_Then_() {
        //given
        ExpectOrderPrice expectOrderPrice = ExpectOrderPrice.from(1000);

        //when
        Integer expectPrice = expectOrderPrice.getExpectPrice();

        //then
        assertThat(expectPrice).isEqualTo(1000);
    }
}
