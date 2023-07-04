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
  
    
}
