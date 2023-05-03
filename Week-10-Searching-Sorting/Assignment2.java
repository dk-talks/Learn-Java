import java.util.ArrayList;

public class NumberSystem {

    public static void main(String[] args) {
        
        // que 1- Given a number, print its binary representation..
        
        int num = 176; // replace with your desired number
        StringBuilder binary = new StringBuilder();
        
        // convert to binary
        while (num > 0) {
            int remainder = num % 2;
            binary.append(remainder);
            num = num / 2;
        }
        
        // reverse the binary string and print
        System.out.print("The binary representation of " + num + " is: ");
        System.out.println(binary.reverse().toString());


        // Que. 2 - given a number ‘n’, predict whether it is a power of two or not.

        int n = 65;
        boolean isPowerOfTwo = true;
        
        // check if n is a power of two
        if (n <= 0) {
            isPowerOfTwo = false;
        } else {
            while (n > 1) {
                if (n % 2 != 0) {
                    isPowerOfTwo = false;
                    break;
                }
                n = n / 2;
            }
        }
        
        // print the result
        if (isPowerOfTwo) {
            System.out.println(n + " is a power of two");
        } else {
            System.out.println(n + " is not a power of two");
        }

        // Que. 3 - Given a number. Using bit manipulation, check whether it is odd or even.

        int n2 = 79; // replace with your desired number
        
        // check if n is odd or even using bit manipulation
        if ((n & 1) == 0) {
            System.out.println(n + " is even");
        } else {
            System.out.println(n + " is odd");
        }

        // Que. 4 - Given a number, count the number of set bits in that number without using an extra space.
        //Note : bit ‘1’ is also known as set bit.

        int n3 = 12; // replace with your desired number
        
        // count the number of set bits in n
        int count = 0;
        while (n != 0) {
            count += n & 1;
            n = n >>> 1; // use logical right shift to shift in zeroes
        }
        
        // print the result
        System.out.println("The number of set bits in " + n + " is " + count);


        /* Que. 5 - Given an integer array, duplicates are present in it in a way that all duplicates appear an even
            number of times except one which appears an odd number of times. Find that odd appearing
            element in linear time and without using any extra memory.
       */


      int[] arr = {2, 3, 4, 3, 4, 2, 4}; // replace with your integer array
        
      // find the odd appearing element
      int result = arr[0];
      for (int i = 1; i < arr.length; i++) {
          result = result ^ arr[i];
          System.out.println("result at " + arr[i] + " is " + result);
      }
      
      // print the result
      System.out.println("The odd appearing element is " + result);

    }
    
}
