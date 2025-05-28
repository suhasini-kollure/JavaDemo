package streams;

import java.util.Arrays;

public class AnagramCheck {

    public static boolean areAnagrams(String s1, String s2) {
        return Arrays.equals(s1.chars().sorted().toArray(), s2.chars().sorted().toArray());
    }

    public static void main(String[] args) {
        System.out.println(areAnagrams("listen", "silent"));
        System.out.println(areAnagrams("hello", "world"));
    }
}
