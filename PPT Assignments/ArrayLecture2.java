import java.util.*;

public class ArrayLecture2 {

    public static void main(String[] args) {
        
        // Que. 1 - Array Partition (561)
        int[] nums = {1,4,3,2};
        int maximizedSum = arrayPairSum(nums);
        System.out.println("Your Maximized sum is: " + maximizedSum);


        // Que. 2 - 575. Distribute Candies

        int[] candyType = {1,1,2,2,3,3};
        int differentTypesOfCandiesSheCanEat = distributeCandies(candyType);
        System.out.println("She can eat " + differentTypesOfCandiesSheCanEat + " different types of candies.");

        // Que. 3 - 594. Longest Harmonious Subsequence
        int nums1[] = {1,3,2,2,5,2,3,7};

        // brute force approach first -
        int max1 = findLHSBruteForce(nums1);
        System.out.println("Longest Harmoneous subsequence using Brute Force approach is: " + max1);
        // Now optimized approach
        int max = findLHS(nums1);
        System.out.println("Longest Harmoneous subsequence is: " + max);

        // Que. 4 - 605. Can Place Flowers

        int[] flowerbed = {1,0,0,0,1,0,0};
        int n = 2;

        boolean canPlot = canPlaceFlowers(flowerbed, n);
        System.out.println("Can Place folwer? - " + canPlot);


        // Que 5 - 628. Maximum Product of Three Numbers

        int[] nums2 = {-100, 4, -98, -6, 2,3};
        int maximumProductOf3 = maximumProduct(nums2);
        System.out.println("Maximum product of three elements is: " + maximumProductOf3);
        

        // Que. 6 - 704. Binary Search 
        int[] nums3 = {4,10,15,24,100,2000};
        int target = 24;
        int targetIndex = binarySearch(nums3, target);
        System.out.println("The index of target is: " + targetIndex);

        // Que. 7 - 896 - Monotronic Array
        int[] nums4 = {1,2,2,3};
        System.out.println("Is nums4 Monotronic: " + isMonotronic(nums4));

        // Que. 8 - 908. Smallest Range I.
        int nums5 = {1,3,6};
        int k = 3;
        System.out.println("Minimum difference after applying operation is: " + smallestRangeI(nums5, k));

        
    }

    public static int arrayPairSum(int[] nums) {

        // at this point, I just used the hint, will solve and will justify the logic in next submission

        Arrays.sort(nums);
        int maximized = 0;
        for(int i = 0; i<nums.length; i+=2) {
            maximized += nums[i];
        }
        return maximized;
        
    }

    public static int distributeCandies(int[] candyType) {
        int n = candyType.length;
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int i = 0; i<candyType.length; i++) {
            hm.put(candyType[i], hm.getOrDefault(candyType[i], 0) + 1);
        }
        return Math.min(hm.size(), n/2);
    }

    public static int findLHS(int[] nums) {

        HashMap<Integer, Integer> hm = new HashMap<>();
        int max = 0;

        for(int i = 0; i<nums.length; i++) {
            // if key already present, increase it by one else set 0 then increase by one
            hm.put(nums[i], hm.getOrDefault(nums[i], 0)+1);
        }

        for(int n: nums) {
            if(hm.containsKey(n+1)) {
                int length = hm.get(n) + hm.get(n+1);
                max = Math.max(max, length);
            }
            if(hm.containsKey(n-1)) {
                int length = hm.get(n) + hm.get(n-1);
                max = Math.max(max, length);
            }
        }
        return max;

        // time complexity - O(n)
        // space complexity - O(n)
        
    }

    public static int findLHSBruteForce(int[] nums) {


        int lhs = 0;
        for(int i = 0; i<nums.length; i++) {
            int count = checkElement(nums, i);
            lhs = Math.max(lhs, count);
        }
        return lhs;
        
    }

    // my approach - loop through the array, take current element, and then check it with element+1 and element-1 seprately and count, also check if both max and min numbers are avalilable
    // using isPairAvailable boolean value.


    public static int checkElement(int[] nums, int i) {
        int countWinner = 0;
        int countMinus = 0;
        int countPlus  = 0;
        boolean isPairAvailableForMinus = false;
        boolean isPairAvailableForPlus = false;
        for(int j = i; j<nums.length;j++) {
            if(nums[j] == nums[i]) {
                countMinus++;
                countPlus++;
            }
            if(nums[j] == nums[i]+1) {
                countPlus++;
                isPairAvailableForPlus = true;
            } else if(nums[j] == nums[i]-1) {
                countMinus++;
                isPairAvailableForMinus = true;
            }
            
        }
        if(!isPairAvailableForPlus) {
            countPlus = 0;
        }
        if(!isPairAvailableForMinus) {
            countMinus = 0;
        }
        countWinner = Math.max(countPlus, countMinus);
        return countWinner;
        
    }

    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        
        int count = 0; // Count of available spots to plant flowers
        
        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 0) {
                // Check if the current spot and its adjacent spots are empty also make sure they do not get out of bound
                boolean canPlant = (i == 0 || flowerbed[i - 1] == 0) && (i == flowerbed.length - 1 || flowerbed[i + 1] == 0);
                if (canPlant) {
                    flowerbed[i] = 1; // Plant a flower
                    count++;
                }
            }
        }
        
        return count >= n;

        
    }

    public static int maximumProduct(int[] nums) {
        
        Arrays.sort(nums);
        int len = nums.length;
        

        // there can be two solutions 1. - Max1 * Max2 * Max3 OR 2. Min1 * Min2 * Max1
        Arrays.sort(nums);
        int product1 = nums[len-1] * nums[len-2] * nums[len-3];
        int product2 = nums[0] * nums[1] * nums[len-1];

        return Math.max(product1, product2);
        


    }

    public static int binarySearch(int[] nums, int target) {

        int start = 0;
        int end = nums.length-1;

        while(start<=end) {
            int mid = start + (end-start)/2;
            if(nums[mid] == target) {
                return mid;
            } else if(nums[mid] < target) {
                start = mid+1;
            } else {
                end = mid-1;
            }
        }
        return -1;

    }

    public static boolean isMonotonic(int[] nums) {
        // brute force approach
        boolean isMonotoneIncreasing = true;
        boolean isMonotoneDecreasing = true;

        // check monotone Increasing
        for(int i = 0; i<nums.length-1; i++) {
            if(nums[i] > nums[i+1]) {
                isMonotoneIncreasing = false;
            }
            if(nums[i] < nums[i+1]) {
                isMonotoneDecreasing = false;
            }
        }
        if(isMonotoneIncreasing == true || isMonotoneDecreasing == true) {
            return true;
        } else {
            return false;
        }
    }

    public static int smallestRangeI(int[] nums, int k) {
        // this question is simple, but wordings is weird
        // just have to find min and max from nums, and add k to min and sub k to max and return the difference, also, difference should not be less than 0

        // first of all find max and min
        int maxValue = Integer.MIN_VALUE;
        int minValue = Integer.MAX_VALUE;

        for(int i = 0; i<nums.length; i++) {
            maxValue = Math.max(maxValue, nums[i]);
            minValue = Math.min(minValue, nums[i]);
        }
        if(minValue+k >= maxValue-k) {
            return 0;
        } else {
            return (maxValue-k) - (minValue+k);
        }
    }
    
}
