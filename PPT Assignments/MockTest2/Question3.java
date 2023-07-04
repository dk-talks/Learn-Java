public class Question3 {

    public static void main(String[] args) {
        
        // while loop experiment

        //  Write a Java program to calculate the average of a list of numbers using a do-while loop.

        int[] nums = {10, 8, 10};

        // average of all the numbers using a do-while loop
        int index = 0;
        int sum = 0;
        do {
            sum += nums[index];
            index++;
        } while(index < nums.length);

        int average = sum/nums.length;
        System.out.println("The average of nums is: " + average);


    }
    
}
