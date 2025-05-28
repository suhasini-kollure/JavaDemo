package miscellaneous;

import java.util.IntSummaryStatistics;
import java.util.stream.Stream;

public class SumOfDigits {
    public static void main(String[] args) {
        int i = 15623;

        //1
        IntSummaryStatistics sumOfDigits = Stream.of(String.valueOf(i).split(""))
                .mapToInt(Integer::parseInt).summaryStatistics();
        System.out.println(sumOfDigits.getSum());

        //2
        System.out.println(String.valueOf(i).chars().map(Character::getNumericValue).sum());
    }
}
