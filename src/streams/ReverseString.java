package streams;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ReverseString {
    public static void main(String[] args) {
        String str = "hello";

        String collect = IntStream.range(0, str.length())
                .map(i -> str.length() - 1 - i)
                .mapToObj(str::charAt)
                .map(String::valueOf)
                .collect(Collectors.joining());
        System.out.println(collect);

    }

}
