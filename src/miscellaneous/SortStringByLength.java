package miscellaneous;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class SortStringByLength {
    public static void main(String[] args) {
        List<String> listOfStrings = Arrays.asList("Java", "Python", "C#", "HTML", "Kotlin", "C++", "COBOL", "C");

        //1
        System.out.println(listOfStrings.stream().sorted((a, b) -> a.length() - b.length()).toList());
        System.out.println(listOfStrings.stream().sorted(Comparator.comparingInt(String::length)).toList());

        //2
        listOfStrings.sort((s1, s2) -> Integer.compare(s1.length(), s2.length()));
        System.out.println(listOfStrings);

        //3
        listOfStrings.stream().sorted(Comparator.comparing(String::length)).forEach(System.out::println);
    }
}
