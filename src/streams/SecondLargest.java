package streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class SecondLargest {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(10, 20, 4, 45, 99, 99);

        Optional<Integer> first = list.stream()
                .sorted(Comparator.reverseOrder())
                .distinct()
                .skip(1)
                .findFirst();
        System.out.println("Second Largest : " + first.get());


        Optional<Integer> first1 = list.stream()
                .sorted(Comparator.naturalOrder())
                .distinct()
                .skip(1)
                .findFirst();
        System.out.println("Second Smallest : " + first1.get());
    }
}
