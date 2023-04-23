
public class Array1D {
    
    public static void main(String[] args) {
        
        //Que.1 - Write a program to print the sum of all the elements present on even indices in the given array.
        int[] arr1 = {4,3,6,7,1};
        int sum = 0;
        for(int i = 0; i<arr1.length;i++) {
            // checking if ith index is even 
            if(i%2 == 0) {
                sum += arr1[i];
            }
        }
        System.out.println("The sum of all even indexes is: " + sum);


        // Que. 2 - Write a program to traverse over the elements of the array using for each loop and print all even elements.
        int[] arr2 = {34,21,54,65,43};
        for(int num: arr2) {
            if(num%2 == 0) {
                System.out.print(num + " ");
            }
        }
        System.out.println();
        // Que. 3 - Write a program to calculate the maximum element in the array.
        int[] arr3 = {34,21,54,65,43};
        int max = 0;
        for(int i = 0; i<arr3.length; i++) {
            if(arr3[i] > max) {
                max = arr3[i];
            }
        }
        System.out.println("Maximum number in array is: " + max);

        // Que. 4 - Write a program to find out the second largest element in a given array.
        int[] arr4 = {34,21,54,65,43};
        // first sorting the array in descending order 
        for(int i = 0; i<arr4.length; i++) {
            for(int j = i; j<arr4.length;j++) {
                //taking two pointers i & j and comparing their values
                //and swapping values
                if(arr4[j]>arr4[i]) {

                    int temp = arr4[i];
                    arr4[i] = arr4[j];
                    arr4[j] = temp;

                }
            }
        }
        System.out.println("Second largest element is: " + arr4[1]);

        // Que. 5 - Given an array. Find the first peak element in the array. A peak element is an element that is greater than
        //its just left and just right neighbor.

        int[] arr5 = {1,3,2,6,5};
        // asuming array must contain a peak element
        for(int i = 0; i<arr5.length-2;i++) {
            if(arr5[i]<arr5[i+1]) {
                //means - next element is greater than current element
                if(arr5[i+1]>arr5[i+2]) {
                    //that means arr5[i+1] is the peak element
                    System.out.println("Peak element is: " + arr5[i+1]);
                    break;
                }
            }
        }

        
    }

}
