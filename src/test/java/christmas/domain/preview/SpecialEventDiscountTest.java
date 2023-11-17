package christmas.domain.preview;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("특별 할인 객체에 대해")
class SpecialEventDiscountTest {

    @Test
    @DisplayName("할인 값을 저장할 수 있다.")
    void Given_CreateSpecialEventDiscount_When_GetDiscount_Then_EqualExpect() {
        //given
        TotalOrderPrice totalOrderPrice = TotalOrderPrice.from(10000);
        SpecialEventDiscount specialEventDiscount = SpecialEventDiscount.from(totalOrderPrice, 1000);

        //when
        Integer discount = specialEventDiscount.getDiscount();

        //then
        assertThat(discount).isEqualTo(1000);
    }

    @Test
    @DisplayName("할인이 되지 않았다.")
    void Given_CreateSpecialEventDiscount_When_GetDiscount_Then_NoDiscount() {
        //given
        TotalOrderPrice totalOrderPrice = TotalOrderPrice.from(5000);
        SpecialEventDiscount specialEventDiscount = SpecialEventDiscount.from(totalOrderPrice, 1000);

        //when
        Integer discount = specialEventDiscount.getDiscount();

        //then
        assertThat(discount).isZero();
    }
}
