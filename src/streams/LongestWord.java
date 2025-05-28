package streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Optional;

public class LongestWord {
    public static void main(String[] args) {

        String sentence = "Java Streams provide functional programming features";

        Optional<String> max = Arrays.stream(sentence.split(" "))
                .max(Comparator.comparing(String::length));

        System.out.println(max.get());
    }
}
