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

    // brute force aproach

    public int findPeakElement(int[] nums) {

        int peakElement = 0;

        if(nums.length == 1) {
            return 0;
        }

        for(int i = 0; i<nums.length; i++) {
            if(i>0 && nums[i] > nums[i-1]) {
                // left side is smaller, check right side
                if(i<nums.length-1) {
                    // these are other elements remaining
                    if(nums[i] > nums[i+1]) {
                        return i;
                    }
                } else {
                    // i is the last element, i is the ansesr
                    return i;
                }

            }
        }
        return peakElement;
        
    }

    // optimized approach using binary search

    public int findPeakElement(int[] nums) {

        // using binary search
        // implementing binary search does not necessarily need sorted array, we just have to change the scenario how will it be implemented, and the time complexity wiill remain same o(log n)

        int start = 0;
        int end = nums.length-1;

        while(start < end) {
            int mid = start + (end - start)/2;

            if(nums[mid] < nums[mid+1]) {
                // mid+1 can be our potential answer
                start = mid+1;
            } else {
                // mid can be our potential answer, or the left side of array
                end = mid;
            }
        }

        // at some point, staart and end will be same, our answer is both start & end
        return start;
        
    }


    // Question 4 - 35. Search Insert Position

    public int searchInsert(int[] nums, int target) {
        int start = 0;
        int end = nums.length-1;

        while(start <= end) {
            int mid = start + (end - start)/2;
            if(nums[mid] == target) {
                return mid;
            } else if(nums[mid] < target) {
                start = mid+1;
            } else {
                end = mid-1;
            }
        }

        // if target not found, it would be placed at start position 
        return start;
    }


    // Question 5 - 169 - Majority Element

    public int majorityElement(int[] nums) {
        
        Arrays.sort(nums);
        
        int largestFreq = 0;
        int majorityElement = nums[0];

        for(int i = 0; i<nums.length; i++) {
            int currFreq = 0;
            while(i<nums.length-1 && nums[i] == nums[i+1]) {
                currFreq++;
                i++;
            }
            if(currFreq > largestFreq) {
                largestFreq = currFreq;
                majorityElement = nums[i];
            }

        }

        return majorityElement;

    }

    // Question 6 - 278. First Bad Version

    public int firstBadVersion(int n) {
        int start = 1;
        int end = n;
        while(start <= end){
            int mid = start + (end-start)/2;
            if(isBadVersion(mid) == false){
                start = mid+1;
            }else{
                end = mid-1;
            }
        }
        return start;
    }


    // Question 7 - Inversion count in Array using Merge Sort

    static int getInvCount(int n)
    {
        int inv_count = 0;
        for (int i = 0; i < n - 1; i++)
            for (int j = i + 1; j < n; j++)
                if (arr[i] > arr[j])
                    inv_count++;
 
        return inv_count;
    }



    // Question 8 - Find common elements in three sorted arrays

    void findCommon(int ar1[], int ar2[], int ar3[])
    {
        // Initialize starting indexes for ar1[], ar2[] and
        // ar3[]
        int i = 0, j = 0, k = 0;
 
        // Iterate through three arrays while all arrays
        // have elements
        while (i < ar1.length && j < ar2.length
               && k < ar3.length) {
            // If x = y and y = z, print any of them and
            // move ahead in all arrays
            if (ar1[i] == ar2[j] && ar2[j] == ar3[k]) {
                System.out.print(ar1[i] + " ");
                i++;
                j++;
                k++;
            }
 
            // x < y
            else if (ar1[i] < ar2[j])
                i++;
 
            // y < z
            else if (ar2[j] < ar3[k])
                j++;
 
            // We reach here when x > y and z < y, i.e., z
            // is smallest
            else
                k++;
        }
    }



    

  
}
