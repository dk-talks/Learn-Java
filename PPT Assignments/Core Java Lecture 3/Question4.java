public class Question4 {
    public void display() {
        System.out.println("Display method without arguments");
    }
    
    public void display(int num) {
        System.out.println("Display method with an integer argument: " + num);
    }
    
    public void display(String message) {
        System.out.println("Display method with a string argument: " + message);
    }
    
    public void display(double num1, double num2) {
        System.out.println("Display method with two double arguments: " + num1 + ", " + num2);
    }
    
    public static void main(String[] args) {
        CompileTimePolymorphism obj = new CompileTimePolymorphism();
        
        obj.display();                   // Invokes display() without arguments
        obj.display(10);                 // Invokes display(int num)
        obj.display("Hello");            // Invokes display(String message)
        obj.display(3.14, 2.5);          // Invokes display(double num1, double num2)
    }
}
