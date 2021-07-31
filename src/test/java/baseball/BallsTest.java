package baseball;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class BallsTest {
    @Test
    void 세개와_한개_비교_nothing() {
        Balls balls = new Balls(Arrays.asList(1, 2, 3));
        BallStatus status = balls.play(new Ball(1, 4));
        assertThat(status).isEqualTo(BallStatus.NOTHING);
    }


    @Test
    void 세개와_한개_비교_ball() {
        Balls balls = new Balls(Arrays.asList(1, 2, 3));
        BallStatus status = balls.play(new Ball(1, 3));
        assertThat(status).isEqualTo(BallStatus.BALL);
    }


    @Test
    void 세개와_한개_비교_strike() {
        Balls balls = new Balls(Arrays.asList(1, 2, 3));
        BallStatus status = balls.play(new Ball(1, 1));
        assertThat(status).isEqualTo(BallStatus.STRIKE);
    }


    @Test
    void 세개와_세개_비교_nothing() {
        Balls answers = new Balls(Arrays.asList(1, 2, 3));
        Balls balls = new Balls(Arrays.asList(4,5,6));
        PlayResult result = answers.play(balls);
        assertThat(result.getStrike()).isEqualTo(0);
        assertThat(result.getBall()).isEqualTo(0);
    }

    @Test
    void 세개와_세개_비교_1ball() {
        Balls answers = new Balls(Arrays.asList(1, 2, 3));
        Balls balls = new Balls(Arrays.asList(4,1,6));
        PlayResult result = answers.play(balls);
        assertThat(result.getStrike()).isEqualTo(0);
        assertThat(result.getBall()).isEqualTo(1);
    }

    @Test
    void 세개와_세개_비교_1strike() {
        Balls answers = new Balls(Arrays.asList(1, 2, 3));
        Balls balls = new Balls(Arrays.asList(4,5,3));
        PlayResult result = answers.play(balls);
        assertThat(result.getStrike()).isEqualTo(1);
        assertThat(result.getBall()).isEqualTo(0);
    }


    @Test
    void 세개와_세개_비교_1ball_1strike() {
        Balls answers = new Balls(Arrays.asList(1, 2, 3));
        Balls balls = new Balls(Arrays.asList(1, 3, 5));
        PlayResult result = answers.play(balls);
        assertThat(result.getStrike()).isEqualTo(1);
        assertThat(result.getBall()).isEqualTo(1);
    }


    @Test
    void 세개와_세개_비교_3strike() {
        Balls answers = new Balls(Arrays.asList(1, 2, 3));
        Balls balls = new Balls(Arrays.asList(1,2,3));
        PlayResult result = answers.play(balls);
        assertThat(result.getStrike()).isEqualTo(3);
        assertThat(result.getBall()).isEqualTo(0);
        assertThat(result.isGameEnd()).isTrue();
    }
}
