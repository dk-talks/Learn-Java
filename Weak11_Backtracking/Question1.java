public class Question1 {
    public static void main(String[] args) {

        // Que.1  - 698. Partition to K Equal Sum Subsets

        int[] nums = {4,3,2,3,5,2,1};
        int k = 4;

        boolean isPartitionPossible = canPartitionKSubsets(nums, k);

        System.out.println("Is Partitioning K Subset possible: " + isPartitionPossible);

        
    }


    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % k != 0) {
            return false;
        }

        int targetSum = sum / k;
        Arrays.sort(nums);
        int[] subsetSums = new int[k];

        return canPartition(nums, nums.length - 1, subsetSums, targetSum);
    }

    private boolean canPartition(int[] nums, int index, int[] subsetSums, int targetSum) {
        if (index < 0) {
            for (int subsetSum : subsetSums) {
                if (subsetSum != targetSum) {
                    return false;
                }
            }
            return true;
        }

        int num = nums[index];
        for (int i = 0; i < subsetSums.length; i++) {
            if (subsetSums[i] + num <= targetSum) {
                subsetSums[i] += num;
                if (canPartition(nums, index - 1, subsetSums, targetSum)) {
                    return true;
                }
                subsetSums[i] -= num; // Backtracking
            }
        }

        return false;
    }
}
