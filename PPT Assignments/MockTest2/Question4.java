public class Question4 {

    public static void main(String[] args) {
        
        // while loop experiment

        // Write a Java program to find the largest of three numbers using nested if-else statements.

        int n1 = 5;
        int n2 = 9;
        int n3 = 7;

        if(n1 > n2) {
            if(n1 > n3) {
                System.out.println("largest is n1");
            } else {
                System.out.println("largest is n3");
            }
        } else {
            if(n3 > n2) {
                System.out.println("largest is n3");
            } else {
                System.out.println("largest is n2");
            }
        }

        


    }
    
}
