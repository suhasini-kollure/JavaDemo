package miscellaneous;

import java.util.Arrays;

public class SumAndAverageStream {
    public static void main(String[] args) {
        int[] a = {45, 12, 56, 15, 24, 75, 31, 89};

        System.out.println("Average : " + Arrays.stream(a).average().getAsDouble());
        System.out.println("Average : " + Arrays.stream(a).average().orElse(0.0));
        System.out.println("Sum : " + Arrays.stream(a).sum());
    }
}
