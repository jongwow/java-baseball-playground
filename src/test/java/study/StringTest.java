package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class StringTest {
    @Test
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }

    @Test
    void requirements1() {
        // split
        String[] values = "1,2".split(",");
        assertThat(values).contains("1", "2");

        values = "1".split(",");
        assertThat(values).containsExactly("1");
    }

    @Test
    void requirements2() {
        // given
        String input = "(1,2)";

        // when
        String output = input.substring(1, input.length() - 1);

        // then
        assertThat(output).isEqualTo("1,2");
    }

    @Test
    @DisplayName("Error handle하려고")
    void requirements3() {
        // given
        String input = "abc";

        // when
        assertThatExceptionOfType(IndexOutOfBoundsException.class)
                .isThrownBy(() -> {
                    input.charAt(6);
                });
        // then
    }
}
