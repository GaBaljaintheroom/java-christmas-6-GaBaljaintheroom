package christmas.domain.preview;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import christmas.domain.VisitDate;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("요일 할인 객체에 대해")
class DaysDiscountTest {

    @Test
    @DisplayName("총 주문 금액과 방문 날짜로 할인 객체를 생성한다.")
    void Given_CreateDiscountByTotalOrderPriceAndVisitDate_When_GetValues_Then_EqualExpect() {
        //given
        TotalOrderPrice totalOrderPrice = TotalOrderPrice.from(10000);
        VisitDate visitDate = VisitDate.from(3);

        //when
        DaysDiscount daysDiscount = DaysDiscount.from(totalOrderPrice, visitDate, 1200);
        Integer discount = daysDiscount.getDiscount();
        String dayType = daysDiscount.getDayType();

        //then
        assertAll(
                () -> assertThat(discount).isEqualTo(1200),
                () -> assertThat(dayType).isEqualTo("평일")
        );
    }

    @Test
    @DisplayName("총 주문 금액이 10,000이 넘지 않으면 할인을 할 수 없다.")
    void Given_TotalOrderPriceNotOveStandard_When_GetDiscount_Then_NoDiscount() {
        //given
        TotalOrderPrice totalOrderPrice = TotalOrderPrice.from(5000);
        VisitDate visitDate = VisitDate.from(3);

        //when
        DaysDiscount daysDiscount = DaysDiscount.from(totalOrderPrice, visitDate, 1200);
        Integer discount = daysDiscount.getDiscount();

        //then
        assertThat(discount).isZero();
    }
}
