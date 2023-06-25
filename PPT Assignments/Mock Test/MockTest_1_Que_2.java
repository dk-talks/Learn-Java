import java.util.HashMap;

public class MockTest1 {
    
    public static void main(String[] args) {

      // Que - 2 First Unique Character in a string

        String s = "LoveLeetCode";
        int index = findUniqueCharacter(s);

        if(index == -1) {
            System.out.println("There is no unique character in string");
        } else {
            System.out.println("Unique character is at index: " + index + " and character is: " + s.charAt(index));
        }
      
  }

  public static int findUniqueCharacter(String s) {
        // we will use HashMap to store the frequencies of every character and will check if any character has 1 frequency, otherwise return -1
        // key will be character itself, and value will be the frequency of each character
        HashMap<Character, Integer> freq = new HashMap<>();

        for(char c: s.toCharArray()) {
            // this will update the frequency to +1 if it exists or not
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }

        for(int i = 0; i<s.length(); i++) {
            if(freq.get(s.charAt(i)) == 1) {
                return i;
            }
        }
        // if code flow reaches here, that means there is no unique character, so return -1
        return -1;

        

    }

  
}
