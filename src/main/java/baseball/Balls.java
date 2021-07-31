package baseball;

import java.util.ArrayList;
import java.util.List;

public class Balls implements Playable{
    private List<Ball> answers;

    public Balls(List<Integer> ballsNo) {
        this.answers = mapBall(ballsNo);
    }

    private static List<Ball> mapBall(List<Integer> answers) {
        List<Ball> balls = new ArrayList<>();
        for (int i = 0; i < answers.size(); i++) {
            balls.add(new Ball(i + 1, answers.get(i)));
        }
        return balls;
    }

    public BallStatus play(Ball ball) {
        return this.answers
                .stream()
                .map(answer -> answer.play(ball))
                .filter(BallStatus::isNotNothing)
                .findFirst()
                .orElse(BallStatus.NOTHING);
    }

    public PlayResult play(Balls userBalls) {
        PlayResult result = new PlayResult();
        for (Ball answer : answers) {
            BallStatus ballStatus = userBalls.play(answer);
            result.report(ballStatus);
        }
        return result;
    }
}
