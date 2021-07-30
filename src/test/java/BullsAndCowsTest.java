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
    void countBallOrStrike(){
        Bulls bulls = new Bulls(1, 2, 4);


    }
}