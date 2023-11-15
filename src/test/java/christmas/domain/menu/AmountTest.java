package christmas.domain.menu;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("수량 객체에 대해")
class AmountTest {

    @Test
    @DisplayName("수량 값을 저장할 수 있다.")
    void Given_CreateAmount_When_GetAmountValue_Then_EqualExpect() {
        //given
        Amount amount = Amount.from(3);

        //when
        Integer actual = amount.getMenuAmount();

        //then
        assertThat(actual).isEqualTo(3);
    }
}


