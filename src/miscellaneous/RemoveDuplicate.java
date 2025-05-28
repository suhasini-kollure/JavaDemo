package miscellaneous;

import java.util.*;
import java.util.stream.Collectors;

public class RemoveDuplicate {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 4, 4, 5, 6, 5, 5, 7, 7, 6));

        // 1. Using steam
        System.out.println(list.stream().distinct().collect(Collectors.toList()));

        // 2.
        List<Integer> result = new ArrayList<>();
        Set<Integer> uniqueValues = new HashSet<>();
        for (Integer i : list) {
            if (uniqueValues.add(i)) {
                result.add(i);
            }
        }
        System.out.println(result);
    }
}
