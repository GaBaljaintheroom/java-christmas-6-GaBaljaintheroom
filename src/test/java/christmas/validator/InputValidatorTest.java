package christmas.validator;

import christmas.constants.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

@DisplayName("입력 검증 객체에 대해")
class InputValidatorTest {

    private static final String errorTage = ErrorMessage.ERROR_TAG.toString();
    private final InputValidator inputValidator = new InputValidator();

    @ParameterizedTest
    @ValueSource(strings = {"pobi", "###", "-10"})
    @DisplayName("0 이상 숫자를 입력하지 않았을 경우 예외가 발생한다.")
    void When_NotValidVisitDate_Then_ThrowException(String visitDate) {
        assertThatThrownBy(() -> inputValidator.validateNumericDate(visitDate))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(errorTage);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "11", "111"})
    @DisplayName("정상적으로 숫자를 입력한다.")
    void When_ValidVisitDate_Then_NotThrowException(String visitDate) {
        assertThatCode(() -> inputValidator.validateNumericDate(visitDate))
                .doesNotThrowAnyException();
    }

    @ParameterizedTest
    @MethodSource("invalidOrderSources")
    @DisplayName("주문 형식을 옳지 않게 입력하였을 경우 예외가 발생한다.")
    void When_NotValidOrder_Then_ThrowException(String order) {
        assertThatThrownBy(() -> inputValidator.validateOrderPattern(order))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(errorTage);
    }

    @ParameterizedTest
    @MethodSource("validOrderSources")
    @DisplayName("정상적으로 주문을 한다.")
    void When_ValidOrder_Then_NotThrowException(String order) {
        assertThatCode(() -> inputValidator.validateOrderPattern(order))
                .doesNotThrowAnyException();
    }

    static Stream<String> invalidOrderSources() {
        return Stream.of("해산물파스타/2,레드와인-1,초코케이크/1", "해산물파스타-0,레드와인-1,초코케이크-0", "해산물파스타-0");
    }

    static Stream<String> validOrderSources() {
        return Stream.of("해산물파스타-2,레드와인-1,초코케이크-1", "해산물파스타-55,레드와인-1", "해산물파스타-999");
    }
}
