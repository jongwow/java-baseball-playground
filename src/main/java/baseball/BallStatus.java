package baseball;

public enum BallStatus {
    BALL, STRIKE, NOTHING;

    public boolean isBall() {
        return this == BallStatus.BALL;
    }
    public  boolean isStrike(){
        return this == BallStatus.STRIKE;
    }
    public boolean isNotNothing(){
        return this != BallStatus.NOTHING;
    }
}
