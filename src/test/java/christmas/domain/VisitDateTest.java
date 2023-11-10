package christmas.domain;

import christmas.constants.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

@DisplayName("방문 날짜 객체에 대해")
class VisitDateTest {

    private static final String errorTage = ErrorMessage.ERROR_TAG.toString();

    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 999})
    @DisplayName("방문 날짜가 날짜 범위가 아닌 경우 에러가 발생한다.")
    void When_ValidateVisitDatePeriod_Then_ThrowException(int value) {
        assertThatThrownBy(() -> new VisitDate(value))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(errorTage);

    }

    @ParameterizedTest
    @ValueSource(ints = {1, 31, 25})
    @DisplayName("정상적으로 방문 날짜를 입력한다.")
    void When_InputCorrect_Then_NotThrowException(int value) {
        assertThatCode(() -> new VisitDate(value))
                .doesNotThrowAnyException();
    }

}
