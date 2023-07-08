
/*
  Lambda expressions were introduced in Java 8 as a concise way to represent anonymous functions. They provide a more compact syntax for writing functional interfaces, which are interfaces with a 
  single abstract method.

  For example - 
*/


interface Shape {
    double calculateArea();
}

class Circle implements Shape {
    public double calculateArea() {
        return 5;
    }
}

public class Question6 {

    public static void main(String[] args) {
        
        Shape s1 = () -> {
            return 5;
        };
        System.out.println(s1.calculateArea());


    }
    
}
