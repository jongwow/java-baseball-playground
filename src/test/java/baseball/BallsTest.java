package baseball;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class BallsTest {

    @Test
    void 여러개_한개_낫씽() {
        Balls answers = new Balls(Arrays.asList(1, 2, 3));
        BallStatus status = answers.play(new Ball(1, 4));
        assertThat(status).isEqualTo(BallStatus.NOTHING);
    }


    @Test
    void 여러개_한개_BALL() {
        Balls answers = new Balls(Arrays.asList(1, 2, 3));
        BallStatus status = answers.play(new Ball(2, 3));
        assertThat(status).isEqualTo(BallStatus.BALL);
    }


    @Test
    void 여러개_한개_STRIKE() {
        Balls answers = new Balls(Arrays.asList(1, 2, 3));
        BallStatus status = answers.play(new Ball(1, 1));
        assertThat(status).isEqualTo(BallStatus.STRIKE);
    }

    @Test
    void 여러개_여러개_NOTHING(){
        Balls answers = new Balls(Arrays.asList(1, 2, 3));
        Balls guess = new Balls(Arrays.asList(4, 5, 6));
        PlayResult result = answers.play(guess);
        assertThat(result.getStrike()).isEqualTo(0);
        assertThat(result.getBall()).isEqualTo(0);
    }

    @Test
    void 여러개_여러개_1BALL(){
        Balls answers = new Balls(Arrays.asList(1, 2, 3));
        Balls guess = new Balls(Arrays.asList(4, 1, 6));
        PlayResult result = answers.play(guess);
        assertThat(result.getStrike()).isEqualTo(0);
        assertThat(result.getBall()).isEqualTo(1);
    }

    @Test
    void 여러개_여러개_2BALL(){
        Balls answers = new Balls(Arrays.asList(1, 2, 3));
        Balls guess = new Balls(Arrays.asList(3, 1, 6));
        PlayResult result = answers.play(guess);
        assertThat(result.getStrike()).isEqualTo(0);
        assertThat(result.getBall()).isEqualTo(2);
    }

    @Test
    void 여러개_여러개_1STRIKE(){
        Balls answers = new Balls(Arrays.asList(1, 2, 3));
        Balls guess = new Balls(Arrays.asList(1,4,5));
        PlayResult result = answers.play(guess);
        assertThat(result.getStrike()).isEqualTo(1);
        assertThat(result.getBall()).isEqualTo(0);
    }
    @Test
    void 여러개_여러개_1STRIKE_1BALL(){
        Balls answers = new Balls(Arrays.asList(1, 2, 3));
        Balls guess = new Balls(Arrays.asList(2,6,3));
        PlayResult result = answers.play(guess);
        assertThat(result.getStrike()).isEqualTo(1);
        assertThat(result.getBall()).isEqualTo(1);
    }

    @Test
    void 여러개_여러개_3STRIKE(){
        Balls answers = new Balls(Arrays.asList(1, 2, 3));
        Balls guess = new Balls(Arrays.asList(1,2,3));
        PlayResult result = answers.play(guess);
        assertThat(result.getStrike()).isEqualTo(3);
        assertThat(result.getBall()).isEqualTo(0);
        assertThat(result.isGameEnd()).isTrue();
    }

}
