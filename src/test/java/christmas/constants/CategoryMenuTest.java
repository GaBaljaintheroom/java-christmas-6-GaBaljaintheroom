package christmas.constants;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import christmas.constants.message.ErrorMessage;
import christmas.domain.menu.Amount;
import christmas.domain.menu.Menu;
import christmas.domain.menu.Name;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

@DisplayName("카테고리 메뉴 상수에 대해")
class CategoryMenuTest {

    private static final String errorTage = ErrorMessage.ERROR_TAG.toString();

    static Stream<List<Menu>> onlyBeverageOrders() {
        return Stream.of(List.of(
                Menu.of(Name.from("제로콜라"), Amount.from(1)),
                Menu.of(Name.from("레드와인"), Amount.from(1)),
                Menu.of(Name.from("샴페인"), Amount.from(1)))
        );
    }

    static Stream<List<Menu>> normalMenuOrders() {
        return Stream.of(List.of(
                Menu.of(Name.from("제로콜라"), Amount.from(1)),
                Menu.of(Name.from("레드와인"), Amount.from(1)),
                Menu.of(Name.from("바비큐립"), Amount.from(1)))
        );
    }

    @ParameterizedTest
    @MethodSource("onlyBeverageOrders")
    @DisplayName("음료만 주문시 예외가 발생한다.")
    void When_OnlyBeverageOrder_Then_ThrowException(List<Menu> menus) {
        assertThatThrownBy(() -> CategoryMenu.validateOnlyBeverageOrder(menus))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(errorTage);
    }

    @ParameterizedTest
    @MethodSource("normalMenuOrders")
    @DisplayName("정상적으로 주문을 한다.")
    void When_InputCorrectOrder_Then_NotThrowException(List<Menu> menus) {
        assertThatCode(() -> CategoryMenu.validateOnlyBeverageOrder(menus))
                .doesNotThrowAnyException();
    }
}
