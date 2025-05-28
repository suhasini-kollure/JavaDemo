package miscellaneous;

import java.util.function.Function;
import java.util.stream.Collectors;

public class FrequencyOfCharInString {
    public static void main(String[] args) {
        String name = "Hello";

        // Convert a String to a Stream of Characters
        System.out.println(name.chars()                 // Returns an IntStream of char codes, For "Hello": [72, 101, 108, 108, 111] (Unicode values)
                .mapToObj(c -> (char) c)            // Convert int to char (object type)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting())));

    }
}
