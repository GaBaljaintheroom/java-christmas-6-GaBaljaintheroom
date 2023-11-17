package christmas.domain.menu;


import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("이름 객체에 대해")
class NameTest {

    @Test
    @DisplayName("이름 값을 저장할 수 있다.")
    void Given_CreateName_When_GetName_Then_EqualExpect() {
        //given
        Name name = Name.from("제로콜라");

        //when
        String actual = name.getMenuName();

        //then
        assertThat(actual).isEqualTo("제로콜라");
    }
}
