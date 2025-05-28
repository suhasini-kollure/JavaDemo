package miscellaneous;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PrintMultipleOf5 {
    public static void main(String[] args) {
        List<Integer> listOfIntegers = Arrays.asList(45, 12, 56, 15, 24, 75, 31, 89);

        //1
        System.out.println(listOfIntegers.stream().filter(x -> x % 5 == 0).collect(Collectors.toList()));

        //2
        listOfIntegers.stream().filter(x -> x % 5 == 0).collect(Collectors.toList()).forEach(System.out::println);
    }
}
