public class RecursionLecture8 {

    public static void main(String[] args) {
        
       

      

    }

     // Answer 1 - 

    public int minimumDeleteSum(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();

        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            dp[i][0] = dp[i - 1][0] + s1.charAt(i - 1);
        }

        for (int j = 1; j <= n; j++) {
            dp[0][j] = dp[0][j - 1] + s2.charAt(j - 1);
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j] + s1.charAt(i - 1), dp[i][j - 1] + s2.charAt(j - 1));
                }
            }
        }

        return dp[m][n];
    }


  /// Answer 2 


  public boolean checkValidString(String s) {
        Stack<Integer> leftStack = new Stack<>();
        Stack<Integer> asteriskStack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                leftStack.push(i);
            } else if (c == '*') {
                asteriskStack.push(i);
            } else {
                if (!leftStack.isEmpty()) {
                    leftStack.pop();
                } else if (!asteriskStack.isEmpty()) {
                    asteriskStack.pop();
                } else {
                    return false;
                }
            }
        }

        while (!leftStack.isEmpty() && !asteriskStack.isEmpty()) {
            int leftIndex = leftStack.pop();
            int asteriskIndex = asteriskStack.pop();
            if (leftIndex > asteriskIndex) {
                return false;
            }
        }

        return leftStack.isEmpty();
    }


  // Answer 3 

  public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = i + j;
                } else if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 1 + Math.min(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[m][n];
    }


  // Answer 4 


  public TreeNode str2tree(String s) {
        if (s.isEmpty()) {
            return null;
        }

        // Find the value of the root node
        int firstParenthesisIndex = s.indexOf('(');
        int rootValue = firstParenthesisIndex == -1 ? Integer.parseInt(s) : Integer.parseInt(s.substring(0, firstParenthesisIndex));

        // Create the root node
        TreeNode root = new TreeNode(rootValue);

        if (firstParenthesisIndex == -1) {
            // The string only contains the root value
            return root;
        }

        int openParenthesisCount = 0;
        int substringStartIndex = firstParenthesisIndex;

        // Find the substring for the left child
        for (int i = firstParenthesisIndex; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                openParenthesisCount++;
            } else if (s.charAt(i) == ')') {
                openParenthesisCount--;
            }

            if (openParenthesisCount == 0 && substringStartIndex == firstParenthesisIndex) {
                // Found the substring for the left child
                root.left = str2tree(s.substring(firstParenthesisIndex + 1, i));
                substringStartIndex = i + 1;
            }
        }

        if (substringStartIndex < s.length() - 1) {
            // There is a substring for the right child
            root.right = str2tree(s.substring(substringStartIndex + 1, s.length() - 1));
        }

        return root;
    }


  /// Answer 5 

  public int compress(char[] chars) {
        int n = chars.length;
        int compressedIndex = 0;
        int i = 0;

        while (i < n) {
            char currentChar = chars[i];
            int count = 0;

            // Count the consecutive repeating characters
            while (i < n && chars[i] == currentChar) {
                i++;
                count++;
            }

            // Append the current character to the compressed string
            chars[compressedIndex++] = currentChar;

            if (count > 1) {
                // Append the count as characters to the compressed string
                String countString = String.valueOf(count);
                for (char c : countString.toCharArray()) {
                    chars[compressedIndex++] = c;
                }
            }
        }

        return compressedIndex;
    }


    // Answer 6 

    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();

        if (s == null || p == null || s.length() < p.length())
            return result;

        // Create a frequency map of characters in p
        Map<Character, Integer> pMap = new HashMap<>();
        for (char ch : p.toCharArray()) {
            pMap.put(ch, pMap.getOrDefault(ch, 0) + 1);
        }

        int left = 0;
        int right = 0;
        int count = pMap.size();

        while (right < s.length()) {
            char ch = s.charAt(right);

            // Expand the window by moving the right pointer
            if (pMap.containsKey(ch)) {
                pMap.put(ch, pMap.get(ch) - 1);
                if (pMap.get(ch) == 0)
                    count--;
            }
            right++;

            // Shrink the window if it's valid
            while (count == 0) {
                char leftChar = s.charAt(left);

                // Check if an anagram is found
                if (pMap.containsKey(leftChar)) {
                    pMap.put(leftChar, pMap.get(leftChar) + 1);
                    if (pMap.get(leftChar) > 0)
                        count++;
                }

                // Update the result if the window length matches p's length
                if (right - left == p.length())
                    result.add(left);

                left++;
            }
        }

        return result;
    }



    // Answr 7

    public static String decodeString(String s) {
        Stack<Integer> countStack = new Stack<>();
        Stack<String> stringStack = new Stack<>();
        StringBuilder currentString = new StringBuilder();
        int count = 0;

        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                count = count * 10 + (ch - '0');
            } else if (ch == '[') {
                countStack.push(count);
                stringStack.push(currentString.toString());
                currentString = new StringBuilder();
                count = 0;
            } else if (ch == ']') {
                StringBuilder temp = new StringBuilder(stringStack.pop());
                int repeatTimes = countStack.pop();
                for (int i = 0; i < repeatTimes; i++) {
                    temp.append(currentString);
                }
                currentString = temp;
            } else {
                currentString.append(ch);
            }
        }

        return currentString.toString();
    }

    // Answr 8 -

    public static boolean areAlmostEqual(String s, String goal) {
        if (s.equals(goal))
            return true;

        int n = s.length();
        int[] freq = new int[26];
        int count = 0;

        for (int i = 0; i < n; i++) {
            freq[s.charAt(i) - 'a']++;
            freq[goal.charAt(i) - 'a']--;
            if (s.charAt(i) != goal.charAt(i))
                count++;
        }

        if (count != 2)
            return false;

        for (int f : freq) {
            if (f != 0)
                return false;
        }

        return true;
    }
  
    
}
