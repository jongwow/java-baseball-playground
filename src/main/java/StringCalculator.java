import java.util.Scanner;

public class StringCalculator {
    public void main(){
        String s = inputString();
        int result = process(s);
        System.out.println(result);
    }

    public int process(String s) {
        String[] values = splitString(s);

        int result = toInt(values[0]);
        for (int i = 1; i < values.length - 1; i++) {
            if (values[i].equals("+")) {
                result += toInt(values[i + 1]);
            }
            if (values[i].equals("-")) {
                result -= toInt(values[i + 1]);
            }
            if (values[i].equals("*")) {
                result *= toInt(values[i + 1]);
            }
            if (values[i].equals("/")) {
                result /= toInt(values[i + 1]);
            }
        }
        return result;
    }

    public String inputString() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public String[] splitString(String str) {
        return str.split(" ");
    }

    public int toInt(String str) {
        return Integer.parseInt(str);
    }

}
