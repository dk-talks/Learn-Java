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

    </aside>
            */
    
        int[] arr = {2,7,11,15};
        int target = 19; 

        int[] result = question1(arr, target);

        for(int n: result) {
            System.out.print(n + ", ");
            
        }

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

        //--------------------------------------------------------------------------------------------------------------------


    }

    public static int[] question1(int[] arr, int target) {
       
        // brute force approach O(n^2)
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
