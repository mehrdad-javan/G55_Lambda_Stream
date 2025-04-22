package se.lexicon;

import java.util.Random;
import java.util.function.*;

public class UtilFunctionDemo {

    static Predicate<Integer> isEven = num -> num % 2 == 0;
    static Predicate<Integer> isPositive = num -> num > 0;

    public static void main(String[] args) {
        // Integer apply(String t);
        Function<String, Integer> stringToLength = str -> str.length();
        System.out.println(stringToLength.apply("Hello Java!")); // 11
        Function<Double, Double> fahrenheitToCelsius = f -> (f - 32) * 5 / 9;
        System.out.println(fahrenheitToCelsius.apply(100.0)); // 37.7778

        UnaryOperator<Double> fahrenheitToCelsius2 = f -> (f - 32) * 5 / 9;
        System.out.println(fahrenheitToCelsius2.apply(100.0));

        // Predicate<>
        Predicate<Integer> isEven = num -> num % 2 == 0;
        System.out.println(isEven.test(2)); // true
        Predicate<Integer> isPositive = num -> num > 0;

        Predicate<Integer> isGreaterThan100 = num -> num > 100;
        System.out.println(isGreaterThan100.test(500)); // true
        System.out.println(isGreaterThan100.test(50)); // false

        System.out.println(isPositive.and(isEven));
        //Predicate<Integer> isPositiveAndEven = num -> (num % 2 == 0) && (num > 0);
        Predicate<Integer> isPositiveAndEven = isPositive.and(isEven);

        Consumer<Todo> printSummary = task -> System.out.println("Title: " + task.getTitle() + " | " + task.isCompleted());
        printSummary.accept(new Todo("Task Name", true, 2));

        Supplier<Integer> generateNumber = () -> new Random().nextInt(100);
        System.out.println(generateNumber.get());

    }

}
