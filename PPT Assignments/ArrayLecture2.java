import java.util.*;

public class ArrayLecture2 {

    public static void main(String[] args) {
        
        // Que. 1 - Array Partition (561)
        int[] nums = {1,4,3,2};
        int maximizedSum = arrayPairSum(nums);
        System.out.println("Your Maximized sum is: " + maximizedSum);

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
    
}
