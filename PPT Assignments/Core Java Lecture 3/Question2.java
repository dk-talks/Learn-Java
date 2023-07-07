// ParentClass.java
public class ParentClass {
    public void printMessage() {
        System.out.println("This is the parent class.");
    }
}

// ChildClass.java (Inherits from ParentClass)
public class ChildClass extends ParentClass {
    @Override
    public void printMessage() {
        System.out.println("This is the child class.");
    }
}

// Question2.java
public class Question2 {
    public static void main(String[] args) {
        ParentClass parent = new ParentClass();
        parent.printMessage();  // Output: This is the parent class.

        ChildClass child = new ChildClass();
        child.printMessage();  // Output: This is the child class.

        ParentClass childAsParent = new ChildClass();
        childAsParent.printMessage();  // Output: This is the child class.
    }
}
