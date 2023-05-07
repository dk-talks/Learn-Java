

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
        
        /*
         * Q4 : Find the sum of the values of the array [92, 23, 15, -20, 10]
         */

         int[] arr5 = {92, 23, 15, -20, 10};
         int sum1 = 0;
         for (int i : arr5) {
            sum1 += i;
         }
         System.out.println("The sum of array is: " + sum1);


         /*
          *Q5. Given a number n. Print if it is an armstrong number or not. An armstrong number is a number if the sum
            of every digit in that number raised to the power of total digits in that number is equal to the number.
            Example : 153 = 1^3 + 5^3 + 3^3 = 1 + 125 + 27 = 153 hence 153 is an armstrong number. (Easy) 
          */

          // first find the number of digits in number
          int n1 = 153;
          String str = Integer.toString(n1);
          int numLen = str.length();
          int sum2 = 0;
          int n1ToCompare = n1;
          while (n1>0) {
            int temp = n1%10;
            sum2 += Math.pow(temp, numLen);
            n1 = n1/10;
          }
          System.out.println("sum2 is: " + sum2);
          if(sum2 == n1ToCompare) {
            System.out.println("Yes, it is armstrong number");
          } else {
            System.out.println("No, it is not armstroing number");
          }

        

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



