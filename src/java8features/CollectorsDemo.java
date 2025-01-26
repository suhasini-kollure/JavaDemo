package java8features;

import java.util.*;
import java.util.stream.Collectors;

public class CollectorsDemo {
    public static void main(String[] args) {

        //Collectors is a utility class
        //provides a set of methods to create common collectors

        // 1. Collecting to a List
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
        List<String> res = names.stream()
                .filter(name -> name.startsWith("A"))
                .collect(Collectors.toList());
        System.out.println(res);

        // 2. Collecting to a Set
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 4, 5, 5, 6, 6);
        Set<Integer> set = integers.stream().collect(Collectors.toSet());
        System.out.println(set);

        // 3. Collecting to a specific Collection
        ArrayDeque<String> collect = names.stream().collect(Collectors.toCollection(() -> new ArrayDeque<>()));
        System.out.println(collect);

        // 4. Joining Strings
        // Concatenates stream elements into a single String
        String concatenatedNames = names.stream().map(String::toUpperCase).collect(Collectors.joining(", "));
        System.out.println(concatenatedNames);

        // 5. Summarizing data
        // Generates statistical summary (count, sum, min, average, max)
        List<Integer> numbers = Arrays.asList(2, 3, 6, 8);
        IntSummaryStatistics stas = numbers.stream().collect(Collectors.summarizingInt(x -> x));
        System.out.println("Count : " + stas.getCount());
        System.out.println("Sum : " + stas.getSum());
        System.out.println("min : " + stas.getMin());
        System.out.println("average : " + stas.getAverage());
        System.out.println("max : " + stas.getMax());
        System.out.println("class : " + stas.getClass());

        // 6. Calculating Averages
        Double average = numbers.stream().collect(Collectors.averagingInt(x -> x));
        System.out.println("Average : " + average);


        // 7. Counting elements
        Long count = numbers.stream().collect(Collectors.counting());
        System.out.println("Count : " + count);

        // 8. Grouping elements
        List<String> words = Arrays.asList("hello", "java", "world", "streams", "collecting");
        System.out.println(words.stream().collect(Collectors.groupingBy(String::length)));
        System.out.println(words.stream().collect(Collectors.groupingBy(String::length, Collectors.joining(", "))));
        System.out.println(words.stream().collect(Collectors.groupingBy(String::length, Collectors.counting())));
        TreeMap<Integer, Long> treeMap = words.stream().collect(Collectors.groupingBy(String::length, TreeMap::new, Collectors.counting()));
        System.out.println(treeMap);

        // 9. Partitioning elements
        // Partitions elements into two groups (true and false) based on a predicate
        System.out.println(words.stream().collect(Collectors.partitioningBy(x -> x.length() > 5)));

        //10. Mapping and Collecting
        // Applies a mapping function before collecting
        System.out.println(words.stream().collect(Collectors.mapping(x -> x.toUpperCase(), Collectors.toList())));

        // Example 1 : Collecting Names by Length
        List<String> l1 = Arrays.asList("Anna", "Bob", "Alexander", "Brian", "Alice");
        System.out.println(l1.stream().collect(Collectors.groupingBy(String::length)));

        // Ex 2 : counting word occurrences
        String sentence = "hello world hello java world";
        System.out.println(Arrays.stream(sentence.split(" ")).collect(Collectors.groupingBy(x -> x, Collectors.counting())));

        //Ex 3 : Partitioning Even and Odd Numbers
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        System.out.println(list.stream().collect(Collectors.partitioningBy(x -> x % 2 == 0)));

        //Ex 4 : Summing values in a map
        Map<String, Integer> items = new HashMap<>();
        items.put("Apple", 10);
        items.put("Ball", 56);
        items.put("Orange", 15);
        System.out.println(items.values().stream().reduce(Integer::sum).get());
        System.out.println(items.values().stream().collect(Collectors.summingInt(x -> x)));

        //Ex 5: Creating a Map from Stream Elements
        List<String> fruits = Arrays.asList("Apple", "Banana", "Cherry");
        System.out.println(fruits.stream().collect(Collectors.toMap(x -> x.toUpperCase(), x -> x.length())));

        // Ex 6:
        List<String> words2 = Arrays.asList("Apple", "Banana", "Cherry", "Apple", "Cherry", "Apple");
        System.out.println(words2.stream().collect(Collectors.toMap(k -> k, v -> 1, (x, y) -> x + y)));



    }
}
