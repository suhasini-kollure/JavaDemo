package streams;

import java.util.Arrays;
import java.util.List;

public class SumEvenNumbers {
    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(1, 2, 5, 6, 3, 5);

        int sum = list.stream().filter(x -> x % 2 == 0).mapToInt(Integer::intValue).sum();
        System.out.println("sum of even numbers : " + sum);

        int sum1 = list.stream().filter(x -> x % 2 != 0).mapToInt(Integer::intValue).sum();
        System.out.println("sum of odd numbers : " + sum1);
    }
}
