class Question2 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        findPerm(nums, temp, result);   
        return result;
    }

    public static void findPerm(int[] nums, List<Integer> temp, List<List<Integer>> result) {

        // base condtion
        if(temp.size() == nums.length) {
            // temp has a valid permutaiton
            result.add(temp);
            return;
        }

        for(int i = 0; i<nums.length; i++) {
            if(temp.contains(nums[i])) {
                continue;
            }
            temp.add(nums[i]);
            findPerm(nums, new ArrayList<>(temp), result); // recursive call
            temp.remove(temp.size()-1);
            
        }

     }
}
