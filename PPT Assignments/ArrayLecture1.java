import java.util.HashMap;

class ArrayLecture1 {
    public static void main(String[] args) {
        
        /*
    💡 **Q1.** Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

    You may assume that each input would have exactly one solution, and you may not use the same element twice.

    You can return the answer in any order.

    **Example:**
    Input: nums = [2,7,11,15], target = 9
    Output0 [0,1]

    **Explanation:** Because nums[0] + nums[1] == 9, we return [0, 1]

            */
    
        int[] arr = {2,7,11,15};
        int target = 19; 

        int[] result = question1(arr, target);

        for(int n: result) {
            System.out.print(n + ", ");
            
        }

        //-------------------------------Question 2-------------------------------------------------------------------------------------


        // Que 2 - Given an integer array nums and an integer val, remove all occurrences of val in nums in-place. The order of the elements may be changed. 
        //Then return the number of elements in nums which are not equal to val.

        // Solution

        int arr1[] = {3,2,2,3};
        int val = 3;

        int count = 0;
        for(int i = 0; i<arr1.length; i++) {
            if(arr[i] != val) {
                arr[count] = arr[i];
                count++;
            }
        }
        // now count is equal to number of elements not equal to val and arr is also converted to desired format.

        //------------------------------------------------Question 3--------------------------------------------------------------------

        /*
        💡 Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

        You must write an algorithm with O(log n) runtime complexity.
         */

         // It is a simple binary search problem 
         // solution

         int[] nums = {1,3,5,7};
         int target1 = 5;

        int answer = searchElement(nums, target1);

        System.out.println("Search answer is: " + answer);

        //------------------------------------------------Question 4--------------------------------------------------------------------

        /*
💡       **Q4.** You are given a large integer represented as an integer array digits, where each digits[i] is the ith digit of the integer. The digits are ordered from most significant 
            to least significant in left-to-right order. The large integer does not contain any leading 0's. Increment the large integer by one and return the resulting array of digits.

</aside>
         */

        int[] digits = {9,9,9,9,9};
        
        int[] incrementedDigit = incrementDigitByOne(digits);

        System.out.println("incremented digit array is: " + incrementedDigit);



        //------------------------------------------------Question 5--------------------------------------------------------------------

        /*
         You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers m and n, representing the number of elements in nums1 and nums2 respectively.
        Merge nums1 and nums2 into a single array sorted in non-decreasing order.
         */

         int nums1[] = {1,2,3,0,0,0};
         int m = 3;
         int[] nums2 = {2,5,6};
         int n = 3;

         int[] mergedSortedArray = merge(nums1, m, nums2, n);
         System.out.println("The sorted meged array is : " + mergedSortedArray);
         

    }

    public static int[] merge(int[] nums1, int m, int[] nums2, int n) {

        for(int i = nums1.length-1, j=n-1; i>=nums1.length-1-n && j>=0; i--, j--) {
            nums1[i] = nums2[j];
        }
        // Arrays.sort(nums1);
        // instead to sort using inbuilt method, lets use bubble sort to brush up my sorting skills...

        for(int i = 0; i<nums1.length; i++) {
            boolean isSwapped = false;
            for(int j = 0; j<nums1.length-i-1; j++) {
                if(nums1[j] > nums1[j+1]) {
                    isSwapped = true;
                    int temp = nums1[j];
                    nums1[j] = nums1[j+1];
                    nums1[j+1] = temp;
                }
            }
            if(!isSwapped) {
                // there is no swapping, i.e array is already sorted
                break;
            }
        }

        return nums1;
        
    }

    public static int[] incrementDigitByOne(int[] digits) {
        boolean isOK = false;
        for(int i = digits.length-1; i>=0; i--) {
            if(digits[i] > 8) {
                digits[i] = 0;
                continue;
            }
            digits[i] = digits[i] + 1;
            isOK = true;
            break;
        }
        if(!isOK) {
            int count1 = digits.length;
            int[] newDigits = new int[count1+1];
            for(int i = 0; i<newDigits.length; i++) {
                if(i == 0) {
                    newDigits[i] = 1;
                } else {
                    newDigits[i] = 0;
                }
            }
            return newDigits;
        }
        return digits;
    }



    public static int searchElement(int[] nums, int target1) {

        int start = 0;
        int end = nums.length - 1;

        while(start <= end){
            int mid = start + (end-start)/2;

            if(nums[mid] > target1) {
                end = mid - 1;
            }else if(nums[mid] < target1){
                start = mid + 1;
            }else {
                return mid;
            }

        }
        return start;

    }

    public static int[] question1(int[] arr, int target) {
       
        // brute force approach O(n^2)
        /*
        int[] result = new int[2];

        for(int i = 0; i<arr.length-1; i++) {
            for(int j = i+1; j<arr.length; j++) {
                if(target - arr[i] == arr[j]) {
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }
        return result;
         */

        //optimized approach - time complexity - O(n)
        HashMap<Integer, Integer> hm = new HashMap<>();
        int[] result = new int[2];
        for(int i = 0; i<arr.length; i++) {
            if(hm.containsKey(target-arr[i])) {
                result[0] = i;
                result[1] = hm.get(target-arr[i]);
                return result;
            }
            hm.put(arr[i], i);

        }
        return result;


    }
}
