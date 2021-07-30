package baseball;

public class ValidationUtils {
    private static final int MAX_NO = 10;
    private static final int MIN_NO = 0;

    public static boolean validNumber(int no) {
        return no > MIN_NO && no < MAX_NO;
    }
}
