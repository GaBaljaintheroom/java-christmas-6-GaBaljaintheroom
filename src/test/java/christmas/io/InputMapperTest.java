package christmas.io;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import christmas.domain.VisitDate;
import christmas.domain.menu.Menu;
import christmas.domain.menu.Menus;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("입력 변환 객체에 대해")
class InputMapperTest {

    private final InputMapper inputMapper = new InputMapper();

    @Test
    @DisplayName("방문 날짜 객체로 변환하여 일을 저장한다.")
    void Given_MapperVisitDate_When_GetDayOfMonth_Then_EqualExpect() {
        //given
        VisitDate visitDate = inputMapper.toVisitDate("3");

        //when
        Integer actual = visitDate.getDayOfMonth();

        //then
        assertThat(actual).isEqualTo(3);
    }

    @Test
    @DisplayName("메뉴들 객체로 변환하여 이름과 수량 별로 메뉴를 저장한다. ")
    void Given_MapperMenus_When_GetValues_Then_EqualNamesAndAmount() {
        //given
        Menus menus = inputMapper.toMenus("타파스-1,제로콜라-1");

        //when
        List<Menu> values = menus.getValues();
        String actualName1 = values.get(0).getMenuNameValue();
        Integer actualAmount1 = values.get(0).getMenuAmountValue();
        String actualName2 = values.get(1).getMenuNameValue();
        Integer actualAmount2 = values.get(1).getMenuAmountValue();

        //then
        assertAll(() -> assertThat(actualName1).isEqualTo("타파스"),
                () -> assertThat(actualAmount1).isEqualTo(1),
                () -> assertThat(actualName2).isEqualTo("제로콜라"),
                () -> assertThat(actualAmount2).isEqualTo(1)
        );
    }

}
