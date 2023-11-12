package christmas.constants;

import christmas.domain.TotalOrderPrice;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("특별 이벤트 날짜 상수에 대해")
class SpecialEventDayTest {

    @Test
    @DisplayName("특별 이벤트 날짜에 방문을 하면 할인해준다.")
    void Given_VisitSpecialEventDay_When_Discount_Then_Discount() {
        //given
        TotalOrderPrice totalOrderPrice = TotalOrderPrice.from(10000);
        Integer dayOfMonth = 3;

        //when
        Integer actual = SpecialEventDay.specialDayEventDiscount(totalOrderPrice, dayOfMonth);

        //then
        assertThat(actual).isEqualTo(1_000);
    }

    @Test
    @DisplayName("특별 이벤트 날짜에 방문을 안하면 할인을 안해준다.")
    void Given_VisitSpecialEventDay_When_Discount_Then_Discount1000() {
        //given
        TotalOrderPrice totalOrderPrice = TotalOrderPrice.from(10000);
        Integer dayOfMonth = 4;

        //when
        Integer actual = SpecialEventDay.specialDayEventDiscount(totalOrderPrice, dayOfMonth);

        //then
        assertThat(actual).isEqualTo(0);
    }
}
