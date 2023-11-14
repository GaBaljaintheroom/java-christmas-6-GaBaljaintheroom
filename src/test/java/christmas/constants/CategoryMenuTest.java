package christmas.constants;

import christmas.constants.message.ErrorMessage;
import christmas.domain.menu.Menu;
import christmas.domain.menu.Name;
import christmas.domain.menu.Price;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

@DisplayName("카테고리 메뉴 상수에 대해")
class CategoryMenuTest {

    private static final String errorTage = ErrorMessage.ERROR_TAG.toString();

    static Stream<List<Menu>> onlyBeverageSources() {
        return Stream.of(List.of(
                Menu.of(Name.from("제로콜라"), Price.from(15_000)),
                Menu.of(Name.from("레드와인"), Price.from(5_000)),
                Menu.of(Name.from("샴페인"), Price.from(25_000)))
        );
    }

    static Stream<List<Menu>> normalMenuSources() {
        return Stream.of(List.of(
                Menu.of(Name.from("제로콜라"), Price.from(15_000)),
                Menu.of(Name.from("레드와인"), Price.from(5_000)),
                Menu.of(Name.from("바비큐립"), Price.from(25_000)))
        );
    }

    @ParameterizedTest
    @MethodSource("onlyBeverageSources")
    @DisplayName("음료만 주문시 예외가 발생한다.")
    void When_OnlyBeverageOrder_Then_ThrowException(List<Menu> menus) {
        assertThatThrownBy(() -> CategoryMenu.validateOnlyBeverageOrder(menus))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(errorTage);
    }

    @ParameterizedTest
    @MethodSource("normalMenuSources")
    @DisplayName("정상적으로 주문을 한다.")
    void When_InputCorrectOrder_Then_NotThrowException(List<Menu> menus) {
        assertThatCode(() -> CategoryMenu.validateOnlyBeverageOrder(menus))
                .doesNotThrowAnyException();
    }
}
