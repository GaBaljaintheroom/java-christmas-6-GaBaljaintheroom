package christmas.domain.menu;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import christmas.constants.message.ErrorMessage;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("메뉴들 객체에 대해")
class MenusTest {

    private static final String errorTage = ErrorMessage.ERROR_TAG.toString();
    private final Menus menus = Menus.from(normalMenuSources());

    private List<Menu> normalMenuSources() {
        return List.of(Menu.of(Name.from("티본스테이크"), Price.from(55_000)),
                Menu.of(Name.from("바비큐립"), Price.from(54_000)),
                Menu.of(Name.from("해산물파스타"), Price.from(35_000)),
                Menu.of(Name.from("크리스마스파스타"), Price.from(25_000))
        );
    }

    @Test
    @DisplayName("이름이 메뉴들에 포함되어 있으면 true를 반환한다.")
    void When_IsContainMenuInMenus_Then_ReturnTrue() {
        //when
        boolean actual = menus.isContainMenuName(Name.from("바비큐립"));

        //then
        assertTrue(actual);
    }

    @Test
    @DisplayName("이름이 메뉴들에 포함되어 있지 않으면 false를 반환한다.")
    void When_IsNotContainMenuInMenus_Then_ReturnFalse() {
        //when
        boolean actual = menus.isContainMenuName(Name.from("제로콜라"));

        //then
        assertFalse(actual);
    }

    @Test
    @DisplayName("중복된 메뉴를 저장하면 예외가 발생한다.")
    void When_InputDuplicatedMenu_Then_ThrowException() {
        assertThatThrownBy(() -> Menus.from(duplicatedMenuSources()))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(errorTage);
    }

    private List<Menu> duplicatedMenuSources() {
        return List.of(Menu.of(Name.from("티본스테이크"), Price.from(55_000)),
                Menu.of(Name.from("티본스테이크"), Price.from(54_000)),
                Menu.of(Name.from("해산물파스타"), Price.from(35_000)),
                Menu.of(Name.from("해산물파스타"), Price.from(25_000))
        );
    }

    @Test
    @DisplayName("정상적인 중복 없는 메뉴를 저장한다.")
    void When_InputNormalMenu_Then_NotThrowException() {
        assertThatCode(() -> Menus.from(normalMenuSources()))
                .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("한 번에 20가지 넘게 주문을 하면 예외가 발생한다.")
    void When_OverOrderMenuCount_Then_ThrowException() {
        assertThatThrownBy(() -> Menus.from(overOrderMenuCountSources()))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(errorTage);
    }

    private List<Menu> overOrderMenuCountSources() {
        return List.of(Menu.of(Name.from("티본스테이크"), Amount.from(10)),
                Menu.of(Name.from("해산물파스타"), Amount.from(25))
        );
    }

    @Test
    @DisplayName("정상적인 20가지 이하 주문을 저장한다.")
    void When_InputNormalOrderMenuCount_Then_NotThrowException() {
        assertThatCode(() -> Menus.from(normalOrderMenuCountSources()))
                .doesNotThrowAnyException();
    }

    private List<Menu> normalOrderMenuCountSources() {
        return List.of(Menu.of(Name.from("티본스테이크"), Amount.from(10)),
                Menu.of(Name.from("해산물파스타"), Amount.from(10))
        );
    }

    @Test
    @DisplayName("이름과 일치하는 메뉴의 가격을 반환한다.")
    void When_GetPriceValueByMenuName_Then_EqualExpect() {
        //when
        Integer actual = menus.getPriceValueByMenuName(Menu.of(Name.from("티본스테이크"), Amount.from(1)));

        //then
        assertThat(actual).isEqualTo(55000);
    }

    @Test
    @DisplayName("이름과 일치하는 메뉴의 개수를 반환한다.")
    void Given_OrderMenus_When_MatchingOrderMenuCount_Then_EqualExpect() {
        //given
        List<Menu> orderMenus = List.of(Menu.of(Name.from("티본스테이크"), Amount.from(1)));

        //when
        Long actual = menus.matchingOrderMenuCount(Menus.from(orderMenus));

        //then
        assertThat(actual).isEqualTo(1);
    }

}
