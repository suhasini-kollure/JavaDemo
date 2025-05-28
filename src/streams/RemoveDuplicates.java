package streams;

import java.util.stream.Collectors;

public class RemoveDuplicates {
    public static void main(String[] args) {
        String str = "programming";

        String collect = str.chars().distinct().mapToObj(c -> String.valueOf((char) c)).collect(Collectors.joining());
        System.out.println(collect);

    }
}
