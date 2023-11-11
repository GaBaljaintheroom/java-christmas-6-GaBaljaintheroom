package christmas.domain;

import christmas.constants.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

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

    private List<Menu> duplicatedMenuSources() {
        return List.of(Menu.of(Name.from("티본스테이크"), Price.from(55_000)),
                Menu.of(Name.from("티본스테이크"), Price.from(54_000)),
                Menu.of(Name.from("해산물파스타"), Price.from(35_000)),
                Menu.of(Name.from("해산물파스타"), Price.from(25_000))
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
    @DisplayName("중복된 메뉴를 저장하면 에러가 발생한다.")
    void When_InputDuplicatedMenu_Then_ThrowException() {
        assertThatThrownBy(() -> Menus.from(duplicatedMenuSources()))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(errorTage);
    }

    @Test
    @DisplayName("정상적인 메뉴를 저장한다.")
    void When_InputNormalMenu_Then_NotThrowException() {
        assertThatCode(() -> Menus.from(normalMenuSources()))
                .doesNotThrowAnyException();
    }

}
