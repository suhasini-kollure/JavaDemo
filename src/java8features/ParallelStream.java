package java8features;

import java.util.List;
import java.util.stream.Stream;

public class ParallelStream {
    public static void main(String[] args) {
        // A type of stream that enables parallel processing of elements
        // Allowing multiple threads to process parts of the stream simultaneously
        // This can significantly improve performance for the large data sets
        // workload is distributed across multiple threads

        long startTime = System.currentTimeMillis();
        List<Integer> list = Stream.iterate(1, x -> x + 1).limit(20000).toList();
//        List<Long> list1 = list.stream().map(x -> factorial(x)).toList();
        List<Long> factorialList = list.stream().map(ParallelStream::factorial).toList();
        long endTime = System.currentTimeMillis();
        System.out.println("Time taken with stream : " + (endTime - startTime) + " ms");


        startTime = System.currentTimeMillis();
        factorialList = list.parallelStream().map(ParallelStream::factorial).toList();
        endTime = System.currentTimeMillis();
        System.out.println("Time taken with parallel stream : " + (endTime - startTime) + " ms");


        //Parallel streams when is effective :
        // Parallel streams most effective for CPU-internal or large datasets where tasks are independent
        // they may add overhead for simple tasks or small datasets
    }
    private static long factorial(int n) {
        long result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }
}
