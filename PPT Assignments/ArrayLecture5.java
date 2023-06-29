
import java.util.*;

public class ArrayLecture5 {
    
    public static void main(String[] args) {


        /*
         Que. 1 - 2022. Convert 1D Array Into 2D Array
         */

         int[] original1 = {1,2,3,4};
         int m1 = 2;
         int n1 = 2;

         int[][] result2D = construct2DArray(original1, m1, n1); 
        // result2D contains the constructed 2D array;

        for(int[] result1: result2D) {
            for(int num1: result1) {
                System.out.print(num1 + " ");
            }
            System.out.println();
        }

        /*
         Que. 2 - 441. Arranging Coins

         */
        int coins2 = 5;
        int steps = arrangeCoins(coins2);
        System.out.println("Number of steps can be formed is :" + steps);

        /*
         Que - 3 - 977. Squares of a Sorted Array
            Given an integer array nums sorted in non-decreasing order, return an array of the squares of each 
            number sorted in non-decreasing order.
         */

        int[] nums3 = {-4,-1,0,3,10};
        int[] squareNums3 = sortedSquare(nums3);

        // printing the sotred squared array
        for(int n6: squareNums3) {
           System.out.print(n6 + ", ");
        }
        System.out.println();

        /*
         Que. 4 - 2215. Find the Difference of Two Arrays
         Given two 0-indexed integer arrays nums1 and nums2, return a list answer of
          size 2 where:
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

        /*
        Que. 5 - 1385. Find the Distance Value Between Two Arrays
         */

        int[] arr51 = {4,5,8};
        int[] arr52 = {10,9,1,8};
        int d5 = 2;

        int distance5 = findTheDistanceValue(arr51, arr52, d5);
        System.out.println("The distance value between two array is: " + distance5);


        /*
        Que. - 6 - 442. Find All Duplicates in an Array 
         */

        int[] nums6 = {4,3,2,7,8,2,3,1};

        List<Integer> duplicates6 = findDuplicates(nums6);

        System.out.print("duplicates in array are: ");

        for(int n6: duplicates6) {
            System.out.print(n6 + ", ");
        }
        System.out.println();

        /*
        Que. - 7 - 153. Find Minimum in Rotated Sorted Array
         */

        int[] rotatedArray = {3,4,5,1,2};

        int minimumNum = findMin(rotatedArray);

        System.out.println("MInimum number in rotated array is: " + minimumNum);



        
        /*
         Que. 8 - 2007. Find Original Array From Doubled Array
         */

         int[] changed = {1,3,4,2,6,8};
         int[] original = findOriginalArray(changed);

         // printing original array
         for(int n: original) {
            System.out.print(n + " ");
         }
         System.out.println();


    }

    // answer 1 

    public static int[][] construct2DArray(int[] original, int m, int n) {
        int[][] result2D = new int[m][n];
        //corner case
        if(m*n != original.length) {
            int[][] result = new int[0][0];
            return result;
        }

        int pass = 0;
        for(int i = 0; i<m; i++) {
            for(int j = 0; j<n; j++) {
                result2D[i][j] = original[pass];
                pass++;
            }
        }
        return result2D;
    }

    // answer 2 

    public static int arrangeCoins(int n) {

        // optimized approach
        /*
        we know that 1+2+3 = 6, 6 coins form 3 rows.
        using this in mid sum of n natural intigers will form n rows.
        */

        // lets do thi using bianry search
        int left = 0;
        int right = n;

        while(left<=right) {
            int mid = left + (right-left)/2;
            // now check in how many coins mid rows are formed
            long rows = (long) mid * (mid + 1) / 2;; // 1+2+3......+mid
            if(rows == n) {
                return mid;
                // we found the perfect solution;
            } else if(rows<n) {
                left = mid+1;
            } else {
                right = mid-1;
            }
        }

        return right;


    }

    // answer 3 - 

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

    // answer 4 
    
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


    // answer 5 

    public static int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        // brute force approach
        int distance = 0;
        for(int i = 0; i<arr1.length; i++) {
            boolean withinThreshhold = true;
            for(int j = 0; j<arr2.length; j++) {
                int difference = arr1[i]-arr2[j];
                // apply mod to it
                if(difference < 0) {
                    difference *= -1;
                }
                if(difference <= d) {
                    withinThreshhold = false;
                    break;
                }
            }
            if(withinThreshhold) {
                distance++;
            }
        }
        return distance;
    }

    


    // answer 6

    public static List<Integer> findDuplicates(int[] nums) {

        Arrays.sort(nums);
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i<nums.length-1; i++) {
            if(nums[i] == nums[i+1]) {
                list.add(nums[i]);
            }
        }
        return list;
        
    }


    // answer 7

    public static int findMin(int[] nums) {

        // using binary search to find the pivot point (nums[i] > nums[i+1])

        int n = nums.length;
        int start = 0;
        int end = n-1;

        if(n == 1) {
            return nums[0];
        }

        while(start <= end) {
            int mid = start + (end - start) / 2;

            // check for pivot
            if( mid != n-1 && nums[mid] > nums[mid+1]) {
                return nums[mid+1];
            }

            if(nums[mid] > nums[n-1]) {
                start = mid+1;
            } else {
                end = mid-1;
            }
        }
        // if pivot is not found, that means array is fully rotated and minimum element is nums[0]
        return nums[0];
        
    }





    // answer 8

    public static int[] findOriginalArray(int[] changed) {
        int n = changed.length;
        int[] fake = new int[0];
        // corner cases
        if(n % 2 != 0) {
            return fake;
        }
        // adding changed element to arraylist for easy access
        List<Integer> changedList = new ArrayList<>();
        for(int num: changed) {
            changedList.add(num);
        }
        List<Integer> originalList = new ArrayList<>();

        for(int num: changed) {
            if(num % 2 != 0) {
                // its not a double element, add to original
                originalList.add(num);
            } else {
                int doubled = num * 2;
                int half = num/2;
                if(changedList.contains(doubled) && changedList.contains(half)) {
                    // assuming this element is original , not sure
                    originalList.add(num);
                } else if(changedList.contains(doubled)) {
                    // surely, nums is an original
                    originalList.add(num);
                } else if(changedList.contains(half)) {
                    // surely, the half element is original
                    originalList.add(half);
                }
            }
        }
        // now check if original list count is half
        if(originalList.size() == n/2) {
            int[] original = new int[n/2];
            int pass = 0;
            for(int n1: originalList) {
                original[pass] = n1;
                pass++;
            }
            return original;
        } else {
            return fake;
        }
    }


}
