package baseball;

import java.util.ArrayList;
import java.util.List;

public class Balls {

    private ArrayList<Ball> balls;

    Balls(List<Integer> ballNumbers) {
        this.balls = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            this.balls.add(new Ball(i + 1, ballNumbers.get(i)));
        }
    }

    public BallStatus play(Ball userBall) {
        return balls.stream()
                .map(ball -> ball.play(userBall))
                .filter(BallStatus::isNotNothing)
                .findFirst()
                .orElse(BallStatus.NOTHING);
    }

    public PlayResult play(Balls guesses) {
        PlayResult result = new PlayResult();
        balls.stream().map(guesses::play).forEach(result::report);
        return result;
    }
}
