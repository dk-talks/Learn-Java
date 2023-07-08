/*
Yes, lambda expressions can be passed as arguments to methods. This capability is particularly useful when working with functional interfaces, as lambda expressions can provide a concise way to 
implement the abstract method defined in the functional interface.

You can pass a lambda expression as an argument to a method when:

The method parameter expects a functional interface: If a method has a parameter of a functional interface type, you can pass a lambda expression that matches the signature of the abstract method
in that interface. The lambda expression will be used as the implementation of the abstract method.

The method performs operations on functional interfaces: If a method performs operations such as filtering, mapping, or reducing on collections, it may accept a lambda expression as an argument 
to define the behavior for those operations. The lambda expression specifies the criteria or transformation to be applied to the elements of the collection.

Here's an example to illustrate passing lambda expressions to methods:
*/

import java.util.Arrays;
import java.util.List;

interface Condition {
    boolean test(int number);
}

class NumberFilter {
    static List<Integer> filterNumbers(List<Integer> numbers, Condition condition) {
        List<Integer> filteredNumbers = new ArrayList<>();
        for (int number : numbers) {
            if (condition.test(number)) {
                filteredNumbers.add(number);
            }
        }
        return filteredNumbers;
    }
}

public class Question7 {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // Passing a lambda expression as an argument
        List<Integer> evenNumbers = NumberFilter.filterNumbers(numbers, (number) -> number % 2 == 0);
        System.out.println("Even numbers: " + evenNumbers);

        List<Integer> oddNumbers = NumberFilter.filterNumbers(numbers, (number) -> number % 2 != 0);
        System.out.println("Odd numbers: " + oddNumbers);
    }
}
