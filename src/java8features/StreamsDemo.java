package java8features;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamsDemo {
    public static void main(String[] args) {
        // features introduced in Java 8
        // process collections of data in a functional and declaration manner
        // Simplify Data Processing (reduces if, else loops)
        // Embrace Functional Programming
        // Improve Readability and Maintainability
        // Enable Easy Parallelism (without dealing with multithreading complexity, can achieve parallelism)


        // What is Stream ?
        // a sequence of elements supporting functional and declaration programing

        // How to use Streams?
        // Source, intermediate operations & terminal operation

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        System.out.println(numbers.stream().filter(x -> x % 2 != 0).count());

        // Creating Streams
        // 1. From Collection
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        System.out.println(list.stream().filter(x -> x % 2 != 0).count());

        // 2. From Arrays
        String[] array = {"a", "b", "c", "d"};
        Stream<String> stream = Arrays.stream(array);
        System.out.println(stream.count());

        // 3. Using Stream.of()
        Stream<String> stream1 = Stream.of("a", "b");
        System.out.println(stream1.toList());

        // 4. Infinite streams
        Stream<Integer> generate = Stream.generate(() -> 1);
        List<Integer> list1 = Stream.iterate(1, x -> x + 1).limit(10).collect(Collectors.toList());
        System.out.println(list1);


    }
}
