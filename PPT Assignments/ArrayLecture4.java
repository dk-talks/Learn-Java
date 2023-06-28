import java.lang.reflect.Array;
import java.util.*;

public class ArrayLecture4 {

    public static void main(String[] args) {
        
        // Que - 1 - Given three integer arrays arr1, arr2 and arr3 sorted in strictly increasing order, 
        //          return a sorted array of only the integers that appeared in all three arrays.

        int[] arr1 = {1,2,3,4,5};
        int arr2[] = {1,2,5,7,9};
        int arr3[] = {1,3,4,5,8,2};

        List<Integer> semiResult = new ArrayList<>();

        // using brute force approach
        for(int i = 0; i<arr1.length; i++) {
            for(int j = 0; j<arr2.length; j++) {
                if(arr1[i] == arr2[j]) {
                    semiResult.add(arr1[i]);
                }
            }
        }
        // now result contains those integers which are availabe in arr1 and ar2
        List<Integer> result = new ArrayList<>();

        for(int n: semiResult) {
            for(int i = 0; i<arr3.length; i++) {
                if(n == arr3[i]) {
                    // this element is present in all three arrays
                    result.add(n);
                }
            }
        }

        System.out.print("Elements present in all three arrays are: ");
        for(int n: result) {
            System.out.print(n + ", ");
        }
        System.out.println();


        /*-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x
        Que 2 - 2215. Find the Difference of Two Arrays
         */

         int num21[] = {1,2,3};
         int num22[] = {2,4,6};

         List<List<Integer>> result2 = new ArrayList<>();

         result2 = findDifference(num21, num22);
         
         //. printing result2 
         for(List<Integer> list: result2) {
            for(int n: list) {
                System.out.print(n + " ");
            }
            System.out.println("Difference of two Arrays");
         }

         
        /*-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x

        Que - 3 - 867. Transpose a Matrix
         */

         int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};

         int[][] transposedMatrix = transpose(matrix);

         // printing transposedMatrix
         for(int[] m: transposedMatrix){
            for(int n: m) {
                System.out.print(n + " ");
            }
            System.out.println();
         }


         /*-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x

        Que - 4 - 561. Array Partition
         */
        int nums4[]  = {1,4,3,2};
        int maximizedSum = arrayPairSum(nums4);
        System.out.println("Maximized sum of pair of small nubmer is: " + maximizedSum);


        /*-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x

        Que - 5 - 441. Arranging Coins
         */
        int n = 21; // find the completed steps in n number of coins 
        
        int rows = arrangeCoins(n);
        System.out.println("Using n coins: " + rows + " can be formed");


        
        /*-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x

        Que - 6 - 977. Squares of a Sorted Array
            Given an integer array nums sorted in non-decreasing order, return an array of the squares of each 
            number sorted in non-decreasing order.
         */

         int[] nums6 = {-4,-1,0,3,10};
         int[] squareNums6 = sortedSquare(nums6);

         // printing the sotred squared array
         for(int n6: squareNums6) {
            System.out.print(n6 + ", ");
         }
         System.out.println();


        
        /*-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x

        Que - 7 - 598. Range Addition II
         */

        int m7 = 3, n7 = 3;
        int[][] ops = {{2,2}, {3,3}};

        int maxInteger = maxCount(m7, n7, ops);
        System.out.println("Count of maximum integer is: " + maxInteger);


        /*-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x

        Que - 8 - 1470. Shuffle the Array - given nums and n, shuffle the array such that {1,2,3,4}, n=2 would become {1,3,2,4}
         */

        int[] nums8 = {2,5,1,3,4,7};
        int n8 = 3;

        int result8[] = shuffle(nums8, n8);

         // here, result 8 contains the shuffled array, lets print the result array

         for(int nshufle: result8) {
            System.out.print(nshufle + ", ");
         }


         

    }

    // Methods of Solutions

    public static List<List<Integer>> findDifference(int[] nums1, int[] nums2) {

        // brute force approach (commented)

        /*

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> answer0 = new ArrayList<>();
        List<Integer> answer1 = new ArrayList<>();
        

        // for answer0
        for(int i = 0; i<nums1.length; i++) {
            boolean isIPresent = false;
            for(int j = 0; j<nums2.length; j++) {
                if(nums1[i] == nums2[j]) {
                    isIPresent = true;
                    break;
                }
            }
            if(!isIPresent) {
                // nums[i] is only in nums1 and not in nums2.
                if(!answer0.contains(nums1[i])) {
                    answer0.add(nums1[i]);
                }
                
            }
        }

        // for answer1
        for(int j = 0; j<nums2.length; j++) {
            boolean isJPresent = false;
            for(int i = 0; i<nums1.length; i++) {
                if(nums2[j] == nums1[i]) {
                    isJPresent = true;
                    break;
                }
            }
            if(!isJPresent) {
                // nums[j] is only present in num2 and not num1
                if(!answer1.contains(nums2[j])) {
                    answer1.add(nums2[j]);
                }
            }
        }

        result.add(answer0);
        result.add(answer1);
        return result;

         */

         // optimized approach using a HashSet

         Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        for (int num : nums1) {
            set1.add(num);
        }

        for (int num : nums2) {
            set2.add(num);
        }

        List<Integer> result1 = new ArrayList<>();
        List<Integer> result2 = new ArrayList<>();

        for (int num : nums1) {
            if (!set2.contains(num)) {
                result1.add(num);
            }
        }

        for (int num : nums2) {
            if (!set1.contains(num)) {
                result2.add(num);
            }
        }

        // now results may contain duplicate elements, remove it using hashSet

        HashSet<Integer> set3 = new HashSet<>(result1);
        result1.clear();
        result1.addAll(set3);


        HashSet<Integer> set4 = new HashSet<>(result2);
        result2.clear();
        result2.addAll(set4);


        List<List<Integer>> result = new ArrayList<>();
        result.add(result1);
        result.add(result2);
        return result;
    }

    public static int[][] transpose(int[][] matrix) {
        // put j at i and length of i will be j and vice versa
        int row = matrix.length;
        int col = matrix[0].length;

        int transposedMatrix[][] = new int[col][row];

        for(int i = 0; i<row; i++) {
            for(int j = 0; j<col; j++) {
                // swap i and j for transposed matrix
                transposedMatrix[j][i] = matrix[i][j]; 
            }
        }
        return transposedMatrix;
    }

    public static int arrayPairSum(int[] nums) {

        // logic - to get the maximum sum from the minimum of two nubmers, we need the lowest and 
        //highest number
        

        Arrays.sort(nums);
        int maximized = 0;
        for(int i = 0; i<nums.length; i+=2) {
            maximized += nums[i];
        }
        return maximized;
        
    }

    public static int arrangeCoins(int n) {
        // brute force approach
        /*
        int rows = 0;
        for(int i = 1; i<=n; i++) {
            n = n-i;
            // this formed the ith step using n coins
            if(n>= 0) {
                rows++;
            } else {
                break;
            }

        }
        return rows;
         */

        // optimized approach using binary search
        
        int start = 0;
        int end = n;

        while(start<=end) {
            int mid = start + (end-start)/2;
            int coins = (mid * (mid+1)) / 2;
            if(coins == n) {
                return mid;
            } else if(coins < n) {
                start = mid+1;
            } else {
                end = mid-1;
            }
        }
        return end;

    }

    public static int[] sortedSquare(int[] nums) {

        // brute force approach

        /*
        for(int i = 0; i<nums.length; i++) {
            nums[i] = nums[i] * nums[i];
        }
        // now sort this array
        Arrays.sort(nums);
        return nums;

         */

        // optimized approach

        int[] result = new int[nums.length];

        int left = 0;
        int right = nums.length-1;
        int index = right;

        while(left <= right) {
            int leftSquare = nums[left] * nums[left];
            int rightSquare = nums[right] * nums[right];

            if(leftSquare > rightSquare) {
                result[index] = leftSquare;
                left++;
            } else {
                result[index] = rightSquare;
                right--;
                
            }
            index--;
        }
        return result;

    }

    public static int maxCount(int m, int n, int[][] ops) {

        int minRow = m;
        int minCol = n;

        for(int[] op: ops) {
            minRow = Math.min(minRow, op[0]);
            minCol = Math.min(minCol, op[1]);
        }
        return minRow * minCol;
        
    }

    public static int[] shuffle(int[] nums, int n) {
        for (int i = 0; i < n; i++) {
            int temp = nums[i];
            nums[i] = nums[i + n];
            nums[i + n] = temp;
        }
        return nums;

    }
    
}
