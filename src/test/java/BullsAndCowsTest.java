import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class BullsAndCowsTest {

    @Test
    void isBallOrStrike(){
        Bulls bulls = new Bulls(1, 2, 4);

        assertThat(bulls.isStrike(0, 1)).isTrue();
        assertThat(bulls.isStrike(0, 2)).isFalse();
        assertThat(bulls.isStrike(1, 2)).isTrue();
        assertThat(bulls.isBall(1)).isTrue();
        assertThat(bulls.isBall(2)).isTrue();
        assertThat(bulls.isBall(4)).isTrue();
    }

    @Test
    void compare(){
        Bulls bulls = new Bulls(7,1,3);

        String compare1 = bulls.compare("123");
        String compare2 = bulls.compare("145");
        String compare3 = bulls.compare("671");
        String compare4 = bulls.compare("216");
        String compare5 = bulls.compare("713");

        assertThat(compare1).isEqualTo("BNS");
        assertThat(compare2).isEqualTo("BNN");
        assertThat(compare3).isEqualTo("NBB");
        assertThat(compare4).isEqualTo("NSN");
        assertThat(compare5).isEqualTo("SSS");
    }

}