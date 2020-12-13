package dynamic.category5;

import general.Palindrome;
import recurssion.Subsequence;

/**
 * Find how many palindromic subsequences (need not necessarily be distinct) can be formed in a given string.
 * Note that the empty string is not considered as a palindrome.
 * Examples:
 *
 * Input : str = "abcd"
 * Output : 4
 * Explanation :- palindromic  subsequence are : "a" ,"b", "c" ,"d"
 *
 * Input : str = "aab"
 * Output : 4
 * Explanation :- palindromic subsequence are :"a", "a", "b", "aa"
 *
 * Input : str = "aaaa"
 * Output : 15
 */
public class CountPalindromicSubsequences {

    public static void main(String[] args) {
        System.out.println("Length of LCS is" + " " + CountPalindromicSubsequences.count( "abcd" ) );
        System.out.println("Length of LCS is" + " " + CountPalindromicSubsequences.count( "aab") );
        System.out.println("Length of LCS is" + " " + CountPalindromicSubsequences.count( "aaaa") );
    }

    /**
     * The naive solution for this problem is to generate all subsequences of the given sequence and
     * check is palindromic subsequence increase count
     *
     * This solution is exponential in term of time complexity.
     * @param str string to find count of  palindromic subsequence
     * @return count of palindromic subsequence
     */
    private static int countBruteForce(String str) {
        var list = Subsequence.get(str);
        int count = 0;
        for (var item : list){
            if (Palindrome.isPalindrome(item)){
                count++;
            }
        }
        return count;
    }

    /**
     * count(str) -> count(c1mc2)
     * where c1 = prefix, m = middle part, c2= suffix
     *
     * count(c1mc2) = count in subsequence(m)     +
     *                count in subsequence(c1m)   +
     *                count in subsequence(mc2)   +
     *                count in subsequence(c1mc2)
     * when c1 == c2
     * count(c1mc2) = 1 + c(m) +  c(c1m) + c(mc2) + c(m)
     *              = 1 + c(c1m) + c(mc2)
     *
     * when c1 != c2
     * count(c1mc2) = c(m) +  c(c1m) + c(mc2)
     *              = c(m) +  c(c1m) + c(mc2) + c(m) - c(m)
     *              = c(c1m) + c(mc2) - c(m)
     *
     * @param str string to find count of palindromic subsequence
     * @return count of palindromic subsequence
     */
    private static int count(String str) {

        int[][] dp = new int[str.length()][str.length()];
        for (int g=0; g < str.length(); g++){
            for (int i=0, j=g; j< str.length(); i++, j++){
                boolean isEqual = str.charAt(i) == str.charAt(j);
                if (g == 0){
                    dp[i][j] = 1;
                } else if (g == 1){
                    if (isEqual){ //  aa -> a, a, aa
                        dp[i][j] = 3;
                    } else { //  ab -> a, b
                        dp[i][j] = 2;
                    }
                } else {
                    if (isEqual){
                        dp[i][j] = 1 + dp[i][j-1] + dp[i+1][j];
                    } else {
                        dp[i][j] = dp[i][j-1] + dp[i+1][j] - dp[i+1][j-1];
                    }
                }
            }
        }
        return dp[0][str.length()-1];
    }
}
