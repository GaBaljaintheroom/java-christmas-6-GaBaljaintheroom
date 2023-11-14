package christmas.constants;

import static org.assertj.core.api.Assertions.assertThat;

import christmas.domain.VisitDate;
import christmas.domain.preview.ChristmasDDayDiscount;
import christmas.domain.preview.DaysDiscount;
import christmas.domain.preview.GiveawayMenu;
import christmas.domain.preview.SpecialEventDiscount;
import christmas.domain.preview.TotalDiscountPrice;
import christmas.domain.preview.TotalOrderPrice;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("이벤트 베지 상수에 대해")
class EventBadgeTest {
    private final TotalOrderPrice totalOrderPrice = TotalOrderPrice.from(10000);
    private final VisitDate visitDate = VisitDate.from(3);
    private final ChristmasDDayDiscount christmasDDayDiscount = ChristmasDDayDiscount.from(totalOrderPrice, visitDate);
    private final DaysDiscount daysDiscount = DaysDiscount.from(totalOrderPrice, visitDate, 1200);
    private final SpecialEventDiscount specialEventDiscount = SpecialEventDiscount.from(totalOrderPrice, 1000);
    private final TotalDiscountPrice totalDiscountPrice = TotalDiscountPrice.from(christmasDDayDiscount, daysDiscount,
            specialEventDiscount);
    private final GiveawayMenu giveawayMenu = GiveawayMenu.from(true);

    @Test
    @DisplayName("총혜택 금액에 따른 배지를 반환한다.")
    void When_OverTotalBenefitPrice_Then_GetBadge() {
        //when
        String actual = EventBadge.getBadgeByTotalBenefitPrice(totalDiscountPrice, giveawayMenu);

        //then
        assertThat(actual).isEqualTo("산타");
    }
}
