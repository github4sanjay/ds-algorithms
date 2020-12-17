package dynamic.category7;

import util.AlgoUtil;

/**
 * Given an input string (s) and a pattern (p), implement regular expression matching with support for '.' and '*' where:
 *
 * '.' Matches any single character.
 * '*' Matches zero or more of the preceding element.
 * The matching should cover the entire input string (not partial).
 *
 *
 *
 * Example 1:
 *
 * Input: s = "aa", p = "a"
 * Output: false
 * Explanation: "a" does not match the entire string "aa".
 * Example 2:
 *
 * Input: s = "aa", p = "a*"
 * Output: true
 * Explanation: '*' means zero or more of the preceding element, 'a'. Therefore, by repeating 'a' once, it becomes "aa".
 * Example 3:
 *
 * Input: s = "ab", p = ".*"
 * Output: true
 * Explanation: ".*" means "zero or more (*) of any character (.)".
 * Example 4:
 *
 * Input: s = "aab", p = "c*a*b"
 * Output: true
 * Explanation: c can be repeated 0 times, a can be repeated 1 time. Therefore, it matches "aab".
 * Example 5:
 *
 * Input: s = "mississippi", p = "mis*is*p*."
 * Output: false
 *
 *
 * Constraints:
 *
 * 0 <= s.length <= 20
 * 0 <= p.length <= 30
 * s contains only lowercase English letters.
 * p contains only lowercase English letters, '.', and '*'.
 * It is guaranteed for each appearance of the character '*', there will be a previous valid character to match.
 *
 */
public class RegularExpressionMatching {

    public static void main(String[] args) {
        System.out.println(RegularExpressionMatching.find("mississippi", "mis*is*p*.")); // false
        System.out.println(RegularExpressionMatching.find("aab", "c*a*b")); // true
        System.out.println(RegularExpressionMatching.find("aa", "a")); // false
        System.out.println(RegularExpressionMatching.find("aa", "a*")); // true
        System.out.println(RegularExpressionMatching.find("ab", ".*")); // true
        System.out.println(RegularExpressionMatching.find("mississippi", "mis*i.*p*i")); // true

    }

    /**
     * Input: s = "mississippi", p = "mis*is*p*."
     *
     *             | _   |   m  | i    | s   |  s   |   i  |    s  |    s  |      i |     p |      p |      i |
     *          ___|_____|______|______|_____|______|______|_______|_______|________|_______|________|________|_
     *          _  |  Y  |  N   |  N   |  N  |  N   |   N  |  N    |  N    |   N    |  N    |    N   |   N    |
     *          ___|_____|______|______|_____|______|______|_______|_______|________|_______|________|________|_
     *          m  | N   |   Y  |  N   |  N  |  N   |  N   |   N   |  N    |   N    |   N   |  N     |  N     |
     *          ___|_____|______|______|_____|______|______|_______|_______|________|_______|________|________|_
     *          i  | N   |  N   |  Y   | N   |  N   | N    |  N    |  N    |    N   |   N   |   N    |   N    |
     *          ___|_____|______|______|_____|______|______|_______|_______|________|_______|________|________|_
     *          s  | N   |  N   | N    | Y   |  N   |  N   |  N    |  N    |  N     |  N    |    N   |  N     |
     *          ___|_____|______|______|_____|______|______|_______|_______|________|_______|________|________|_
     *          *  | N   |   N  |  Y<--|--Y--|------|------|-------|-------|--------|-------|--------|--------|------- Here need to compare
     *          ___|_____|______|______|__|__|______|______|_______|_______|________|_______|________|________|_           mi and mis*
     *          i  | N   |      |      |  |  |      |      |       |       |        |       |        |        |         if s* becomes blank
     *          ___|_____|______|______|__|__|______|______|_______|_______|________|_______|________|________|_           then dp[i-2][j]
     *          s  | N   |      |      |  |  |      |      |       |       |        |       |        |        |
     *          ___|_____|______|______|__|__|______|______|_______|_______|________|_______|________|________|_
     *          *  | N   |      |      |  |  |      |      |       |       |        |       |        |        |
     *          ___|_____|______|______|__|__|______|______|_______|_______|________|_______|________|________|_
     *          p  | N   |      |      |  |  |      |      |       |       |        |       |        |        |
     *          ___|_____|______|______|__|__|______|______|_______|_______|________|_______|________|________|_
     *          *  | N   |      |      |  |  |      |      |       |       |        |       |        |        |
     *          ___|_____|______|______|__|__|______|______|_______|_______|________|_______|________|________|_
     *          .  |     |      |      |  |  |      |      |       |       |        |       |        |        |
     *          ___|_____|______|______|__|__|______|______|_______|_______|________|_______|________|________|_
     *                                    |
     *                                    |
     *                              here mis and mis*
     *                              mis and mis[s*] when s* give 1 s
     *                              remove s from both then ------------> character should be same in expression and string
     *                              mi and mi[s*] then dp[i][j-1]               or
     *                                                                   character is . in expression
     *
     *
     *     1. when patter character is other than * and .
     *          a. when its not equal to string character dp[i][j] = false
     *          b. when its equal then check in previous pattern and string dp[i][j] = dp[i-1][j-1]
     *     2. when character is .
     *          since . can match any single character so if we assume it matches str.charAt(j)
     *          then check in previous pattern and string dp[i][j] = dp[i-1][j-1]
     *     3. when character is *
     *                ___________________________
     *          take | mis* -> mi, mis, miss.....|    dp[i][j] = dp[i-2][j]
     *               |            or             |           or
     *               |          mi, miss*        |    dp[i][j] = dp[i][j-1]
     *               |___________________________|
     *
     */
    private static boolean find(String str, String pattern) {
        boolean[][] dp =  new boolean[pattern.length()+1][str.length()+1];
        for (int i=0; i< dp.length; i++){
            for (int j=0; j< dp[0].length; j++){
                if (i==0 && j==0){
                    dp[i][j] = true; // blank expression can match blank string
                } else if (i == 0){
                    dp[i][j] = false; // blank expression cannot match any other string
                } else if (j == 0){
                    if (i-2 >=0 && pattern.charAt(i-1) == '*'){
                        dp[i][j] = dp[i-2][j]; // if first column then just check two row before
                    } else {
                        dp[i][j] = false;
                    }
                } else {
                    if (pattern.charAt(i-1) == '*') {
                        if (dp[i-2][j]){  // note i-2 as need to check with previous character
                            dp[i][j] = true;
                        } else if (pattern.charAt(i-2) == str.charAt(j-1) || pattern.charAt(i-2) == '.'){
                            dp[i][j] = dp[i][j-1];
                        }
                    } else if (pattern.charAt(i-1) == '.') {
                        dp[i][j] =  dp[i-1][j-1];
                    } else {
                        if (pattern.charAt(i-1) == str.charAt(j-1)){
                            dp[i][j] =  dp[i-1][j-1];
                        } else {
                            dp[i][j] =  false;
                        }
                    }
                }
            }
        }

        return dp[pattern.length()][str.length()];
    }
}
