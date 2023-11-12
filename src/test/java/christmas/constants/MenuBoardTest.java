package christmas.constants;

import christmas.domain.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.*;

@DisplayName("메뉴판 상수에 대헤")
class MenuBoardTest {

    private static final String errorTage = ErrorMessage.ERROR_TAG.toString();

    static Stream<List<Menu>> notExistMenuSources() {
        return Stream.of(List.of(
                Menu.of(Name.from("양송이스푸푸"), Price.from(6_000)),
                Menu.of(Name.from("타파스"), Price.from(5_500)),
                Menu.of(Name.from("초코켘이크"), Price.from(15_000)),
                Menu.of(Name.from("레드와인"), Price.from(5_000)))
        );
    }

    static Stream<List<Menu>> normalMenuSources() {
        return Stream.of(List.of(
                Menu.of(Name.from("양송이수프"), Price.from(6_000)),
                Menu.of(Name.from("타파스"), Price.from(5_500)),
                Menu.of(Name.from("초코케이크"), Price.from(15_000)),
                Menu.of(Name.from("레드와인"), Price.from(5_000)))
        );
    }

    static Stream<List<Menu>> normalOrderSources() {
        return Stream.of(List.of(
                Menu.of(Name.from("양송이수프"), Amount.from(1)),
                Menu.of(Name.from("타파스"), Amount.from(1)),
                Menu.of(Name.from("초코케이크"), Amount.from(1)),
                Menu.of(Name.from("레드와인"), Amount.from(1)))
        );
    }

    @ParameterizedTest
    @MethodSource("notExistMenuSources")
    @DisplayName("없는 메뉴를 주문할 시 예외가 발생한다.")
    void When_NotExistMenuInMenuBoard_Then_ThrowException(List<Menu> menus) {
        assertThatThrownBy(() -> MenuBoard.validateExistMenu(menus))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(errorTage);
    }

    @ParameterizedTest
    @MethodSource("normalMenuSources")
    @DisplayName("정상적으로 주문을 한다.")
    void When_ExistMenuInMenuBoard_Then_NotThrowException(List<Menu> menus) {
        assertThatCode(() -> MenuBoard.validateExistMenu(menus))
                .doesNotThrowAnyException();
    }

    @ParameterizedTest
    @MethodSource("normalOrderSources")
    @DisplayName("주문한 메뉴의 총 가격을 계산한다.")
    void Given_OrderMenus_When_CalculateTotalOrderPrice_Then_EqualActual(List<Menu> menus) {
        //given
        Menus orderMenus = Menus.from(menus);

        //when
        Integer actual = MenuBoard.calculateTotalOrderPrice(orderMenus);

        //then
        assertThat(actual).isEqualTo(86_500);
    }

}
