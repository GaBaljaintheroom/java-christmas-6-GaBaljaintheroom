package christmas.validator;

import christmas.constants.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

@DisplayName("입력 검증 객체에 대해")
class InputValidatorTest {

    private static final String errorTage = ErrorMessage.ERROR_TAG.toString();
    private final InputValidator inputValidator = new InputValidator();

    @ParameterizedTest
    @ValueSource(strings = {"pobi", "###", "-10"})
    @DisplayName("0 이상 숫자를 입력하지 않았을 경우 에러가 발생한다.")
    void When_ValidateNumericDate_Then_ThrowException(String visitDate) {
        assertThatThrownBy(() -> inputValidator.validateNumericDate(visitDate))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(errorTage);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "11", "111"})
    @DisplayName("정상적으로 숫자를 입력한다.")
    void When_InputCorrect_Then_NotThrowException(String visitDate) {
        assertThatCode(() -> inputValidator.validateNumericDate(visitDate))
                .doesNotThrowAnyException();
    }
}
