package baseball;

public class PlayResult {
    private int ball = 0;
    private int strike = 0;

    public int getStrike() {
        return this.strike;
    }
    public int getBall(){
        return this.ball;
    }

    public void report(BallStatus play) {
        if (play.isBall()) {
            this.ball += 1;
        }
        if (play.isStrike()) {
            this.strike += 1;
        }
    }

    public boolean isGameEnd() {
        return this.strike == 3;
    }
}
