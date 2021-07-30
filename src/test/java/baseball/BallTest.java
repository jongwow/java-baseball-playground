package baseball;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BallTest {
    private Ball com;

    @BeforeEach
    void setup(){
        com = new Ball(1, 4);
    }
    @Test
    void nothing(){
        Ball user = new Ball(1, 3);
        assertThat(com.play(user)).isEqualTo(BallStatus.NOTHING);
    }

    @Test
    void ball(){
        Ball user = new Ball(2, 4);
        assertThat(com.play(user)).isEqualTo(BallStatus.BALL);
    }

    @Test
    void strike(){
        Ball user = new Ball(1, 4);
        assertThat(com.play(user)).isEqualTo(BallStatus.STRIKE);
    }
}
