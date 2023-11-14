package christmas.constants;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import christmas.constants.message.ErrorMessage;
import christmas.domain.menu.Amount;
import christmas.domain.menu.Menu;
import christmas.domain.menu.Menus;
import christmas.domain.menu.Name;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

@DisplayName("메뉴판 상수에 대헤")
class MenuBoardTest {

    private static final String errorTage = ErrorMessage.ERROR_TAG.toString();

    static Stream<List<Menu>> notExistOrderMenus() {
        return Stream.of(List.of(
                Menu.of(Name.from("양송이스푸푸"), Amount.from(1)),
                Menu.of(Name.from("타파스"), Amount.from(1)),
                Menu.of(Name.from("초코켘이크"), Amount.from(1)),
                Menu.of(Name.from("레드와인"), Amount.from(1)))
        );
    }

    static Stream<List<Menu>> normalOrderMenus() {
        return Stream.of(List.of(
                Menu.of(Name.from("양송이수프"), Amount.from(1)),
                Menu.of(Name.from("타파스"), Amount.from(1)),
                Menu.of(Name.from("초코케이크"), Amount.from(1)),
                Menu.of(Name.from("레드와인"), Amount.from(1)))
        );
    }

    @ParameterizedTest
    @MethodSource("notExistOrderMenus")
    @DisplayName("없는 메뉴를 주문할 시 예외가 발생한다.")
    void When_NotExistMenuInMenuBoard_Then_ThrowException(List<Menu> menus) {
        assertThatThrownBy(() -> MenuBoard.validateExistMenu(menus))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(errorTage);
    }

    @ParameterizedTest
    @MethodSource("normalOrderMenus")
    @DisplayName("정상적으로 주문을 한다.")
    void When_ExistMenuInMenuBoard_Then_NotThrowException(List<Menu> menus) {
        assertThatCode(() -> MenuBoard.validateExistMenu(menus))
                .doesNotThrowAnyException();
    }

    @ParameterizedTest
    @MethodSource("normalOrderMenus")
    @DisplayName("주문한 메뉴의 총 가격을 계산한다.")
    void Given_OrderMenus_When_CalculateTotalOrderPrice_Then_EqualActual(List<Menu> menus) {
        //given
        Menus orderMenus = Menus.from(menus);

        //when
        Integer actual = MenuBoard.calculateTotalOrderPrice(orderMenus);

        //then
        assertThat(actual).isEqualTo(86_500);
    }

    @ParameterizedTest
    @MethodSource("normalOrderMenus")
    @DisplayName("주문 메뉴개수가 각 카테고리별 메뉴들과 몇 개 일치하는지 계산한다.")
    void Given_OrderMenus_When_MatchCategoryMenus_Then_MatchCount(List<Menu> menus) {
        //given
        Menus orderMenus = Menus.from(menus);

        //when
        Long matchCount = MenuBoard.DESSERT_MENU.matchingOrderMenuCount(orderMenus);

        //then
        assertThat(matchCount).isEqualTo(1);
    }

}
