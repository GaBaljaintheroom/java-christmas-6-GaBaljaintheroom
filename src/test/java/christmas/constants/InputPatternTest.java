package christmas.constants;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("입력 패턴 상수에 대해 ")
class InputPatternTest {

    @Test
    @DisplayName("숫자 패턴이 아니라면 true를 반환한다.")
    void When_IsNotNumeric_Then_ReturnTrue() {
        //when
        boolean actual = InputPattern.isNotNumeric("박준수");

        //then
        assertTrue(actual);
    }

    @Test
    @DisplayName("숫자 패턴이 맞으면 false를 반환한다.")
    void When_IsNumeric_Then_ReturnFalse() {
        //when
        boolean actual = InputPattern.isNotNumeric("123");

        //then
        assertFalse(actual);
    }

    @Test
    @DisplayName("주문 패턴이 아니라면 true를 반환한다.")
    void When_IsNotOrderPattern_Then_ReturnTrue() {
        //when
        boolean actual = InputPattern.isNotOrderPattern("시저샐러드/0");

        //then
        assertTrue(actual);
    }

    @Test
    @DisplayName("주문 패턴이 맞으면 false를 반환한다.")
    void When_IsOrderPattern_Then_ReturnFalse() {
        //when
        boolean actual = InputPattern.isNotOrderPattern("시저샐러드-1");

        //then
        assertFalse(actual);

    }
}
