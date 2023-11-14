package christmas.domain.preview;

import static org.assertj.core.api.Assertions.assertThat;

import christmas.domain.VisitDate;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("총 할인 금액 객체에 대해")
class TotalDiscountPriceTest {


    private final TotalOrderPrice totalOrderPrice = TotalOrderPrice.from(10000);
    private final VisitDate visitDate = VisitDate.from(3);
    private final ChristmasDDayDiscount christmasDDayDiscount = ChristmasDDayDiscount.from(totalOrderPrice, visitDate);
    private final DaysDiscount daysDiscount = DaysDiscount.from(totalOrderPrice, visitDate, 2023);
    private final SpecialEventDiscount specialEventDiscount = SpecialEventDiscount.from(totalOrderPrice, 1000);

    @Test
    @DisplayName("총 할인 금액을 저장한다.")
    void Given_When_Then_() {
        //given
        TotalDiscountPrice totalDiscountPrice = TotalDiscountPrice.from(christmasDDayDiscount, daysDiscount,
                specialEventDiscount);

        //when
        Integer discountPrice = totalDiscountPrice.getDiscountPrice();

        //then
        assertThat(discountPrice).isEqualTo(4223);
    }
}
