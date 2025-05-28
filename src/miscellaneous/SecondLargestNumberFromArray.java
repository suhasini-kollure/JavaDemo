package miscellaneous;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class SecondLargestNumberFromArray {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(45, 12, 56, 15, 24, 75, 31, 89);

        System.out.println(numbers.stream().sorted(Comparator.reverseOrder()).toList());

        //1
        Optional<Integer> secondLargest  = numbers.stream()
                .distinct()
                .sorted((a, b) -> b - a)
                .skip(1)
                .findFirst();
        System.out.println(secondLargest.get());

        //2
        System.out.println(numbers.stream().sorted(Comparator.reverseOrder()).skip(1).findFirst().get());

        int[] nums = {45, 12, 56, 15, 24, 75, 31, 89};

        Object[] array = Arrays.stream(nums)
                .boxed()
                .sorted((a, b) -> b - a)
                .skip(1).findFirst().stream().toArray();
        System.out.println(Arrays.toString(array));


    }
}
