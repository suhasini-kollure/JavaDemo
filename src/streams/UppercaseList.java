package streams;

import java.util.Arrays;
import java.util.List;

public class UppercaseList {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("Apple", "Banana", "Cerry");

        List<String> list = words.stream().map(String::toUpperCase).toList();
        System.out.println(list);

        List<String> list1 = words.stream().map(String::toLowerCase).toList();
        System.out.println(list1);


        String[] words1 = {"Apple", "Banana", "Cerry"};
        List<String> list2 = Arrays.stream(words1).map(String::toUpperCase).toList();
        System.out.println(list2);
    }
}
