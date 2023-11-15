package christmas.domain.menu;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import christmas.constants.message.ErrorMessage;
import christmas.domain.VisitDate;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("방문 날짜 객체에 대해")
class VisitDateTest {

    private static final String errorTage = ErrorMessage.ERROR_TAG.toString();

    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 999})
    @DisplayName("방문 날짜가 날짜 범위가 아닌 경우 예외가 발생한다.")
    void When_ValidateVisitDatePeriod_Then_ThrowException(int value) {
        assertThatThrownBy(() -> VisitDate.from(value))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(errorTage);

    }

    @ParameterizedTest
    @ValueSource(ints = {1, 31, 25})
    @DisplayName("정상적으로 방문 날짜를 입력한다.")
    void When_InputCorrect_Then_NotThrowException(int value) {
        assertThatCode(() -> VisitDate.from(value))
                .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("방문 날짜의 요일을 구한다.")
    void Given_CreateVisitDate_When_GetDayOfWeek_Then_EqualExpect() {
        VisitDate visitDate = VisitDate.from(3);

        String actual = visitDate.getDayOfWeek();

        assertThat(actual).isEqualTo("일요일");
    }

    @Test
    @DisplayName("방문 날짜의 일을 구한다.")
    void Given_CreateVisitDate_When_GetDayOfMonth_Then_EqualExpect() {
        //given
        VisitDate visitDate = VisitDate.from(3);

        //when
        Integer actual = visitDate.getDayOfMonth();

        //then
        assertThat(actual).isEqualTo(3);

    }
}
