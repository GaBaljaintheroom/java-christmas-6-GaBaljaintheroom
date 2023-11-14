package christmas.domain.menu;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("가격 객체에 대해")
class PriceTest {

    @Test
    @DisplayName("가격 값을 저장할 수 있다.")
    void Given_CreatePrice_When_GetPrice_Then_EqualExpect() {
        //given
        Price price = Price.from(10000);

        //when
        Integer actual = price.getMenuPrice();

        //then
        assertThat(actual).isEqualTo(10000);
    }
}