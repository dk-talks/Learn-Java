
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
    
}
