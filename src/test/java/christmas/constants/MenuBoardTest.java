package christmas.constants;

import christmas.domain.Menu;
import christmas.domain.Name;
import christmas.domain.Price;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

@DisplayName("메뉴판 상수에 대헤")
class MenuBoardTest {

    private static final String errorTage = ErrorMessage.ERROR_TAG.toString();

    @ParameterizedTest
    @MethodSource("menuSources")
    void When_NotExistMenuInMenuBoard_Then_ThrowException(List<Menu> menus) {
        assertThatThrownBy(() -> MenuBoard.validateExistMenu(menus))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(errorTage);


    }

    static Stream<List<Menu>> menuSources() {
        return Stream.of(List.of(
                Menu.of(Name.from("양송이스푸푸"), Price.from(6_000)),
                Menu.of(Name.from("타파스"), Price.from(5_500)),
                Menu.of(Name.from("초코켘이크"), Price.from(15_000)),
                Menu.of(Name.from("레드와인"), Price.from(5_000)))
        );
    }

}
