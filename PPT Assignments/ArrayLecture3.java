import java.util.*;;

public class ArrayLecture3 {

    public static void main(String args[]) {

        // Que - 1 - 16. 3 Sum Closest - // find the sum of three elements from the array that is closest to the target.

        int nums[] = {-1, 2, 1, -4};
        int target = 1;
        int closesSum = threeSumClosest(nums, target);
        System.out.println("Closest sum of three numbers with the given target is: " + closesSum);

        // -x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x

        // Que - 2 - 4Sum  -- 

        int nums1[] = {1,0,-1,0,-2,2};
        int target1 = 0;
        // moto of the problem is to find sum of four distinct elements that is equal to target, and there can be multiple solutions, so store them in a list of lists.

        List<List<Integer>> quadriplets  = new ArrayList<>();

        quadriplets = fourSum(nums1, target1);

        // printing the result list
        for(List<Integer> list: quadriplets) {
            for(int n: list) {
                System.out.print(n + " ");
            }
            System.out.println();
        }
   }  

   public static int threeSumClosest(int[] nums, int target) {

        // brute force approach - 

        /*
         * loop for i, j and k, sum them, and find their absolute difference and compare with the absolute differece of previous sum
         * and return the smallest.
         */

         // optimized approach

         Arrays.sort(nums);

         int closestSum = Integer.MAX_VALUE;

         for(int i = 0; i<nums.length-1; i++) {
            int left = i+1;
            int right = nums.length-1;

            while(left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                // moving toward target with below step;
                if(sum == target) {
                    return sum;
                } else if(sum < target) {
                    left++;
                } else {
                    right--;
                }

                if(Math.abs(sum - target) < Math.abs(closestSum - target)) {
                    closestSum = sum;
                }



            }
         }

         return closestSum;

   }

   public static List<List<Integer>> fourSum(int[] nums, int target) {

        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length < 4)
            return result;

            // checking a corner case, when all four elements are same and target is different.

        if(nums.length == 4) {
            int firstElement = nums[0];
            boolean isAllSame = true;
            for(int i = 1; i<nums.length; i++) {
                if(nums[i] != firstElement) {
                    isAllSame = false;
                }
            }
            if(isAllSame && target != firstElement) {
                return result;
            }
        }

        Arrays.sort(nums);

        int n = nums.length;
        for (int i = 0; i < n - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue;

            for (int j = i + 1; j < n - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1])
                    continue;

                int left = j + 1;
                int right = n - 1;

                while (left < right) {
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum < target) {
                        left++;
                    } else if (sum > target) {
                        right--;
                    } else {
                        result.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));

                        while (left < right && nums[left] == nums[left + 1])
                            left++;
                        while (left < right && nums[right] == nums[right - 1])
                            right--;

                        left++;
                        right--;
                    }
                }
            }
        }

        return result;
    
    }

   

    
}
