import java.util.*;

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

        int[] binaryArr = {0,1,0};
        int maxLen = findMaxLength(binaryArr);

        System.out.println("Max length of equal number of 0s and 1s is: " + maxLen);




        /*
        ****************************************************************
         Que - 5 -  1874. Minimize Product Sum of Two Arrays (Premium Leetcode question)
         */

        int[] nums1 = {5, 3, 4, 2}; // Example input array 1
        int[] nums2 = {4, 2, 2, 5}; // Example input array 2

        int minProductSum = minimizeProductSum(nums1, nums2);
        System.out.println("Minimum Product Sum: " + minProductSum);


        /*
        ****************************************************************
         Que - 6 -  2007. Find Original Array From Doubled Array
         */

        int[] changed = {2,1,2,4,2,4};
        int[] originalArr = findOriginalArray(changed);

        System.out.print(" The original array is: ");
        for(int n: originalArr) {
            System.out.print(n + ", ");
        }
        System.out.println();


        /*
        ****************************************************************
         Que - 7 -  59. Spiral Matrix II
        given an integer n, create an n*n matrix in spiral form 
         */

        int n = 4;
        int spiral_matrix[][] = generateMatrix(n);

        System.out.println("Generated spiral matrix is: ");

        for(int i = 0; i<spiral_matrix.length; i++) {
            for(int j = 0; j<spiral_matrix.length; j++) {
                System.out.print(spiral_matrix[i][j] + " ");
            }
            System.out.println();
        }


        /*
        ****************************************************************
         Que - 8 -  311 - Sparse Matrix Multiplication
         */

        int[][] mat1 = {{1,0,0},{-1,0,3}};
        int[][] mat2 = {{7,0,0},{0,0,0},{0,0,1}};

        int[][] c = multiply(mat1, mat2);

        System.out.println("Spars Matrix Multiplication is: ");
        for(int i = 0; i<c.length; i++) {
            for(int j = 0; j<c[i].length; j++) {
                System.out.print(c[i][j] + " ");
            }
            System.out.println();
        }

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


    public static int findMaxLength(int[] nums) {

        HashMap<Integer, Integer> hm = new HashMap<>();
        hm.put(0, -1);

        int sum = 0;
        int maxLen = 0;

        for(int i = 0; i<nums.length; i++) {
            if(nums[i] == 0) {
                sum += -1;
            } else {
                sum += 1;
            }
            if(hm.containsKey(sum)) {
                // means there are 0s and 1s eqaul to some certain length
                int idx = hm.get(sum);
                int len = i-idx;

                // update maxLen value
                maxLen = Math.max(maxLen, len);
            } else {
                hm.put(sum, i);
            }
        }

        return maxLen;

    }

    // answer 5 starts here

    public static int minimizeProductSum(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int[] pairing = new int[n];
        boolean[] used = new boolean[n];
        int[] minProductSum = { Integer.MAX_VALUE }; // Track the minimum product sum

        // Generate all pairings using backtracking
        generatePairings(nums1, nums2, pairing, used, 0, minProductSum);

        return minProductSum[0];
    }

    public static void generatePairings(int[] nums1, int[] nums2, int[] pairing, boolean[] used, int index, int[] minProductSum) {
        if (index == nums1.length) {
            int productSum = calculateProductSum(nums1, nums2, pairing);
            minProductSum[0] = Math.min(minProductSum[0], productSum);
            return;
        }

        for (int i = 0; i < nums2.length; i++) {
            if (!used[i]) {
                pairing[index] = i;
                used[i] = true;
                generatePairings(nums1, nums2, pairing, used, index + 1, minProductSum);
                used[i] = false;
            }
        }
    }

    public static int calculateProductSum(int[] nums1, int[] nums2, int[] pairing) {
        int productSum = 0;
        for (int i = 0; i < nums1.length; i++) {
            int num1 = nums1[i];
            int num2 = nums2[pairing[i]];
            productSum += (num1 * num2);
        }
        return productSum;
    }

    // answer 5 ends here


    public static int[] findOriginalArray(int[] changed) {

        if(changed.length % 2 != 0) {
            return new int[0];
        }

        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int num: changed) {
            hm.put(num, hm.getOrDefault(num, 0)+1);
        }

        Arrays.sort(changed);
        int[] originalArr = new int[changed.length/2];
        int pass = 0;

        for(int num: changed) {
            if(hm.get(num) > 0) {
                if(hm.containsKey(num*2)) {
                    if(hm.get(num*2) > 0) {
                        // is the freq of num*2 greater than 0, then only num is a valid original
                        originalArr[pass++] = num;
                        // reducing num and num*2's freq by 1 to not repeat things
                        hm.put(num, hm.get(num)-1);
                        hm.put(num*2, hm.get(num*2)-1);
                    } else {
                        return new int[0];
                    }
                } else {
                    return new int[0];
                }
            } 
        }
        return originalArr;
        


    }

    public static int[][] generateMatrix(int n) {

        int[][] matrix = new int[n][n];

        int num = 1; // Current number to fill in the matrix
        int rowStart = 0, rowEnd = n - 1; // Track the boundaries of the rows
        int colStart = 0, colEnd = n - 1; // Track the boundaries of the columns

        while (rowStart <= rowEnd && colStart <= colEnd) {
            // Fill the top row
            for (int col = colStart; col <= colEnd; col++) {
                matrix[rowStart][col] = num++;
            }
            rowStart++;

            // Fill the right column
            for (int row = rowStart; row <= rowEnd; row++) {
                matrix[row][colEnd] = num++;
            }
            colEnd--;

            // Fill the bottom row
            
                for (int col = colEnd; col >= colStart; col--) {
                    matrix[rowEnd][col] = num++;
                }
                rowEnd--;
            

            // Fill the left column
            
                for (int row = rowEnd; row >= rowStart; row--) {
                    matrix[row][colStart] = num++;
                }
                colStart++;
            
        }

        return matrix;

    }


    public static int[][] multiply(int[][] A, int[][] B) {

        //validity check
        int[][] C = new int[A.length][B[0].length];

        for (int i = 0; i < C.length; i++) {
            for (int k = 0; k < A[0].length; k++) {
                if (A[i][k] != 0) { // @note: non-zero check. if zero, then skip since result will be 0
                    for (int j = 0; j < C[0].length; j++) {
                        C[i][j] += A[i][k] * B[k][j];
                    }
                }
            }
        }

        return C;
    }


    
}
