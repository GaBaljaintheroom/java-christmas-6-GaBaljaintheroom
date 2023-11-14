package christmas.constants;

import christmas.domain.*;
import christmas.domain.menu.Amount;
import christmas.domain.menu.Menu;
import christmas.domain.menu.Menus;
import christmas.domain.menu.Name;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("요일 별 할인 메뉴 카테고리 상수에 대해")
class DaysEventCategoryTest {

    static Stream<List<Menu>> normalOrderSources() {
        return Stream.of(List.of(
                Menu.of(Name.from("양송이수프"), Amount.from(1)),
                Menu.of(Name.from("크리스마스파스타"), Amount.from(1)),
                Menu.of(Name.from("초코케이크"), Amount.from(1)),
                Menu.of(Name.from("레드와인"), Amount.from(1)))
        );
    }

    @ParameterizedTest
    @MethodSource("normalOrderSources")
    @DisplayName("요일에 따른 요일 할인 금액를 적용한다.")
    void Given_CreateOrderMenus_When_daysDiscount_Then_Apply(List<Menu> menus) {
        //given
        Menus orderMenus = Menus.from(menus);

        //when
        Integer discount = DaysEventCategory.daysDiscount(VisitDate.from(4), orderMenus);

        //then
        assertThat(discount).isEqualTo(2023);
    }
}
