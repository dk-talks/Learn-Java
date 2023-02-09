import java.util.Arrays;

class Day17Assignment {

    public static void main(String[] args) {
        
        /*
        Q.1 What is Mutable String in Java. Explain with example.
        Ans -

        Mutable Strings in java are those string objects which can be modified in future.
        They are created using either StringBuffer or StringBuilder.
        Example - 
         */
        StringBuilder sb = new StringBuilder("Hello");
        // trying to modify the same object
        sb.append(" There!");
        System.out.println(sb); // this will print "Hello World!, that means this string is mutable"

        /**************************************************************************************************************************************************/
       //************************************************************************************************************************************************* */

       /*
        
        Q. 2 - Write a program to reverse a string.

        */
        StringBuffer sb1 = new StringBuffer("PW Skills");
        sb1.reverse(); // this will reverse the original string object.
        System.out.println(sb1);
        
        /**************************************************************************************************************************************************/
       //************************************************************************************************************************************************* */

       /*
        
       Q.3 --> Write a program to reverse a sentence while preserving the position.

        */

        String sb2 = "Think Twice";
        String[] sb2Arr = sb2.split(" ");
        StringBuffer sb2Reversed = new StringBuffer();

        for(String s: sb2Arr) {

            // loop through each word in sb2Array
            for(int i = s.length()-1; i>=0; i--) {
                // now reversing each character and appending to our reversed stringBuffer.
                sb2Reversed.append(s.charAt(i));
            }
            // after every word, giving a space.
            sb2Reversed.append(" ");
        }
        System.out.println(sb2Reversed);

        /**************************************************************************************************************************************************/
       //************************************************************************************************************************************************* */

       /*
       
       Q.4 --> Write a program to sort a string alphabetically.

        */

        String s3 = "sortiing";
        String[] s3Arr = s3.split("");
        StringBuffer sortedS3 = new StringBuffer();

        Arrays.sort(s3Arr);

        for(String s: s3Arr) {
            sortedS3.append(s);
        }
        System.out.println(sortedS3);

        // You can run the entire code to print the results. THANK YOU.
    }
    
}
