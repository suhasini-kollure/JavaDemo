package streams;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupByFirstLetter {
    public static void main(String[] args) {

        List<String> list = Arrays.asList("Apple", "Ball", "Car", "Cat", "Cow", "Ant");

        Map<Character, List<String>> collect = list.stream().collect(Collectors.groupingBy(word -> word.charAt(0)));
        System.out.println(collect);



    }
}
