package baseball;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BallTest {

    @Test
    void nothing() {
        Ball answer = new Ball(1, 2);
        Ball guess = new Ball(1, 4);
        BallStatus status = answer.play(guess);
        assertThat(status).isEqualTo(BallStatus.NOTHING);
    }


    @Test
    void ball() {
        Ball answer = new Ball(1, 2);
        Ball guess = new Ball(2, 2);
        BallStatus status = answer.play(guess);
        assertThat(status).isEqualTo(BallStatus.BALL);
    }


    @Test
    void strike() {
        Ball answer = new Ball(1, 2);
        Ball guess = new Ball(1, 2);
        BallStatus status = answer.play(guess);
        assertThat(status).isEqualTo(BallStatus.STRIKE);
    }
}
