package miscellaneous;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortListInReverseOrder {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6);

        //Using Streams
        list.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);

        // Sorting in reverse order using Collections
        list.sort(Collections.reverseOrder());
        System.out.println("Sorted List in Reverse Order: " + list);

        int[] nums = {1, 2, 3, 4, 5, 6};
        List<Integer> list1 = Arrays.stream(nums).boxed().sorted((a, b) -> b - a).toList();
        System.out.println(list1);




    }
}
