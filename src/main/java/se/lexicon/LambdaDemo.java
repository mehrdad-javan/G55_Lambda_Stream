package se.lexicon;

import java.util.ArrayList;
import java.util.List;

public class LambdaDemo {
    /*static DoStringStuff getBiggestString = (str1, str2) -> {
           if (str1.length() >= str2.length()) {
               return str1;
           } else {
               return str2;
           }
       };*/

    static DoStringStuff concatenate = (str1, str2) -> str1 + " " + str2;
    static DoStringStuff getBiggestString = (str1, str2) -> str1.length() >= str2.length() ? str1 : str2;

    static DoubleOperator addition = (n1, n2) -> n1 + n2;
    static DoubleOperator subtraction = (n1, n2) -> n1 - n2;
    static DoubleOperator multiplication = (n1, n2) -> n1 * n2;

    public static double calcOperator(double n1, double n2, DoubleOperator doubleOperator) {
        return doubleOperator.apply(n1, n2);
    }

    public static String doStringStuff(String input1, String input2, DoStringStuff logic) {
        return logic.operate(input1, input2);
    }

    public static ArrayList<Todo> filterTasks(ArrayList<Todo> todoArrayList, TaskFilter filter) {
        ArrayList<Todo> result = new ArrayList<>();
        for (Todo todo : todoArrayList) {
            if (filter.matches(todo)) {
                result.add(todo);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(doStringStuff("Mehrdad", "Javan", concatenate));
        System.out.println(doStringStuff("Mehrdad", "Javan", getBiggestString));

        System.out.println(calcOperator(2.0, 2.0, addition));
        System.out.println(calcOperator(2.0, 2.0, subtraction));
        System.out.println(calcOperator(2.0, 2.0, multiplication));

        System.out.println("-------------------");

        ArrayList<Todo> inMemoryStorage = new ArrayList<>();
        // Adding tasks to the list
        inMemoryStorage.add(new Todo("Buy groceries", false, 2));
        inMemoryStorage.add(new Todo("Finish assignment", true, 1));
        inMemoryStorage.add(new Todo("Call mom", false, 3));
        inMemoryStorage.add(new Todo("Go to the gym", true, 2));
        inMemoryStorage.add(new Todo("Read a book", false, 1));


        // Completed Tasks
        TaskFilter completedFilter = (todo) -> todo.isCompleted();
        System.out.println("Completed Tasks = " + filterTasks(inMemoryStorage, completedFilter));
        // Incomplete Tasks
        //TaskFilter incompleteFilter = (todo) -> !todo.isCompleted();
        System.out.println("Incomplete Tasks = " + filterTasks(inMemoryStorage, (todo) -> !todo.isCompleted()));

        // High Priority Tasks (priority = 1)
        System.out.println("High Priority Tasks = " + filterTasks(inMemoryStorage, (todo) -> todo.getPriority() == 1));

        // High Priority Tasks & Incomplete Tasks
        System.out.println("High Priority Tasks = " + filterTasks(inMemoryStorage, (todo) -> todo.getPriority() == 1 && !todo.isCompleted()));



    }
}