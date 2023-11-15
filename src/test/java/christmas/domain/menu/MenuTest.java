package christmas.domain.menu;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
        String actualMenuName = menu.getMenuNameValue();
        Integer actualPriceValue = menu.getMenuPriceValue();
        Integer actualMenuAmountValue = menu.getMenuAmountValue();

        //then
        assertAll(
                () -> assertThat(actualMenuName).isEqualTo("제로콜라"),
                () -> assertThat(actualPriceValue).isEqualTo(3000),
                () -> assertThat(actualMenuAmountValue).isZero()
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
        String actualMenuName = menu.getMenuNameValue();
        Integer actualMenuAmountValue = menu.getMenuAmountValue();
        Integer actualPriceValue = menu.getMenuPriceValue();

        //then
        assertAll(
                () -> assertThat(actualMenuName).isEqualTo("제로콜라"),
                () -> assertThat(actualMenuAmountValue).isEqualTo(1),
                () -> assertThat(actualPriceValue).isZero()
        );
    }

    @Test
    @DisplayName("이름으로 메뉴가 같으면 true를 반환한다.")
    void Given_CreateMenu_When_EqualMenuName_Then_ReturnTrue() {
        //given
        Name name = Name.from("제로콜라");
        Amount amount = Amount.from(1);
        Menu menu = Menu.of(name, amount);

        //when
        Name coke = Name.from("제로콜라");
        boolean actual = menu.isEqualName(coke);

        //then
        assertTrue(actual);
    }

    @Test
    @DisplayName("이름으로 메뉴가 같으면 false를 반환한다.")
    void Given_CreateMenu_When_NotEqualMenuName_Then_ReturnFalse() {
        //given
        Name name = Name.from("제로콜라");
        Amount amount = Amount.from(1);
        Menu menu = Menu.of(name, amount);

        //when
        Name coke = Name.from("콜라");
        boolean actual = menu.isEqualName(coke);

        //then
        assertFalse(actual);
    }
}
