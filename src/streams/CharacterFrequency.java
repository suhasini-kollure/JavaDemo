package streams;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CharacterFrequency {
    public static void main(String[] args) {
        String word = "success";

        Map<Character, Long> collect = word.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println("Character frequency : " +collect);

        String collect1 = collect.entrySet()
                .stream()
                .filter(entry -> entry.getValue() == 1)
                .map(entry -> String.valueOf(entry.getKey()))
                .collect(Collectors.joining());
        System.out.println("Non repeated char : " + collect1);

        Character mostFrequent = collect.entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .get();
        System.out.println("Most frequent character: " + mostFrequent);
    }
}
