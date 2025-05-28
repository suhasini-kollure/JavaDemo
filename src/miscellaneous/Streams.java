package miscellaneous;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Streams {
    public static void main(String[] args) {

        List<String> list = Arrays.asList("Apple", "Ball", "Cat", "Ant");
        list.stream().filter(i -> i.startsWith("A")).forEach(System.out::println);

        List<String> list1 = list.stream().map(String::toUpperCase).toList();
        System.out.println(list1);

        List<String> list2 = list.stream().sorted(Comparator.naturalOrder()).toList();
        System.out.println(list2);

        System.out.println(list.stream().filter(x -> x.startsWith("A")).distinct().count());

        List<Integer> list3 = Stream.iterate(1, x -> x + 1).limit(15).toList();
        System.out.println(list3);

        List<Integer> list4 = Stream.iterate(1, x -> x + 1).limit(20).skip(10).toList();
        System.out.println(list4);

        List<List<String>> listsOfLists = Arrays.asList(
                Arrays.asList("apple", "banana"),
                Arrays.asList("orange", "kiwi"),
                Arrays.asList("pear", "grape")
        );

        List<String> list5 = listsOfLists.stream().flatMap(Collection::stream).toList();
        System.out.println(list5);

        List<Integer> nums = Arrays.asList(2,4,9,5,7,7);
        Optional<Integer> optionalInteger = nums.stream().reduce(Integer::sum);
        System.out.println(optionalInteger.get());

        System.out.println(nums.stream().filter(x -> x % 2 == 0).count());
        System.out.println(nums.stream().filter(x -> x % 2 != 0).findFirst().get());

        System.out.println(nums.stream().anyMatch(x -> x % 2 == 0));

        System.out.println(nums.stream().collect(Collectors.partitioningBy(x -> x % 2 == 0)));

        System.out.println(nums.stream().max(Comparator.naturalOrder()).get());
        System.out.println(nums.stream().min(Comparator.naturalOrder()).get());

        System.out.println("length > 3 : " + list.stream().filter(x -> x.length() > 3).toList());
        System.out.println("Squaring and sorting : " + nums.stream().map(x -> x * x).sorted().toList());

        String str = "hello";
        System.out.println("Counting Occurrences of a Character : " + str.chars().filter(x -> x == 'l').count());

        Set<Integer> collect = nums.stream().collect(Collectors.toSet());
        System.out.println("remove duplicates : " + collect);

        String collect1 = list.stream().collect(Collectors.joining(", "));
        System.out.println("Concatenates stream elements : " + collect1);

        Map<Integer, List<String>> collect2 = list.stream().collect(Collectors.groupingBy(String::length));
        System.out.println(collect2);
        Map<Integer, String> collect4 = list.stream().collect(Collectors.groupingBy(String::length, Collectors.joining(",")));
        System.out.println(collect4);

        Map<Integer, Long> collect3 = list.stream().collect(Collectors.groupingBy(String::length, Collectors.counting()));
        System.out.println(collect3);
        TreeMap<Integer, Long> treeMap = list.stream().collect(Collectors.groupingBy(String::length, TreeMap::new, Collectors.counting()));
        System.out.println(treeMap);



    }
}
