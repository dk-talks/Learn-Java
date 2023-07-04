public class Question2 {
    public static void main(String[] args) {
        
        int n = 10;
        
        System.out.println("Fibonacci series up to " + n + ":");
        
        int firstNum = 0;
        int secondNum = 1;
        
        System.out.print(firstNum + " " + secondNum + " ");
        
        for (int i = 2; i < n; i++) {
            int nextNum = firstNum + secondNum;
            System.out.print(nextNum + " ");
            
            firstNum = secondNum;
            secondNum = nextNum;
        }
        
    }
}
