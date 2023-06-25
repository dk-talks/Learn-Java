public class MockTest1 {
    
    public static void main(String[] args) {
        

        // Que 1 = Move Zeroes

        int[] nums = {0,1,0,3,12};

        int counter = 0;
        for(int i = 0; i<nums.length; i++) {
            // first bringing all non-zeroes items to front without changing their relative order..
            if(nums[i] != 0) {
                nums[counter] = nums[i];
                counter++;
            }
        }

        // now putting all zeroes to last
        for(int i = counter; i<nums.length; i++) {
            nums[counter] = 0;
            counter++;
        }

        // now nums have been converted to desired style

        // printing nums to see result 

        for(int n: nums) {
            System.out.print(n + " ");
        }



    }

}
