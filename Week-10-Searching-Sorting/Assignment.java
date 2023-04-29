import java.util.*;

public class SearchingQuestions {

    public static void main(String[] args) {
        
        

        /*
        Q1. Given an array. FInd the number X in the array. If the element is present, return the index of the element,
            else print “Element not found in array”. Input the size of array, array from user and the element X from user.
            Use Linear Search to find the element.
        */

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements you want to add: ");
        int len = sc.nextInt();
        int[] arr1 = new int[len];

        System.out.print("Enter the numbers of the array: ");
        for(int i = 0; i<len; i++) {
            arr1[i] = sc.nextInt();
        }

        System.out.print("Your array is: [");
        for(int n: arr1) {
            System.out.print(n + ", ");
        }
        System.out.print("]");
        System.out.println();

        // now applying the linear Search algorithm

        System.out.print("Enter the number you want to search for: ");
        int target = sc.nextInt();

        boolean isElementFound = false;
        for(int i = 0; i<len; i++) {
            if(arr1[i] == target) {
                System.out.println("Element is found at index number: " + i);
                isElementFound = true;
                break;
            }
        }

        if(!isElementFound) {
            System.out.println("Element is not found");
        }

        /* 
        Q2. Given an array and an integer “target”, return the last occurrence of “target” in the array. If the target is
           not present return -1.
        */

        int[] arr2 = {1, 1, 1, 2, 3, 4, 4, 5, 6, 6, 6, 6};
        int target2 = 0;
        boolean isElementFound1 = false;
        // as we can see, array is sorted, we can apply binary search here

        int start = 0;
        int end = arr2.length - 1;

        while(start<= end) {
            int mid = start + (end-start)/2;
            if(arr2[mid] == target2) {
                if(arr2[mid+1] == target2) {
                    start = mid+1;
                } else {
                    System.out.println("Last occurenct of target " + target2 + " is index: " + mid);
                    isElementFound1 = true;
                    break;
                }
            } else if(arr2[mid] < target2) {
                start = mid+1;
            } else {
                end = mid-1;
            }
        }
        // Time Complexity would be O(log n)
        if(!isElementFound1) {
            System.out.println("Target element is not present in the array");
        }


        /*
         Q3. Given a sorted binary array, efficiently count the total number of 1’s in it.
         */

        int[] arr3 = {0,0,0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1};

        // // as we can see, array is sorted, applying binary search

        int start1 = 0;
        int end1 = arr3.length - 1;

        while(start1<=end1) {
            int mid = start1 + (end1 - start1)/2;
            if(arr3[mid] == 1) {
                if(arr3[mid-1] == 1) {
                    end1 = mid-1;
                } else {
                    System.out.println("Number of 1's in this array are: " + (arr3.length - mid));
                    break;
                }
            } else {
                start1 = mid+1;
            }

        }

        /*
        Que. 4 - Given a sorted integer array containing duplicates, count occurrences of a given number. If the element
        is not found in the array, report that as well.
         */

        
        int[] arr4 = {1,2,6,6,6,10,13,13,267};

        int target3 = 3;

        //sorted array - binary sarch for efficiency

        int start2 = 0;
        int end2 = arr4.length-1;

        int leftMost = 0;
        int rightMost = 0;

        // for left most occurence index
        boolean isElementFound2 = false;
        while(start2<=end2) {
            int mid = start2 + (end2-start2)/2;
            if(arr4[mid] == target3) {
                if(arr4[mid-1] == target3) {
                    end2 = mid-1;
                } else {
                    leftMost = mid;
                    isElementFound2 = true;
                    // break;
                }
            } else if(arr4[mid] < target3) {
                start2 = mid+1;
            } else {
                end2 = mid-1;
            }
        }
        if(!isElementFound2) {
            System.out.println("Target is not found in the array! ");
        } else {
            start2 = 0;
            end2 = arr4.length-1;

            while(start2<=end2) {
                int mid = start2 + (end2-start2)/2;
                if(arr4[mid] == target3) {
                    if(arr4[mid+1] == target3) {
                        start2 = mid+1;
                    } else {
                        rightMost = mid;
                        break;
                    }
                } else if(arr4[mid] < target3) {
                    start2 = mid+1;
                } else {
                    end2 = mid-1;
                }
            }
            System.out.println("Target is present " + (rightMost-leftMost+1) + " times.");
        }

        /*
        Q5: Given a positive integer num, return true if num is a perfect square or false otherwise.
            A perfect square is an integer that is the square of an integer. In other words, 
            it is the product of some integer with itself.
         */

         int num1 = 3;

         int start3 = 1;
         int end3 = num1;
        
         boolean isPerfectSquare = false;
         while(start3<=end3) {
            int mid = start3 + (end3-start3)/2;
            
            long currentSquare = mid*mid;

            if(currentSquare<num1) {
                start3 = mid+1;
            } else if (currentSquare>num1) {
                end3 = mid-1;
            } else {
                System.out.println("Yes, it is perfect square ");
                isPerfectSquare = true;
                break;
            }
         }
         if(!isPerfectSquare) {
            System.out.println("No, num1 is not a perfect squre");
         }



    }
    
}
