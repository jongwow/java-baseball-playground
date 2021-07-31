package baseball;

import java.util.Objects;

public class Ball {
    private final int position;
    private final int number;

    public Ball(int position, int number) {
        this.position = position;
        this.number = number;
    }

    public BallStatus play(Ball guess) {
        if (this.equals(guess)) {
            return BallStatus.STRIKE;
        }
        if (this.number == guess.number)
            return BallStatus.BALL;
        return BallStatus.NOTHING;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ball ball = (Ball) o;
        return position == ball.position && number == ball.number;
    }
}
