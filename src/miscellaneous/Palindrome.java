package miscellaneous.interviewpractice;

public class Palindrome {

    public static void stringPalindrome(String str) {
        String reversed = "";

        for (int i=str.length()-1 ; i>= 0; i--) {
            reversed += str.charAt(i);
        }

        if (str.equals(reversed)) {
            System.out.println("palindrom");
        } else {
            System.out.println("not palindrome");
        }
    }

    public static boolean numPalindrome(int num) {
        int original = num;
        int reversed = 0;

        while (num > 0) {
            int digit = num % 10;
            reversed = reversed * 10 + digit;
            num = num / 10;
        }
        return original == reversed;
    }

    public static void main(String[] args) {
        stringPalindrome("madam");
        stringPalindrome("ant");
        System.out.println(numPalindrome(123));
        System.out.println(numPalindrome(1221));

    }
}
