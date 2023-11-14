package christmas.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertTrue;

import christmas.domain.menu.Amount;
import christmas.domain.menu.Menu;
import christmas.domain.menu.Name;
import christmas.domain.menu.Price;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("메뉴 객체에 대해")
class MenuTest {

    @Test
    @DisplayName("이름과 가격으로 객체를 생성한다.")
    void Given_CreateMenuByNameAndPrice_When_GetValues_Then_AllEqual() {
        //given
        Name name = Name.from("제로콜라");
        Price price = Price.from(3000);

        //when
        Menu menu = Menu.of(name, price);
        String menuName = menu.getMenuNameValue();
        Integer priceValue = menu.getMenuPriceValue();
        Integer menuAmountValue = menu.getMenuAmountValue();

        //then
        assertAll(
                () -> assertThat(menuName).isEqualTo("제로콜라"),
                () -> assertThat(priceValue).isEqualTo(3000),
                () -> assertThat(menuAmountValue).isZero()
        );
    }

    @Test
    @DisplayName("이름과 수량으로 객체를 생성할 수 있다.")
    void Given_CreateMenuByNameAndAmount_When_GetValues_Then_AllEqual() {
        //given
        Name name = Name.from("제로콜라");
        Amount amount = Amount.from(1);

        //when
        Menu menu = Menu.of(name, amount);
        String menuName = menu.getMenuNameValue();
        Integer menuAmountValue = menu.getMenuAmountValue();
        Integer priceValue = menu.getMenuPriceValue();

        //then
        assertAll(
                () -> assertThat(menuName).isEqualTo("제로콜라"),
                () -> assertThat(priceValue).isZero(),
                () -> assertThat(menuAmountValue).isEqualTo(1)
        );
    }

    @Test
    @DisplayName("이름으로 메뉴가 같은지 판별한다.")
    void Given_When_Then_() {
        //given
        Name name = Name.from("제로콜라");
        Amount amount = Amount.from(1);
        Menu menu = Menu.of(name, amount);

        //when
        Name expect = Name.from("제로콜라");
        boolean isEqualName = menu.isEqualName(expect);

        //then
        assertTrue(isEqualName);

    }
}
