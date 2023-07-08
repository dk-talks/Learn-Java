
// Main class
public class Question2 {
    public static void main(String[] args) {
        Animal dog = new Dog();
        dog.eat();
        dog.sleep();
        dog.makeSound();
        dog.move();

        Animal cat = new Cat();
        cat.eat();
        cat.sleep();
        cat.makeSound();
        cat.move();
    }
}

// Abstract class
abstract class Animal {
    // Concrete method
    public void eat() {
        System.out.println("Animal is eating.");
    }

    // Concrete method
    public void sleep() {
        System.out.println("Animal is sleeping.");
    }

    // Abstract methods
    public abstract void makeSound();
    public abstract void move();
}

// Concrete subclass
class Dog extends Animal {
    // Implementing abstract methods
    public void makeSound() {
        System.out.println("Dog is barking.");
    }

    public void move() {
        System.out.println("Dog is running.");
    }
}

// Concrete subclass
class Cat extends Animal {
    // Implementing abstract methods
    public void makeSound() {
        System.out.println("Cat is meowing.");
    }

    public void move() {
        System.out.println("Cat is jumping.");
    }
}


