package miscellaneous;

import java.util.Arrays;
import java.util.List;

public class CommonElementsBetweenTwoArrays {
    public static void main(String[] args) {
        //this is for array
        int[] array1 = {71, 21, 34, 89, 56, 28};
        int[] array2 = {12, 56, 17, 21, 94, 34};

        List<Integer> integerList = Arrays.stream(array1)
                .distinct()
                .filter(x -> Arrays.stream(array2).anyMatch(y -> y == x))
                .boxed()
                .toList();
        System.out.println(integerList);


        //this is for List<Integer>
        List<Integer> list1 = Arrays.asList(71, 21, 34, 89, 56, 28);
        List<Integer> list2 = Arrays.asList(12, 56, 17, 21, 94, 34);

        System.out.println("Using lambda : " + list1.stream().filter(x -> list2.contains(x)).toList());
        System.out.println("Method reference : " + list1.stream().filter(list2::contains).toList());



    }
}
