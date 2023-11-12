package christmas.domain;

import christmas.constants.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.*;

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
    @DisplayName("크리스마스 디데이 할인을 적용시킨다.")
    void Given_CreateVisitDate_When_ChristmasDDayDiscount_Then_EqualActual() {
        //given
        VisitDate visitDate = VisitDate.from(3);

        //when
        Integer actual = visitDate.christmasDDayDiscount(TotalOrderPrice.from(10_000));

        //then
        assertThat(actual).isEqualTo(1_200);
    }

    @Test
    @DisplayName("25일 이후는 크리스마스 디데이 할인을 적용시키지 못한다.")
    void Given_CreateVisitDateOver25_When_ChristmasDDayDiscount_Then_NotApply() {
        //given
        VisitDate visitDate = VisitDate.from(30);

        //when
        Integer actual = visitDate.christmasDDayDiscount(TotalOrderPrice.from(10_000));

        //then
        assertThat(actual).isZero();
    }
}
