import java.util.Random;

public class BullsAndCows {

}

class Bulls {
    private final int first;
    private final int second;
    private final int third;

    Bulls() {
        this.first = new Random().nextInt(9) + 1;
        this.second = new Random().nextInt(9) + 1;
        this.third = new Random().nextInt(9) + 1;
    }

    Bulls(int first, int second, int third) {
        this.first = first;
        this.second = second;
        this.third = third;

    }

    public boolean isStrike(int index, int inputNumber) {
        if (index == 0 && first == inputNumber) {
            return true;
        }
        if (index == 1 && second == inputNumber) {
            return true;
        }
        return index == 2 && third == inputNumber;
    }

    public boolean isBall(int inputNumber) {
        return first == inputNumber || second == inputNumber || third == inputNumber;
    }
}