public class Sorting1 {
    
    public static void main(String[] args) {
        

        /*
         Que.1 - Write a program to sort an array in descending order using bubble sort.
         */

         int arr1[] = {4,7,90,100,123,3,4,500,1,0};
         
         for(int i = 0; i<arr1.length; i++) {
            boolean isSwapped = false;
            for(int j = 0; j<arr1.length-i-1; j++) {
                if(arr1[j] < arr1[j+1]) {
                    // need to swap
                    int temp = arr1[j];
                    arr1[j] = arr1[j+1];
                    arr1[j+1] = temp;
                    isSwapped = true;
                }
            }
            if(!isSwapped) {
                //alread sorted
                break;
            }
        }

        // printing the sorted array in descending order now;
        for(int num: arr1) {
            System.out.print(num + ", ");
        }
        System.out.println();

        /*
        Q2. WAP to sort an array in descending order using selection sort
         */

        int arr2[] = {4,7,90,100,123,3,4,500,1,0};

        // selection sort - there will be two part of array, 1-sorted and unsorted
        // as we traverse through the array, sorted array keep on increasing from the left and unsorted array keep on decreasing
        // as described in Jenny's lecture

        for(int i = 0; i<arr2.length-1; i++) {
            int biggestElementIndex = i;
            for(int j = i+1; j<arr2.length; j++) {
                if(arr2[j] > arr2[biggestElementIndex]) {
                    biggestElementIndex = j;
                }
            }
            if(arr2[i] != arr2[biggestElementIndex]) {
                int temp = arr2[i];
                arr2[i] = arr2[biggestElementIndex];
                arr2[biggestElementIndex] = temp;
            }
        }
        // printing the array if it is sorted or not
        for(int num: arr2) {
            System.out.print(num + ", ");
        }
        System.out.println();



        /*
         Q3. WAP to sort an array in decreasing order using insertion sort
         */

         int[] arr3 = {7,12,3,4,1};

         /*
          assume arr[0] is a sorted element already, we will start from the first index
          and check if any of its previous element is larger that this, if so we will swap both of them.
         i.e at every iteration our left side of array will be sorted which ever numbers they have, but overall it is not sorted
          meaning- there can be another element that can come to this sorted array.
          Intermediate result of Insertion sort is not useful
        */

        for(int i = 1; i<arr3.length; i++) {
            // start from one, asuming 0th element is already sorted
            int temp = arr3[i];
            int j = i-1;
            while(j>=0 && arr3[j] < temp) {
                arr3[j+1] = arr3[j];
                j--;
            }

            arr3[j+1] = temp;
            
            
        }

        for(int num: arr3) {
            System.out.print(num + ", ");
        }
        System.out.println();


        /*
         Q4. Find out how many pass would be required to sort the following array in decreasing order
        using bubble sort
         */

        int arr4[] = {30,20,10,30,5};
        int numberOfPasses = 0;
        for(int i = 0; i<arr4.length;i++) {
            boolean isSwapped1 = false;
            for(int j = 0; j<arr4.length-1;j++) {
                if(arr4[j]<arr4[j+1]) {
                    int temp = arr4[j];
                    arr4[j] = arr4[j+1];
                    arr4[j+1] = temp;
                    isSwapped1 = true;
                }
            }
            numberOfPasses += 1;
            if(!isSwapped1) {
                break;
            }
        }
        for(int num: arr4) {
            System.out.print(num + ", ");
        }
        System.out.println();
        System.out.println("Number of passes required is: " + numberOfPasses);


        /*
         Q5. Find out the number of iterations to sort the array in descending order using selection sort.

         Ans - Number of iterations will be length-1 iterations.
         It does not matter array is already sorted or not, It only selects the smallest element and swap it with the length-i index.
         So if the number of elements in array are 5, So iterations will be 4.
         */

         



         
         

    }

}
