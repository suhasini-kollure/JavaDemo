package miscellaneous;

public class ArmstrongNumber {

    public static boolean checkNum(int num) {

        int original = num;
        int result = 0;

        int digits = String.valueOf(num).length();

        while (num > 0) {
            int digit = num % 10;
            result += (int) Math.pow(digit, digits);
            num = num / 10;
        }
        return original == result;
    }

    public static void main(String[] args) {
        System.out.println(checkNum(153));
        System.out.println(checkNum(178));

    }
}
