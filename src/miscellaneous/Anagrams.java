package miscellaneous;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Anagrams {
    public static void main(String[] args) {
        String s1 = "RaceCar";
        String s2 = "CarRace";

        // 1
        s1 = Stream.of(s1.split("")).map(String::toUpperCase).sorted().collect(Collectors.joining());
        s2 = Stream.of(s2.split("")).map(String::toUpperCase).sorted().collect(Collectors.joining());

        if (s1.length() == s2.length() && s1.equals(s2)) {
            System.out.println("Two strings are anagrams");
        } else {
            System.out.println("Two strings are not anagrams");
        }

        // 2
        if (s1.length() == s2.length() &&
                Stream.of(s1.toLowerCase().split(""))
                        .sorted()
                        .collect(Collectors.joining())
                        .equals(Stream.of(s2.toLowerCase().split(""))
                                .sorted()
                                .collect(Collectors.joining()))) {
            System.out.println("Two strings are anagrams");
        } else {
            System.out.println("Two strings are not anagrams");
        }


        //3
        if (s1.length() != s2.length()) {
            System.out.println("Not anagrams");
        } else {
            char[] arr1 = s1.toLowerCase().toCharArray();
            char[] arr2 = s2.toLowerCase().toCharArray();
            Arrays.sort(arr1);
            Arrays.sort(arr2);
            System.out.println(Arrays.equals(arr1, arr2) ? "Anagrams" : "Not anagrams");
        }
    }
}
