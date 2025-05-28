package streams;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamsOnIntegers {
    public static void main(String[] args) {


        List<Integer> numbers = Arrays.asList(3, 7, 4, 9, 2, 6, 2, 3, 8);

//        Find the number that appears more than once
        HashSet<Integer> seen = new HashSet<>();
        List<Integer> duplicates = numbers.stream().filter(x -> (!seen.add(x))).toList();
        System.out.println("number that appears more than once : " + duplicates);

//        Find the product of all numbers using reduce.
        Integer i = numbers.stream().reduce((a, b) -> a * b).get();
        System.out.println("product of all numbers using reduce : " + i);


//        Group numbers by even and odd, and count each group.
        Map<String, Long> evenOddCount = numbers.stream().collect(Collectors.groupingBy(n -> (n % 2 == 0) ? "Even" : "Odd", Collectors.counting()));
        System.out.println(evenOddCount);


//        Sum of squares of only odd numbers.
        int sum1 = numbers.stream()
                .filter(x -> x % 2 != 0)
                .map(y -> y * y)
                .mapToInt(Integer::intValue)
                .sum();
        System.out.println("Sum of squares of only odd numbers : " + sum1);

//        Check if any number is divisible by 5.
        boolean anyMatch = numbers.stream().anyMatch(x -> x % 5 == 0);
        System.out.println("number is divisible by 5 : " + anyMatch);

//        Check if all numbers are positive.
        boolean b = numbers.stream().allMatch(x -> x > 0);
        System.out.println("all numbers are positive : " + b);

//        Find the frequency of each number in a list.
        Map<Integer, Long> numFrequency = numbers.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println("frequency of each number : " + numFrequency);

//        Find all numbers greater than a given threshold (e.g., 3).
        List<Integer> greaterThan3 = numbers.stream().filter(x -> x > 3).toList();
        System.out.println("numbers greater than : " + greaterThan3);

//      Remove duplicate numbers from the list.
        List<Integer> distinct = numbers.stream().distinct().toList();
        System.out.println("Remove duplicate numbers : " + distinct);

//        Find the sum of all elements in a list of integers.
        int sum = numbers.stream().mapToInt(Integer::intValue).sum();
        System.out.println("sum of all elements in a list : " + sum);

//        Find the maximum number in a list.
        Optional<Integer> max = numbers.stream().reduce(Integer::max);
        System.out.println("maximum number : " + max.get());

//        Find the minimum number in a list.
        OptionalInt min = numbers.stream().mapToInt(Integer::intValue).min();
        System.out.println("minimum number : " + min);

//        Convert a list of integers to their squares.
        List<Integer> squares = numbers.stream().map(x -> x * x).toList();
        System.out.println("integers to their squares : " + squares);

//        Count the even numbers in a list.
        long count = numbers.stream().filter(x -> x % 2 == 0).count();
        System.out.println("Even count : " + count);

//        Separate Odd and Even numbers
        Map<Boolean, List<Integer>> oddEven = numbers.stream().collect(Collectors.partitioningBy(x -> x % 2 == 0));
        System.out.println("Odd and Even numbers : " +oddEven);

//      Finding the second highest number in a list:
        Integer secondHighest = numbers.stream().sorted(Comparator.reverseOrder()).skip(1).findFirst().orElse(null);
        System.out.println("secondHighest : " + secondHighest);

//      Calculating the average of numbers in a  list:
        OptionalDouble average = numbers.stream().mapToInt(Integer::intValue).average();
        System.out.println("average : " + average.getAsDouble());

//      Calculating the average of numbers in a nested list:
        List<List<Integer>> nestedNumbers = Arrays.asList(
                Arrays.asList(1, 2, 3),
                Arrays.asList(4, 5),
                Arrays.asList(6, 7, 8, 9)
        );
        OptionalDouble average1 = nestedNumbers.stream().flatMap(List::stream).mapToInt(Integer::intValue).average();
        System.out.println("average of numbers in a nested list : " + average1.getAsDouble());


    }
}
