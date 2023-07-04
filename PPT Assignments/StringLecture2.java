
import java.util.*;

public class StringLecture2 {

    public static void main(String[] args) {
        
        /*-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x
        Que 1 - 205. Isomorphic String.
         */

        String s = "foo";
        String t = "bar";

        boolean isMorphic = isIsomorphic(s, t);
        System.out.println("The strings are isomorphic? " + isMorphic);


        /*-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x
        Que 2 - Strobogrammatic Number
         */

         String num = "69";
         boolean isStrobogrammatic = isStrobogrammatic(num);
         System.out.println("Is num Strobogrammatic? " + isStrobogrammatic);


         /*-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x
        Que 3. 415. Add Strings
         */

         String num1 = "123";
         String num2 = "11";

         String addition = addStrings(num1, num2);
         System.out.println("Addition of two strings is: " + addition);


        /*-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x
        Que 4 - 557. Reverse Words in a String III
         */

        String s4  = "Let's take LeetCode contest";
        String reverseS4 = reverseWords(s4);
        System.out.println("Reversed words in a string is: " + reverseS4);


        
        /*-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x
        Que 5. - 541. Reverse String II
         */

        String s5 = "abcdefg";
        int k = 2;

        String reversedS5 = reverseString(s5, k);
        System.out.println("Reversed string in groups is : " + reversedS5);


        /*-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x
        Que 6. - 796. Rotate String
         */

        String s6 = "abcde";
        String goal = "cdeab";

        boolean isRotated = rotateString(s6, goal);
        System.out.println("Is s rotated: " + isRotated);

        
        /*-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x
        Que 7. - 844. Backspace String Compare
         */

        String s = "ab#c";
        String t = "ad#c";

        boolean isSimilar = backspaceCompare(s, t);
        System.out.println("Are S and T similar? " + isSimilar);

        /*-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x
        Que 8. - 1232. Check If It Is a Straight Line
         */

        int[][] coordinates = {{1,2},{2,3},{3,4},{4,5},{5,6},{6,7}};
        boolean isStraighLine = checkStraightLine(coordinates);

        System.out.println("Do these coordinates form a straight line" + isStraighLine);


    }

    public static boolean isIsomorphic(String s, String t) {
        
        HashMap<Character, Character> map1 = new HashMap<>();
        HashMap<Character, Boolean> map2 = new HashMap<>();

        // if any character is already mapped in t, so set it true in map2 and map them both in map1.

        for(int i = 0; i<s.length(); i++) {
            char ch1 = s.charAt(i);
            char ch2 = t.charAt(i);

            if(map1.containsKey(ch1)) {
                if(map1.get(ch1) != ch2) {
                    return false;
                }
            } else {
                if(map2.containsKey(ch2)) {
                    return false;
                } else {
                    map1.put(ch1, ch2);
                    map2.put(ch2, true);
                }
            }
            
        }
        return true;
        

    }

    public static boolean isStrobogrammatic(String num) {
        Map<Character, Character> map = new HashMap<Character, Character>();
        map.put('6', '9');
        map.put('9', '6');
        map.put('0', '0');
        map.put('1', '1');
        map.put('8', '8');
        int l = 0, r = num.length() - 1;
        while (l <= r) {
            if (!map.containsKey(num.charAt(l))) return false;
            if (map.get(num.charAt(l)) != num.charAt(r))
                return false;
            l++;
            r--;
        }
        return true;
    }



    public static String addStrings(String num1, String num2) {
        
        StringBuilder result = new StringBuilder();

        int carry = 0;
        int i = num1.length()-1;
        int j = num2.length()-1;

        while(i >= 0 || j >= 0) {

            int digit1 = 0;
            int digit2 = 0;
            if(i>=0) {
                digit1 = num1.charAt(i) - '0';
            }
            if(j>=0) {
                digit2 = num2.charAt(j) - '0';
            }

            int sum = digit1 + digit2 + carry;
            carry = sum/10;
            sum = sum%10;

            result.append(sum);

            i--;
            j--;

        }

        if(carry != 0) {
            result.append(carry);
        }

        return result.reverse().toString();

    }


    public static String reverseWords(String s) {

        // split the string based on space in an arrya
        String[] arr = s.split(" ");

        // now loop throught this array and on the go reverse each element

        for(int i = 0; i<arr.length; i++) {
            String currentStr = arr[i];
            char[] currArr = currentStr.toCharArray();
            for(int j = 0; j<currArr.length/2; j++) {
                // revese the currArr
                char left = currArr[j];
                currArr[j] = currArr[currArr.length-j-1];
                currArr[currArr.length-j-1] = left;
            }
            arr[i] = new String(currArr);

        }

        String resultStr = String.join(" ", arr);
        return resultStr;
        
    }

    public static String reverseString(String s, int k) {
        char[] charArray = s.toCharArray();
        int i = 0;
        
        while (i < charArray.length) {
            int start = i;
            int end = Math.min(i + k - 1, charArray.length - 1);
            
            while (start < end) {
                char temp = charArray[start];
                charArray[start] = charArray[end];
                charArray[end] = temp;
                start++;
                end--;
            }
            
            i += 2 * k;
        }
        
        return new String(charArray);
    }

    public static boolean rotateString(String s, String goal) {

        if(s.length() != goal.length()) {
            return false;
        }

        // optimized approach

        String concatenated = s + s;
        if(concatenated.contains(goal)) {
            return true;
        }
        return false;

        // brute force approach below
        
        /*
        char[] sArr = s.toCharArray();
        int rotationCount = 0;

        while(rotationCount < sArr.length) {
            // rotate the array 
            for(int i = 0; i<sArr.length-1; i++) {
                char left = sArr[i];
                sArr[i] = sArr[i+1];
                sArr[i+1] = left;
            }
            // now check if after this rotation, is s equal to goal
            String newS = new String(sArr);
            if(newS.equals(goal)) {
                return true;
            }
            rotationCount++;
        }
        return false;
         */

    }

    public static boolean backspaceCompare(String s, String t) {
        
        // processin both the Strings

        LinkedList<Character> sList = processString(s);
        LinkedList<Character> tList = processString(t);

        if(sList.equals(tList)) {
            return true;
        } else {
            return false;
        }

    }

    public static LinkedList<Character> processString(String inputString) {
        LinkedList<Character> list = new LinkedList<>();

        for(int i = 0; i<inputString.length(); i++) {
            if(inputString.charAt(i) != '#') {
                list.add(inputString.charAt(i));
            } else {
                if(list.size() > 0) {
                    list.removeLast();
                }
                
            }
        }

        return list;
    }

    public static boolean checkStraightLine(int[][] coordinates) {
        
        int xDiff = coordinates[1][0] - coordinates[0][0];
        int yDiff = coordinates[1][1] - coordinates[0][1];

        // Check if all other coordinates lie on the same line
        for (int i = 2; i < coordinates.length; i++) {
            int currentXDiff = coordinates[i][0] - coordinates[0][0];
            int currentYDiff = coordinates[i][1] - coordinates[0][1];
    
            // If the current point doesn't have the same slope as the first two points, return false
            if (xDiff * currentYDiff != yDiff * currentXDiff) {
                return false;
            }
        }
    
        // All points have the same slope, so they lie on a straight line
        return true;

    }
    
}
