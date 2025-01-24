package Java8Features;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.function.*;
import java.util.stream.Collectors;

public class Java8Demo {
    public static void main(String[] args) {

        //Java 8 --> minimal code, functional programming, lambda expressions, Streams , Date & time APi
        //lambda expression is an anonymous function (no name, no return type, no access modifier)

        Thread t1 = new Thread(() -> {
        System.out.println("Hello");
        });

        MathOperation sumOperation = ( a,  b) -> a + b;
        MathOperation subOperation = (a, b) -> a - b;
        int res = sumOperation.operate(2, 3);
        System.out.println(res);

        //Predicate --> function interface (Boolean valued function)
        Predicate<Integer> predicate = a -> a % 2 == 0;
        System.out.println(predicate.test(6));
        Predicate<String> isWordStartsWithA = x -> x.startsWith("A");
        Predicate<String> isWordEndsWithT = y -> y.endsWith("t");
        Predicate<String> and = isWordStartsWithA.and(isWordEndsWithT);
        System.out.println(and.test("Ankita"));

        //Function --> works for us
        Function<Integer, Integer> doubleIt = x -> x * 2;
        Function<Integer, Integer> tripleIt = y -> y * 3;
        System.out.println(doubleIt.apply(2));
        System.out.println(doubleIt.andThen(tripleIt).apply(20));
        System.out.println(tripleIt.andThen(doubleIt).apply(20)); //same
        System.out.println(doubleIt.compose(tripleIt).apply(20)); //same

        Function<Integer, Integer> identity = Function.identity();
        Integer apply = identity.apply(5);
        System.out.println(apply);

        //Consumer
        Consumer<Integer> print = x -> System.out.println(x);
        print.accept(51);
        List<Integer> list = Arrays.asList(1, 2, 3);
        Consumer<List<Integer>> printList = x -> {
            for (int i : x) {
                System.out.println(i);
            }
        };
        printList.accept(list);


        //Supplier
        Supplier<String> giveHelloWorld = () -> "Hello World";
        System.out.println(giveHelloWorld.get());

        //Combined example
        Predicate<Integer> predicate1 = x -> x % 2 == 0;
        Function<Integer, Integer> function = x -> x * x;
        Consumer<Integer> consumer = x -> System.out.println(x);
        Supplier<Integer> supplier = () -> 100;

        if (predicate1.test(supplier.get())) {
            consumer.accept(function.apply(supplier.get()));
        }

        //BiPredicate, BiConsumer, BiFunction
        BiPredicate<Integer, Integer> isSumEven = (x, y) -> (x + y) % 2 == 0;
        System.out.println(isSumEven.test(5, 5));

        BiConsumer<Integer, String> biConsumer = (x, y) -> {
            System.out.println(x);
            System.out.println(y);
        };

        BiFunction<String, String, Integer> biFunction = (x, y) -> (x + y).length();
        System.out.println(biFunction.apply("a", "bc"));

        //UnaryOperator(Function<Integer, Integer>), BinaryOperator (BiFunction<String, String, Integer>)
        UnaryOperator<Integer> a = x -> 2 * x;
        BinaryOperator<Integer> b = (x, y) -> x + y;

        //Method reference --> use method without invoking & in place of lambda expression
        List<String> students = Arrays.asList("Ram", "Shyam", "GhanaShyam");
        students.forEach(x -> System.out.println(x));
        students.forEach(System.out::println);

        //Constructor reference
        List<String> names = Arrays.asList("A", "B", "C");
        List<MobilePhone> mobilePhoneList = names.stream().map(MobilePhone::new).collect(Collectors.toList());
    }
}

class MobilePhone {
    String name;

    public MobilePhone(String name) {
        this.name = name;
    }
}

interface MathOperation {
    int operate(int a, int b);
}

//class Sum implements MathOperation {
//    @Override
//    public int operate(int a, int b) {
//        return a + b;
//    }
//}

//class Task implements Runnable {
//    @Override
//    public void run() {
//        System.out.println("Hello");
//    }
//}


