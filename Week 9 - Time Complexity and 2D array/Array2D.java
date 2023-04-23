import java.util.*;
public class Array2D {

    public static void main(String[] args) {
        
        /* 
        Que. 1 - 

        Q1: Take m and n input from the user and m * n integer inputs from user and print the following:
            number of positive numbers
            number of negative numbers
            number of odd numbers
            number of even numbers
            number of 0.

        */

        int[][] arr1 = new int[4][4];

        Scanner sc = new Scanner(System.in);
        int positiveIntegers = 0;
        int negativeIntegers = 0;
        int oddNumbers = 0;
        int evenNumbers = 0;
        int zeroes = 0;

        for(int i = 0; i<arr1.length;i++) {
            for(int j = 0; j<arr1[i].length; j++) {
                System.out.print("Enter first row: ");
                arr1[i][j] = sc.nextInt();
                if(arr1[i][j] < 0) {
                    negativeIntegers += 1;
                } else if(arr1[i][j]>0) {
                    positiveIntegers += 1;
                } else {
                    zeroes += 1;
                }

                if(arr1[i][j] %2 == 0) {
                    evenNumbers += 1;
                } else {
                    oddNumbers += 1;
                }
            }
            System.out.println();
        }
        
        sc.close();

        System.out.println("Number of Positive intergers: " + positiveIntegers);
        System.out.println("Number of Negative intergers: " + negativeIntegers);
        System.out.println("Number of Zeroes: " + zeroes);
        System.out.println("Number of Even intergers: " + evenNumbers);
        System.out.println("Number of Odd intergers: " + oddNumbers);




        /*
        
        Q2: write a program to print the elements above the secondary diagonal in a user inputted
            square matrix.

         */

        int[][] array2D = {
            { 1,  2,   3,  4,  5 },
            { 6,  7,   8,  9, 10 },
            { 11, 12, 13, 14, 15 },
            { 16, 17, 18, 19, 20 },
            { 21, 22, 23, 24, 25 }
        };
        //looping from first ement to second last elements
        // these are above the secondary diagonal
        for(int i = 0; i<array2D.length-1; i++) {
            // as i's value increase, we decrease the number of elements inculde in columns
            for(int j = 0; j<array2D.length-i-1;j++) {
                // thse elements are above the secondary diagonal
                System.out.print(array2D[i][j] + " ");
            }
        }

        /*
         Q3: write a program to print the elements of both the diagonals in a user inputted square matrix
            in any order.
         */


        int[][] array4 = {
            { 1,  2,   3,  4,  5 },
            { 6,  7,   8,  9, 10 },
            { 11, 12, 13, 14, 15 },
            { 16, 17, 18, 19, 20 },
            { 21, 22, 23, 24, 25 }
        };

        // primary diagonal elements
        for(int i = 0; i<array4.length; i++) {
            for(int j = 0; j<array4.length;j++) {
                // primary diagonal
                if(i == j) {
                    System.out.print(array4[i][j] + " ");
                } else if(i+j == array4.length-1) {
                    // secondary diagonal
                    System.out.print(array4[i][j] + " ");
                }

            }
        }

        /*
         Que. 4 - Write a program to find the largest element of a given 2D array of integers.
         */

        int[][] arr5 = {
            { 1,  2,   3,  4,  5 },
            { 6,  7,   8,  9, 10 },
            { 11, 12, 13, 14, 30 },
            { 16, 17, 4, 19, 20 },
            { 21, 16, 23, 24}
        };

        int max = 0;
        for(int i = 0; i<arr5.length; i++) {
            for(int j = 0; j<arr5[i].length; j++) {
                if(arr5[i][j] > max) {
                    max = arr5[i][j];
                }
            }
        }
        System.out.println("The largest element of this 2D array is: " + max);


        /*
         Q5: Write a function which accepts a 2D array of integers and its size as arguments and
            displays the elements of middle row and the elements of middle column. Printing can
            be done in any order.
            [Assuming the 2D Array to be a square matrix with odd dimensions i.e. 3x3, 5x5, 7x7 etc...]
         */

        int[][] array5 = {
            { 1,  2,   3,  4,  5 },
            { 6,  7,   8,  9, 10 },
            { 11, 12, 13, 14, 15 },
            { 16, 17, 18, 19, 20 },
            { 21, 22, 23, 24, 25 }
        };

        printMiddleElements(array5, 5);

        // method is declared below
        



    }

    public static void printMiddleElements(int[][] array5, int size) {

        for(int i = 0; i<array5.length; i++) {
            for(int j = 0; j<array5[i].length; j++) {
                if(array5[i][j] == array5[array5.length/2][array5.length/2]) {
                    System.out.print(array5[i][j] + " ");
                } else  if(j == array5.length/2) {
                    System.out.print(array5[i][j] + " ");
                    
                } else if(i == array5.length/2) {
                    System.out.print(array5[i][j] + " ");
                }
            }
        }

    }


    
}
