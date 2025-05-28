package collections;

import java.util.*;
import java.util.stream.Collectors;

public class ListDemo {

    public static void main(String[] args) {

        //Mutable list - new ArrayList<>(Arrays.asList())
        List<String> list = new ArrayList<>(Arrays.asList("A", "C", "B", "A"));

        //Sorting
        Collections.sort(list);
        System.out.println(list);

        //remove duplicates from a List
        Set<String> set = new HashSet<>(list);
        list = new ArrayList<>(set);
        System.out.println(list);

        //Immutable list - Arrays.asList()
        // sort a list in descending order
        List<String> list1 = Arrays.asList("A", "C", "B", "A");
        list1.sort(Collections.reverseOrder());
        System.out.println(list1);

        List<Integer> list2 = Arrays.asList(5, 6, 4, 2, 8);
        list2.sort(Collections.reverseOrder());
        System.out.println(list2);

        //count the frequency of elements in a list using Map
        List<String> list3 = new ArrayList<>(Arrays.asList("A", "B", "A", "C", "D", "C", "C"));
        Map<String, Integer> map = new HashMap<>();

        for (String s : list3) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        System.out.println(map);


        //Find the maximum and minimum in a list.
        List<Integer> numbers = Arrays.asList(10, 20, 5, 8, 30);
        int max = Collections.max(numbers);
        int min = Collections.min(numbers);
        System.out.println("max : " + max + ", min : " + min);

//        Convert a List to a Map (name -> length)
        List<String> names = Arrays.asList("John", "Alex", "Emily");
        Map<String, Integer> collect = names.stream().collect(Collectors.toMap(name -> name, String::length));
        System.out.println(collect);


    }
}
