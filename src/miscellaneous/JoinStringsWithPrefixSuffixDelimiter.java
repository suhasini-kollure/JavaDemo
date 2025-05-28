package miscellaneous;

// join the strings with ‘[‘ as prefix, ‘]’ as suffix and ‘,’ as delimiter

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class JoinStringsWithPrefixSuffixDelimiter {
    public static void main(String[] args) {
        List<String> listOfStrings = Arrays.asList("Facebook", "Twitter", "YouTube", "WhatsApp", "LinkedIn");
        System.out.println(listOfStrings);
        System.out.println(listOfStrings.stream().collect(Collectors.joining("| ", "{", "}")));
        System.out.println(listOfStrings.stream().collect(Collectors.joining(", ")));


    }
}
