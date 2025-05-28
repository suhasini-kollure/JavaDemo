package miscellaneous;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ThreeMaxMinNums {
    public static void main(String[] args) {
        List<Integer> listOfIntegers = Arrays.asList(45, 12, 56, 15, 24, 75, 31, 89);

        System.out.println("Three MIN numbers from list : " +
                listOfIntegers.stream().sorted().limit(3).toList());

        System.out.println("Three MAX numbers from list : " +
                listOfIntegers.stream().sorted(Comparator.reverseOrder()).limit(3).toList());

    }
}
