package dynamic.category7;

/**
 * Wildcard Pattern Matching
 * Last Updated: 23-10-2020
 * Given a text and a wildcard pattern, implement wildcard pattern matching algorithm that finds
 * if wildcard pattern is matched with text. The matching should cover the entire text (not partial text).
 * The wildcard pattern can include the characters ‘?’ and ‘*’
 * ‘?’ – matches any single character
 * ‘*’ – Matches any sequence of characters (including the empty sequence)
 *
 * For example,
 *
 * Text = "baaabab",
 * Pattern = “*****ba*****ab", output : true
 * Pattern = "baaa?ab", output : true
 * Pattern = "ba*a?", output : true
 * Pattern = "a*ab", output : false
 */
public class WildCardPatternMatching {

    public static void main(String[] args) {
        // System.out.println(WildCardPatternMatching.find("baaabab", "ba*a?"));
        System.out.println(WildCardPatternMatching.find("baaabab", "baaa?ab"));
    }

    /**
     *Case 1: The character is ‘*’
     *   Here two cases arise
     *    1. We can ignore ‘*’ character and move to next character in the Pattern.
     *    2. ‘*’ character matches with one or more characters in Text. Here we will move to next character in the string.
     *
     * Case 2: The character is ‘?’
     *  We can ignore current character in Text and move to next character in the Pattern and Text.
     *
     * Case 3: The character is not a wildcard character
     *   If current character in Text matches with current character in Pattern, we move to next character in the Pattern and Text.
     *   If they do not match, wildcard pattern and Text do not match.
     *
     *
     * We can use Dynamic Programming to solve this problem –
     *  row(i)-> patterns
     *  col(j)-> given string
     *  Let dp[i][j] is true if last dp[0].length - j characters in given string matches the last dp.length - i characters of pattern.
     *
     *  cases:
     *  1. when pattern character is non wild card:
     *      a. if pattern character matches with string character then dp[i][j] = dp[i+1][j+1]
     *      b. if not equal then dp[i][j] = false
     *  2. when pattern character is ? :
     *      then dp[i][j] = dp[i+1][j+1]
     *  3. when pattern character is * :
     *      a. if we take * as blank then dp[i][j] = dp[i+1][j]
     *      b. if we take 1 character from given string then dp[i][j] = dp[i+1][j+1]
     *      c. if we take 2 character from given string then dp[i][j] = dp[i+1][j+2]
     *      so similarly till all columns
     *      dp[i][j] is true if any of dp[i+1][j+k] where k=0 to dp[0].length-j is true
     *      else false
     *
     * Important we can also solve like this when * taken and when start not taken
     * this will solve the question in n^2 complexity.
     *
     *         | b   |  a   |   a   |   a   |   b   |    a  |     b  |    _   |
     *      ___|_____|______|_______|_______|_______|_______|________|________|_
     *      b  |     |      |       |       |       |       |        |  false |
     *      ___|_____|______|_______|_______|_______|_______|________|________|_
     *      a  |     |      |       |       |       |       |        |  false |
     *      ___|_____|______|_______|_______|_______|_______|________|________|_
     *      *  |     |      |       |       |       |       |        | false  |
     *      ___|_____|______|_______|_______|_______|_______|________|________|_
     *      a  |     |      |       |       |       |       |        | false  |
     *      ___|_____|______|_______|_______|_______|_______|________|________|_
     *      ?  |     |      |       |       |       |       |        |  false |
     *      ___|_____|______|_______|_______|_______|_______|________|________|_
     *      -  |false| false|  false| false |false  | false |  false |  true  |
     *      ___|_____|______|_______|_______|_______|_______|________|________|_
     */
    private static boolean find(String str, String pattern) {
        boolean[][] dp = new boolean[pattern.length()+1][str.length()+1];
        for (int i=dp.length-1; i >= 0; i--){
            for (int j=dp[0].length-1; j >=0; j--){
                if (i == dp.length-1 && j == dp[0].length-1){
                    dp[i][j] = true;
                } else if (i==dp.length-1){
                    dp[i][j] = false;
                } else if (j==dp[0].length-1){
                    if (pattern.charAt(i) == '*'){
                       dp[i][j] =  dp[i-1][j];
                    } else {
                        dp[i][j] =  false;
                    }
                } else {
                    if (pattern.charAt(i) == '*') {
                        // boolean foundInPreviousRow = whenStar(dp, dp[i + 1], j);
                        //          when * taken     when * not taken
                        dp[i][j] =  dp[i][j+1]   ||     dp[i+1][j];
                    } else if (pattern.charAt(i) == '?') {
                        dp[i][j] =  dp[i+1][j+1];
                    } else {
                        if (pattern.charAt(i) == str.charAt(j)){
                            dp[i][j] =  dp[i+1][j+1];
                        } else {
                            dp[i][j] =  false;
                        }
                    }
                }
            }
        }
        return dp[0][0];
    }

    /**
     * a. if we take * as blank then dp[i][j] = dp[i+1][j]
     * b. if we take 1 character from given string then dp[i][j] = dp[i+1][j+1]
     * c. if we take 2 character from given string then dp[i][j] = dp[i+1][j+2]
     * so similarly till all columns
     *
     * this makes it n^3 time complexity
     */
    private static boolean whenStar(boolean[][] dp, boolean[] booleans, int j) {
        boolean foundInPreviousRow = false;
        for (int k=0; k< dp[0].length-j; k++){
           if (booleans[j+k]){
               foundInPreviousRow = true;
               break;
           }
        }
        return foundInPreviousRow;
    }
}
