
// Q3.Write a program to show run time polymorphism in java?

class Animal {
    // private String name;

    // public Animal(String name) {
    //     this.name = name;
    // }

    public void makeSound() {
        System.out.println("Animal makes a sound");
    }
}


class Dog extends Animal {

    @Override
    public void makeSound() {
        System.out.println("Dog Barks!");
    }

}

class Cat extends Animal {

    @Override
    public void makeSound() {
        System.out.println("A cat meows");
    }
    
}





public class Question3 {

    public static void main(String[] args) {
        
        Animal a1 = new Animal();
        a1.makeSound();
        Animal d1 = new Dog();
        d1.makeSound();

        d1 = new Cat();
        d1.makeSound();
    }
    
}
