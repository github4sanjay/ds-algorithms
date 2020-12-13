package dynamic.category5;

import general.FindSubstring;
import general.Palindrome;

/**
 * Given a string, your task is to count how many palindromic substrings in this string.
 * The substrings with different start indexes or end indexes are counted as different substrings even they consist of the same characters.
 *
 * Example 1:
 * Input: "abc"
 * Output: 3
 * Explanation: Three palindromic strings: "a", "b", "c".
 *
 * Example 2:
 * Input: "aaa"
 * Output: 6
 * Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".
 */
public class CountPalindromicSubstrings {

    public static void main(String[] args) {
        System.out.println(CountPalindromicSubstrings.count("abc"));
        System.out.println(CountPalindromicSubstrings.count("aaa"));
        System.out.println(CountPalindromicSubstrings.count("abccbc")); // 9
    }

    /**
     * Brute force approach gives n^2 * n = n^3 time complexity
     *
     * @param str palindromic substrings in this string
     * @return count how many palindromic substrings in this string
     */
    private static int countBruteForce(String str) {
        var list = FindSubstring.find(str);
        int count = 0;
        for (String item : list){
            if (Palindrome.isPalindrome(item)){
                count++;
            }
        }
        return count;
    }

    /**
     *
     * For string "abccbc" matrix will be like this
     *
     *
     *                    -----------> end
     *
     *                  a       b       c       c        b        c
     *   |           |+++++++|+++++++|+++++++|++++++++|++++++++|++++++++|
     *   | s      a  |    a  |   ab  |  abc  |  abcc  | abccb  | abccbc |
     *   | t         |+++++++|+++++++|+++++++|++++++++|++++++++|++++++++|
     *   | a      b  |   x   |    b  |  bc   |   bcc  | bccb   | bccbc  |
     *   | r         |+++++++|+++++++|+++++++|++++++++|++++++++|++++++++|
     *   | t      c  |   x   |   x   |   c   |   cc   |   ccb  | ccbc   |
     *   |           |+++++++|+++++++|+++++++|++++++++|++++++++|++++++++|
     *   V        c  |   x   |   x   |   x   |   c    |   cb   |   cbc  |
     *               |+++++++|+++++++|+++++++|++++++++|++++++++|++++++++|
     *            b  |   x   |   x   |   x   |    x   |   b    |   bc   |
     *               |+++++++|+++++++|+++++++|++++++++|++++++++|++++++++|
     *            c  |   x   |   x   |   x   |   x    |    x   |    b   |
     *               |+++++++|+++++++|+++++++|++++++++|++++++++|++++++++|
     *
     *
     *  if first and last character same then check without prefix and suffix
     *
     * @param str palindromic substrings in this string
     * @return count how many palindromic substrings in this string
     */
    private static int count(String str) {

        boolean[][] dp = new boolean[str.length()][str.length()];
        int count = 0;
        for (int gap=0; gap< str.length(); gap++){
            for (int i=0, j=gap; j < str.length(); j++, i++){
                if (gap == 0){
                    dp[i][j] = true; // length 1 always palindrome
                } else if (gap == 1){
                    if (str.charAt(i) == str.charAt(j)){
                        dp[i][j] = true; // length 2 always palindrome true
                    } else {
                        dp[i][j] = false; // length 2 always palindrome false
                    }
                } else {
                    if (str.charAt(i) == str.charAt(j)){
                        dp[i][j] = dp[i+1][j-1];
                    } else {
                        dp[i][j] = false;
                    }
                }

                if (dp[i][j]){
                    count++;
                }
            }
        }
        return count;
    }

}
