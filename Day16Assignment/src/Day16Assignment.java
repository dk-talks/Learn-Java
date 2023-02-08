import java.util.Arrays;

public class Day16Assignment {
    public static void main(String[] args) {

        // Q.1 - Write a program to remove Duplicates(duplicate characters) from a String.

        // Ans 1 -

       String duplicateString = "Hhellllo tthereee";
       String newString = "";


       for(int i = 0; i<duplicateString.length(); i++) {
           boolean isMached = false;
           if(duplicateString.charAt(i) == ' ') {
               newString = newString + duplicateString.charAt(i);
           } else {
               if(i==0) {
                   newString = newString + duplicateString.charAt(i);
               } else {
                   for(int j = 0; j<newString.length(); j++) {
                       if(Character.toLowerCase(newString.charAt(j)) == Character.toLowerCase(duplicateString.charAt(i))) {
                           isMached = true;
                       }
                   }
                   if(!isMached) {
                       newString = newString + duplicateString.charAt(i);
                   }
               }
           }

       }
       System.out.println("String after removing duplicates: " + newString); // it retuns Helo tr


       /**************************************************************************************************************************************************/
       //************************************************************************************************************************************************* */


//        Q.2 - Write a Program to print Duplicate Characters from the String.

        // Ans -

       String s1 = "Hhellllo tthereee";
       String dupS1 = "";
       int[] alphabels = new int[26];


       s1 = s1.replace(" ", "");
       s1 = s1.toLowerCase();

       for(int i = 0; i<s1.length(); i++) {
           alphabels[s1.charAt(i)-97]++;
       }
       for(int i = 0; i<alphabels.length; i++) {
           if(alphabels[i] > 1) {
               dupS1 = dupS1 + (char) (i+97);
           }
       }

       System.out.println("Duplicates in String are: " + dupS1); // will return 'ehlt'

        /**************************************************************************************************************************************************/
       //************************************************************************************************************************************************* */


        // Q.3 - Write a program to check if "2552" is a palindrome or not.
        // Ans 3 -->

        String str2552 = "2552";
        String str2552Reverse = "";

        for(int i = str2552.length()-1; i>=0; i--) {
            str2552Reverse = str2552Reverse + str2552.charAt(i);
        }
        // not check if reversed string and original string are both equal.

        if(str2552.equals(str2552Reverse)) {
            System.out.println("String is a palindrone");
        } else {
            System.out.println("String is not a palindrone");
        }


         /**************************************************************************************************************************************************/
       //************************************************************************************************************************************************* */




        // Q.4 - WAP to count the number of consonants, vovels and special characters in a string.
        // Ans 4 -->

        String strToCount = "Hello There! This string will be used to count the no. of consonants, vowels, and special chars.";

        // if white spaces is not considered special character, we have to remove it.
        strToCount = strToCount.replace(" ", "");

        
        int consonantsCount = 0;
        int vowelsCount = 0;
        int specialCharacterCount = 0;

        char[] vowels = {'a', 'e', 'i','o','u', 'A', 'E', 'I', 'O', 'U'};

        for(int i = 0; i<strToCount.length(); i++) {
            boolean isVowel = false;
            char currentCharacter = strToCount.charAt(i);

            if(currentCharacter >= 'A' && currentCharacter<= 'Z' || currentCharacter>='a' && currentCharacter<='z') {
                //this means current character is an alphabet.
                for(char vowel: vowels) {
                    if(currentCharacter == vowel) {
                        isVowel = true;
                        vowelsCount++;
                        break;
                        // once vowel is found, no need to further run this nested loop
                    }
                }
                if(!isVowel) {
                    consonantsCount++;
                }   
            } else {
                specialCharacterCount++;
            }
        }

        System.out.println("Vowels count is: " + vowelsCount);
        System.out.println("Consonants count is: " + consonantsCount);
        System.out.println("Special Character count is : " + specialCharacterCount);


         /**************************************************************************************************************************************************/
       //************************************************************************************************************************************************* */


        // Q.5 --> WAP to check if a string is anagram using least inbuilt characters.
        // Ans 5 -->

        String originalStringAnagram = "SchoOl Master";
        String strToCheckAnagram = "The Classroom";

        // removing white spaces.

        originalStringAnagram = originalStringAnagram.replace(" ", "");
        strToCheckAnagram = strToCheckAnagram.replace(" ", "");

        originalStringAnagram = originalStringAnagram.toLowerCase();
        strToCheckAnagram = strToCheckAnagram.toLowerCase();

        // putting strings to an array.
        char[] originalAnagramArray = new char[originalStringAnagram.length()];
        char[] strToCheckArray = new char[strToCheckAnagram.length()];

        for(int i = 0; i<originalStringAnagram.length(); i++) {
            originalAnagramArray[i] = originalStringAnagram.charAt(i);
        }
        for(int i = 0; i<strToCheckAnagram.length(); i++) {
            strToCheckArray[i] = strToCheckAnagram.charAt(i);
        }

        // sorting the array based on the alphabets.

        Arrays.sort(originalAnagramArray);
        Arrays.sort(strToCheckArray);
        boolean flag = false;
        if(originalAnagramArray.length == strToCheckArray.length) {
            
            for(int i = 0; i<originalAnagramArray.length; i++) {
                if(originalAnagramArray[i] != strToCheckArray[i]) {
                    flag = true;    // if at any point corrosponding vlaues of both values dont match, cosider it not anagram.
                    System.out.println("The given strings are not Anagrams.");
                    break;
                }
            }
        } else {
            flag = true;
            System.out.println("The given strings are not anagram");
        }

        if(!flag) {
            System.out.println("The given strings are Anagrams!");
        }


         /**************************************************************************************************************************************************/
       //************************************************************************************************************************************************* */



        // Q.6 --> WAP to implement pangram checking with least inbuilt methods being used.

        // Ans 6 -

        String strForPangram = "The quick brown fox jumps over lazy dog.";
            
        strForPangram = strForPangram.toLowerCase();
        int[] alphabetsForPangram = new int[26];
        boolean isPangram = true;

        for(int i = 0; i<strForPangram.length(); i++) {
            char cc = strForPangram.charAt(i);
            if(cc >= 'a' && cc <= 'z') {
                alphabetsForPangram[cc - 97]++;
                // increase value of value at index number by one. example - if char is 'b' so 98-97 is 1, so at index 1.
            }
        }
        for(int i: alphabetsForPangram) {
            if(i == 0) {
                System.out.println("The given String is not a Pangram:");
                isPangram = false;
                break;
            }
        }
        if(isPangram) {
            System.out.println("The given string is a Pangram.");
        }

         /**************************************************************************************************************************************************/
       //************************************************************************************************************************************************* */



        // Q. 7 --> WAP to find if String contains all unique characters.

        // Ans - 

        String strToCheckUnique = "Hey bud!";
            
        strToCheckUnique = strToCheckUnique.toLowerCase();
        int[] alphabetsToCheckUnique = new int[26];
        boolean isUnique = true;

        for(int i = 0; i<strToCheckUnique.length(); i++) {
            char cc = strToCheckUnique.charAt(i);
            if(cc >= 'a' && cc <= 'z') {
                alphabetsToCheckUnique[cc - 97]++;
                // increase value of value at index number by one. example - if char is 'b' so 98-97 is 1, so at index 1.
            }
        }
        for(int i: alphabetsToCheckUnique) {
            if(i > 1) {
                System.out.println("The given String is not Unique!");
                isUnique = false;
                break;
            }
        }
        if(isUnique) {
            System.out.println("The given string is Unique!");
        }


         /**************************************************************************************************************************************************/
       //************************************************************************************************************************************************* */



        // Q. 8 --> WAP to find the maximum occurring character in a String.
        // Ans 8 =

        String strToCheckMax = "Hey bud! String to check maximum occuring String.zzzz";
            
        strToCheckMax = strToCheckMax.toLowerCase();
        int[] alphabetsToCheckMax = new int[26];

        for(int i = 0; i<strToCheckMax.length(); i++) {
            char cc = strToCheckMax.charAt(i);
            if(cc >= 'a' && cc <= 'z') {
                alphabetsToCheckMax[cc - 97]++;
                // increase value of value at index number by one. example - if char is 'b' so 98-97 is 1, so at index 1.
            }
        }
        int max = 0;

        for(int i = 0; i<alphabetsToCheckMax.length; i++) {
            if(max < alphabetsToCheckMax[i]) {
                max = alphabetsToCheckMax[i];
            }
        }


        String maxOccuringCharacters = "";

        for(int i = 0; i<alphabetsToCheckMax.length; i++) {
            if(alphabetsToCheckMax[i] == max) {
                maxOccuringCharacters = maxOccuringCharacters + (char) (i+97) + ", ";
            }
        }
        if(max == 0) {
            System.out.println("String is empty!");
        } else {
            if(maxOccuringCharacters.length() > 3) {
                System.out.println("Maximum Occuring Characters are: " + maxOccuringCharacters + " and occured " + max + " times!");
            } else {
                System.out.println("Maximum Occuring Character is: " + maxOccuringCharacters + " and occured " + max + " times!");
            }
        }

    }
}
