import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class StringCalculatorTest {
    @Test
    void splitString(){
        // given
        StringCalculator calculator = new StringCalculator();
        String input = "2 + 3 * 4 / 2";

        // when
        String[] strings = calculator.splitString(input);

        // then
        assertThat(strings).containsExactly("2", "+", "3", "*", "4", "/", "2");
    }


    @Test
    void main() {
        // given
        StringCalculator calculator = new StringCalculator();
        String input = "2 + 3 * 4 / 2";

        // when
        int result = calculator.process(input);

        // then
        assertThat(result).isEqualTo(10);
    }
}