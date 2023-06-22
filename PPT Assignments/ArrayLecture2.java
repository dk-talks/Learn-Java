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
    
}
