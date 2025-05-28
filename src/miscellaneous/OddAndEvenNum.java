package miscellaneous;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class OddAndEvenNum {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(3, 6, 2, 6, 4, 8, 9, 7);
        System.out.println("Even = " + list.stream().filter(x -> x % 2 == 0).collect(Collectors.toList()));
        System.out.println("Odd = " + list.stream().filter(x -> x % 2 != 0).collect(Collectors.toList()));

        System.out.println(list.stream().collect(Collectors.partitioningBy(x -> x % 2 == 0)));

    }
}
