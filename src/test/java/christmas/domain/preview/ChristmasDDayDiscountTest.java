package christmas.domain.preview;

import static org.assertj.core.api.Assertions.assertThat;

import christmas.domain.VisitDate;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("크라스마스 디데이 할인 객체에 대해")
class ChristmasDDayDiscountTest {

    private final TotalOrderPrice totalOrderPrice = TotalOrderPrice.from(120_000);

    @Test
    @DisplayName("25일 넘지 않은 방문 날짜는 할인을 할 수 있다.")
    void Given_VisitDatENotOverEventDay_When_GetDiscount_Then_Discount() {
        //given
        VisitDate visitDate = VisitDate.from(3);
        ChristmasDDayDiscount christmasDDayDiscount = ChristmasDDayDiscount.from(totalOrderPrice, visitDate);

        //when
        Integer actual = christmasDDayDiscount.getDiscount();

        //then
        assertThat(actual).isEqualTo(1200);
    }

    @Test
    @DisplayName("25일 넘은 방문 날짜는 할인을 할 수 없다.")
    void Given_VisitDatEOverEventDay_When_GetDiscount_Then_NoDiscount() {
        //given
        VisitDate visitDate = VisitDate.from(30);
        ChristmasDDayDiscount christmasDDayDiscount = ChristmasDDayDiscount.from(totalOrderPrice, visitDate);

        //when
        Integer actual = christmasDDayDiscount.getDiscount();

        //then
        assertThat(actual).isZero();
    }

    @Test
    @DisplayName("총 주문 금액이 10,000원을 넘지 않았을 때 할인을 할 수 없다.")
    void Given_TotalOrderPriceNotOverStandard_When_GetDiscount_Then_NoDiscount() {
        //given
        TotalOrderPrice totalOrderPrice = TotalOrderPrice.from(1000);
        VisitDate visitDate = VisitDate.from(3);
        ChristmasDDayDiscount christmasDDayDiscount = ChristmasDDayDiscount.from(totalOrderPrice, visitDate);

        //when
        Integer discount = christmasDDayDiscount.getDiscount();

        //then
        assertThat(discount).isZero();

    }
}
