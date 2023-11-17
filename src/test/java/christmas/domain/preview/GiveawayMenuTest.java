package christmas.domain.preview;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("증정 메뉴 객체에 대해")
class GiveawayMenuTest {

    @Test
    @DisplayName("샴페인 혜택을 받는다.")
    void Given_CanGiveawayEvent_When_GetPrice_Then_EqualExpect() {
        //given
        GiveawayMenu giveawayMenu = GiveawayMenu.from(true);

        //when
        Integer actual = giveawayMenu.getPrice();

        //then
        assertThat(actual).isEqualTo(25000);
    }

    @Test
    @DisplayName("샴페인 혜택을 받지 못한다.")
    void Given_CanNotGiveawayEvent_When_GetPrice_Then_Zero() {
        //given
        GiveawayMenu giveawayMenu = GiveawayMenu.from(false);

        //when
        Integer actual = giveawayMenu.getPrice();

        //then
        assertThat(actual).isZero();
    }
}
