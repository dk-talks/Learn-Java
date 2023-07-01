import java.util.HashMap;

public class StringLecture1 {

    public static void main(String[] args) {
        
        /*
        ****************************************************************
         Que - 1 - 942. DI String Match
         */

        String s = "IDID";

        int[] perm = diStringMatch(s);
        for (int i : perm) {
            System.out.print(i + " ");
        }
        System.out.println();

        /*
        ****************************************************************
         Que - 2 - 74. Search a 2D Matrix
         */

        int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};

        boolean isTargetPresent = searchMatrix(matrix, 3);
        System.out.println("Is element present in 2D aray: " + isTargetPresent);


        /*
        ****************************************************************
         Que - 3 - 941. Valid Mountain Array
         */

        int[] arr = {0,3,2,1};
        boolean isValidMountain = validMountainArray(arr);
        System.out.println("Is arr a valid mountain : " + isValidMountain);



        /*
        ****************************************************************
         Que - 4 - 525. Contiguous Array

         */


    }


    public static int[] diStringMatch(String s) {

        // using naiva / brute force approach

        int[] ans = new int[s.length() + 1];
        int startD = s.length();
        int startI = 0;
        int pass = 0;
        for(char c: s.toCharArray()) {
            if(c == 'I') {
                ans[pass++] = startI++;
            } else {
                ans[pass++] = startD--;
            }
        }
        // now last element is left (n+1th), so fill it with either startD OR startI
        ans[s.length()] = startD;

        return ans;
        
    }



    public static boolean searchMatrix(int[][] matrix, int target) {

        // using binary search -- 

        // I will be assuming as if each row is an array to check for target

        for(int i = 0; i<matrix.length; i++) {

            // checking if last element of current row is less than the target, that means target is in future rows.. just continue then
            if(matrix[i][matrix[i].length-1] < target) {
                // target is in future rows, continue 
                continue;
            }
            int start = 0;
            int end = matrix[i].length-1;

            while(start<=end) {
                int mid = start + (end - start) / 2;
                if(matrix[i][mid] == target) {
                    return true;
                } else if(matrix[i][mid] < target) {
                    start = mid+1;
                } else {
                    end = mid-1;
                }
            }

        }

        return false;
        
    }



    public static boolean validMountainArray(int[] arr) {

        // using brute force approach

        if(arr.length < 3) {
            return false;
        }

        int peak_index = 0;
        int temp = -1;
        for(int i = 0; i<arr.length; i++) {
            if(arr[i] > temp) {
                temp = arr[i];
                peak_index = i;
            }
        }

        // eleminate some more 
        if(peak_index == 0 || peak_index == arr.length-1) {
            return false;
        }

        // now just check both sides slopes from the peak

        // check left side
        for(int i = 0; i < peak_index; i++) {
            if(arr[i] == arr[i+1] || arr[i] > arr[i+1]) {
                return false;
            }
        }
        // check right side 
        for(int i = arr.length-1; i>peak_index;i--) {
            if(arr[i] == arr[i-1] || arr[i] > arr[i-1]) {
                return false;
            }
        }

        return true;
        
    }


    
}
