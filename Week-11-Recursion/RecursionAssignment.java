

public class ResursionAssignment {

    public static void main(String[] args) {
    
        // Q1 : Given an integer, find out the sum of its digits using recursion.
        int num = 128;
        System.out.println("The sum is: " + sumOfDigits(num));

        /*
        Q.2 - Given a number n. Find the sum of natural numbers till n but with alternate signs.
        That means if n = 5 then you have to return 1-2+3-4+5 = 3 as your answer.
        Constraints : 0<=n<=1e6
        */

        int n = 5;

        boolean isMinus = false;
        int sum = 0;
        for(int i = 1; i<=n; i++) {
            isMinus = !isMinus;
            if(isMinus) {
                sum += i;
            } else {
                sum -= i;
            }
        }
        System.out.println("The sum with alternate operators of n is: " + sum);

        /*
        Q.3 - Print the max value of the array [ 13, 1, -3, 22, 5].
        */
        int[] arr = {13,1,-3,22,5};

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] > max) {
                max = arr[i];
            }
        }
        System.out.println("Maximum number in this array is: " + max);

        

    }

    public static int sumOfDigits(int num) {
        int sum = 0;
        if(num == 0) {
            return 0;
        } 
        int result = num%10 + sumOfDigits(num/10);
        return result;


    }

}



