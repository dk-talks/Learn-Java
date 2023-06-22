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
    
}
