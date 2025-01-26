package java8features;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TerminalOps {
    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);

        // 1. collect
        list.stream().skip(1).collect(Collectors.toList());
        list.stream().skip(1).toList();

//        list.stream().skip(1).collect(Collectors.toSet());

        // 2. forEach
        list.stream().forEach(x -> System.out.println(x));
        list.forEach(System.out::println);

        // 3. reduce : combines elements to produce a single result
//        Optional<Integer> optionalInteger = list.stream().reduce((x, y) -> x + y);
        Optional<Integer> optionalInteger = list.stream().reduce(Integer::sum);
        System.out.println(optionalInteger.get());

        // 4. count
        System.out.println(list.stream().filter(x -> x % 2 != 0).count());

        //5. anyMatch, allMatch, noneMatch
        boolean b = list.stream().anyMatch(x -> x % 2 == 0);
        System.out.println(b);
        boolean b1 = list.stream().allMatch(x -> x > 0);
        System.out.println(b1);
        boolean b2 = list.stream().noneMatch(x -> x < 0);
        System.out.println(b2);
        System.out.println(list.stream().noneMatch(x -> x < 0));

        // 6. findFirst, findAny
        System.out.println(list.stream().findFirst().get());
        System.out.println(list.stream().findAny().get());

        // 7. toArray
        Object[] array = Stream.of(1, 2, 3).toArray();

        // 8. min / max
        List<Integer> list1 = Arrays.asList(1, 5, 3, 8);
        System.out.println("max : " + list1.stream().max((o1, o2) -> o1 - o2).get());
        System.out.println("max : " + Stream.of(6, 70, 84).max(Comparator.naturalOrder()).get());

        System.out.println("min : " + Stream.of(6, 70, 84).min(Comparator.naturalOrder()).get());

        // 9. forEachOrdered
        List<Integer> list2 = Arrays.asList(1, 2, 3, 4, 5, 6);
        System.out.println("Using forEach with parallel stream:");
        list2.parallelStream().forEach(System.out::println);
        System.out.println("Using forEachOrdered with parallel stream");
        list2.parallelStream().forEachOrdered(System.out::println); //working parallel and order is also maintained


        //Examples : filtering and collecting names
        List<String> names = Arrays.asList("Anna", "Bob", "Charlie", "David");
        System.out.println(names.stream().filter(x -> x.length() > 3).toList());

        //Ex : Squaring and sorting
        List<Integer> nums = Arrays.asList(5, 2, 8);
        System.out.println(nums.stream().map(x -> x * x).sorted().toList());

        // Ex : Summing values -> if we want one  value in return then use reduce
        List<Integer> n = Arrays.asList(1, 2, 3, 5);
        System.out.println(n.stream().reduce(Integer::sum).get());

        // Ex : Counting Occurrences of a Character
        String sentence = "Hello World";
        System.out.println(sentence.chars().filter(x -> x == 'l').count());

        // Ex :
        // Streams cannot be reused after the terminal operation has been called
        Stream<String> stream = names.stream();
        stream.forEach(System.out::println);
//        List<String> list2 = stream.map(String::toUpperCase).toList(); //exception


    }
}
