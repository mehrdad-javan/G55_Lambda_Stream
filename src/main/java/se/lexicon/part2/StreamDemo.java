package se.lexicon.part2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StreamDemo {

    static ArrayList<Employee> employees = new ArrayList<>();

    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(2);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);
        numbers.add(6);
        numbers.add(7);
        numbers.add(8);
        numbers.add(9);
        numbers.add(10);

        //Predicate<Integer> evenNumber = n -> n % 2 == 0;
        //Predicate<Integer> numberGreaterThan10 = n -> n > 10;
        //Consumer<Integer> printNumber = n -> System.out.println(n);

        numbers.stream() // converts the collection into a Stream pipeline
                .filter(n -> n % 2 == 0) // intermediate operation
                .filter(n -> n > 6)
                .forEach(n -> System.out.println(n)); // terminal operation

        List<Integer> distinctNumbers = numbers.stream()
                .distinct() // intermediate operation
                .toList(); // terminal operation

        System.out.println(distinctNumbers);


        System.out.println("---------------------");
        employees.addAll(Arrays.asList(
                new Employee("Alice", "Engineering", 30, 60000),
                new Employee("Bob", "Engineering", 35, 70000),
                new Employee("Charlie", "HR", 28, 50000),
                new Employee("David", "HR", 40, 45000),
                new Employee("Eve", "Finance", 32, 65000),
                new Employee("Frank", "Finance", 25, 55000),
                new Employee("Grace", "Engineering", 45, 80000)
        ));

        // To find employees in the "Engineering" department earning more than 60k
        // step 1 : create stream
        // step 2 : use intermediate operation to create a new filtered stream
        // step 3 : use terminal operation to create a result
        List<Employee> list = employees.stream()
                .filter((employee) -> employee.getDepartment().equals("Engineering"))
                .filter(e -> e.getSalary() > 60000)
                .toList();

        list.forEach(employee -> System.out.println(employee));


        // Find employee names sorted by salary
        List<String> names = employees.stream()
                .sorted(Comparator.comparingDouble(employee -> employee.getSalary()))
                .map(employee -> employee.getName())
                .toList();

        names.forEach(name -> System.out.println(name));
        //names.forEach(System.out::println); // method reference

    }

}
