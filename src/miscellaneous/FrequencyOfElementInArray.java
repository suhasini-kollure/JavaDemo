package miscellaneous;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FrequencyOfElementInArray {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>(Arrays.asList("hello", "hello", "world", "apple", "cat", "cat", "cat"));
        System.out.println(list.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting())));

        List<Integer> list1 = Arrays.asList(1, 2, 3, 4, 4, 5, 5, 5, 6);
        System.out.println(list1.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting())));



    }
}
