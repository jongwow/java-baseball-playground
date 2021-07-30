import java.util.Random;
import java.util.Scanner;

public class BullsAndCows {
    public void oneRound(){
        Bulls bulls = new Bulls();
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.print("숫자를 입력해주세요: ");
            String s = sc.nextLine();
            String compare = bulls.compare(s);
            System.out.println(bulls.resultView(compare));
            if (compare.equals("SSS")) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                return;
            }
        }
    }
    private boolean oneTurn(){
        return true;
    }
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

    private char compareOne(int index, char input){
        if (isStrike(index, input - '0')) {
            return 'S';
        }
        if (isBall(input - '0')) {
            return 'B';
        }
        return 'N';
    }


    public String compare(String userNumber){
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < userNumber.length(); i++) {
            result.append(compareOne(i, userNumber.charAt(i)));
        }
        return result.toString();
    }

    public String resultView(String result){
        int numOfBall = 0;
        int numOfStrike = 0;
        for (int i = 0; i < result.length(); i++) {
            if(result.charAt(i) == 'S'){
                numOfStrike += 1;
            }
            if(result.charAt(i) == 'B'){
                numOfBall += 1;
            }
        }
        StringBuilder stringBuilderBall = new StringBuilder();
        StringBuilder stringBuilderStrike = new StringBuilder();
        if(numOfBall > 0){
            stringBuilderBall.append(numOfBall).append("볼");
        }
        if(numOfStrike > 0){
            stringBuilderStrike.append(numOfStrike).append("스트라이크");
        }
        String s1 = stringBuilderBall.toString();
        String s = stringBuilderStrike.toString();
        return s1.concat(s);
    }

}