public class DSALecture9 {

    // question 1 - 167. Two Sum II - Input Array Is Sorted

    public int[] twoSum(int[] numbers, int target) {
        
        // using two pointer approach
        int start = 0;
        int end = numbers.length -1;

        while(start < end) {
            if(numbers[start] + numbers[end] == target) {
                // start and end are our solutions
                return new int[]{start+1, end+1};
            } else if(numbers[start] + numbers[end] < target) {
                start++;
            } else {
                end--;
            }
        }

        return new int[2];

    }


    // question 2 - Find First and Last Position of Element in Sorted Array

    public int[] searchRange(int[] nums, int target) {
        int startIdx = -1;
        int endIdx = -1;
        int[] result = new int[2];

        int start = 0;
        int end = nums.length-1;

        // check for starting index
        while(start <= end) {
            int mid = start + (end-start) / 2;
            if(nums[mid] == target) {
                // check for starting Index
                if(mid > 0) {
                    if(nums[mid-1] != target) {
                        startIdx = mid;
                        break;
                    } else {
                        end = mid-1;
                    }
                } else {
                    startIdx = mid;
                    break;
                }
                 
            } else if(nums[mid] > target) {
                end = mid-1;
            } else {
                start = mid+1;
            }
        }

        start = 0;
        end = nums.length-1;
        //check for end index
        while(start <= end) {
            int mid = start + (end-start) / 2;
            if(nums[mid] == target) {

                if(mid<nums.length-1) {
                    if(nums[mid+1] != target) {
                        endIdx = mid;
                        break;
                    } else {
                        start = mid+1;
                    }
                } else {
                    endIdx = mid;
                    break;
                }
                 
            } else if(nums[mid] > target) {
                end = mid-1;
            } else {
                start = mid+1;
            }
        }

        result[0] = startIdx;
        result[1] = endIdx;

        return result;

    }



    // Question 3 - 162. Find Peak Element

  
}
