package java8features;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

public class IntermediateOps {
    public static void main(String[] args) {

        //Intermediate operations transform a stream into another program
        //They are lazy, meaning they don't execute until a terminal operation is invoked

        // 1. filter
        List<String> list = Arrays.asList("Apple", "Ball", "Cat", "Ant");
        //No filtering at this point, means no operations is performed without terminal op
        Stream<String> filteredStream = list.stream().filter(x -> x.startsWith("A"));
        filteredStream.forEach(System.out::println);
        long res = list.stream().filter(x -> x.startsWith("A")).count();
        System.out.println(res);

        // 2. map
//        Stream<String> stringStream = list.stream().map(x -> x.toUpperCase());
        Stream<String> stringStream = list.stream().map(String::toUpperCase);

        // 3. sorted
        Stream<String> sortedStream = list.stream().sorted();
        list.stream().sorted((a, b) -> a.length() - b.length());

        // 4. distinct
        System.out.println(list.stream().filter(x -> x.startsWith("A")).distinct().count());

        // 5. limit
        System.out.println(Stream.iterate(1, x -> x + 1).limit(50).count());

        // 6. skip
        System.out.println(Stream.iterate(1, x -> x + 1).skip(10).limit(100).count());

        // 7. peek -> In IO this works same as forEach from TO.
        // Performs an action on each element as it is consumed
//        Stream.iterate(1, x -> x + 1).skip(10).limit(50).peek(x -> System.out.println(x)).count();
        Stream.iterate(1, x -> x + 1).skip(10).limit(50).peek(System.out::println).count();

        // 8. flatMap
        // Handle streams of collections, lists or arrays where each element is itself a collection.
        // Flatten nested structure (ex : lists within lists) so that they can be processes as a single sequence of elements
        // Transform and flatten elements at the same time
        List<List<String>> listsOfLists = Arrays.asList(
                Arrays.asList("apple", "banana"),
                Arrays.asList("orange", "kiwi"),
                Arrays.asList("pear", "grape")
        );

        System.out.println(listsOfLists.get(1).get(1));
        System.out.println(listsOfLists.stream().flatMap(x -> x.stream()).map(String::toUpperCase).toList());
        System.out.println(listsOfLists.stream().flatMap(Collection::stream).map(String::toUpperCase).toList());

        List<String> sentences = Arrays.asList(
                "Hello world",
                "Java streams are powerful",
                "flatmap is useful"
        );

        System.out.println(sentences
                .stream()
                .flatMap(sentence -> Arrays.stream(sentence.split(" ")))
                .map(String::toUpperCase)
                .toList()
        );











    }
}
