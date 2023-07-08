// Functional interface
interface Calculator {
    int calculate(int a, int b);
}

// Main class
public class Question3 {
    public static void main(String[] args) {
        // Using an anonymous class to implement the functional interface
        Calculator addition = new Calculator() {
            @Override
            public int calculate(int a, int b) {
                return a + b;
            }
        };
        System.out.println("Addition: " + addition.calculate(5, 3));

        Calculator subtraction = new Calculator() {
            @Override
            public int calculate(int a, int b) {
                return a - b;
            }
        };
        System.out.println("Subtraction: " + subtraction.calculate(8, 2));

        Calculator multiplication = new Calculator() {
            @Override
            public int calculate(int a, int b) {
                return a * b;
            }
        };
        System.out.println("Multiplication: " + multiplication.calculate(4, 6));
    }
}
