package com.github4sanjay.dsalgo.dynamic.category5;

import com.github4sanjay.dsalgo.recurssion.Subsequence;
import com.github4sanjay.dsalgo.string.Palindrome;

/*
 * Given a sequence, find the length of the longest palindromic subsequence in it.
 *
 * If the given sequence is “BBABCBCAB”, then the output should be 7 as “BABCBAB” is the longest palindromic subsequence in it.
 * “BBBBB” and “BBCBB” are also palindromic subsequences of the given sequence, but not the longest ones.
 */
public class LongestPalindromicSubsequences {

  public static void main(String[] args) {
    System.out.println(LongestPalindromicSubsequences.find("BBABCBCAB")); // 7
    System.out.println(LongestPalindromicSubsequences.find("abcgackbc")); // 5
  }

  /*
   * The naive solution for this problem is to generate all subsequences of the given sequence and
   * find the longest palindromic subsequence.
   *
   * This solution is exponential in term of time complexity.
   * @param str string to find longest palindromic subsequence
   * @return length of longest palindromic subsequence
   */
  private static int findBruteForce(String str) {
    var list = Subsequence.get(str);
    int maxLength = 0;
    for (var item : list) {
      if (Palindrome.isPalindrome(item)) {
        maxLength = Math.max(maxLength, item.length());
      }
    }
    return maxLength;
  }

  /*
   * LPS(s) --> depends of set of sequences set(s)
   *                 _______________
   *                |  _ set(bc) _ |  "", b, c, bc
   *                |  a set(bc) _ |  a, ab, ac, abc
   * set(abcd) ---> |              |
   *                |  _ set(bc) d |  d, bd, cd, bcd
   *                |  a set(bc) d |  ad, abd, acd, abcd
   *                ----------------
   *                  ________________
   *                 |  _ set(m) _   |
   *                 |  c1 set(m) _  |
   * set(c1mc2) ---> |               |
   *                 |  _ set(m) c2  |
   *                 |  c1 set(m) c2 |
   *                 -----------------
   *  where c1 = first character
   *        m = middle part
   *        c2 = last character
   *  when
   *
   *  c1 == c2      |      c1 != c2
   * 2 + LPS(m)     |    max of LPS(c1m) and LPS(mc2)
   *
   * @param str string to find longest palindromic subsequence
   * @return length of longest palindromic subsequence
   */
  private static int find(String str) {
    int[][] dp = new int[str.length()][str.length()];

    for (int g = 0; g < str.length(); g++) {
      for (int i = 0, j = g; j < str.length(); j++, i++) {
        if (g == 0) {
          dp[i][j] = 1;
        } else {
          boolean isCharacterEqual = str.charAt(i) == str.charAt(j);
          if (g == 1) {
            if (isCharacterEqual) {
              dp[i][j] = 2;
            } else {
              dp[i][j] = 1;
            }
          } else {
            if (isCharacterEqual) {
              dp[i][j] = 2 + dp[i + 1][j - 1];
            } else {
              dp[i][j] = Math.max(dp[i][j - 1], dp[i + 1][j]);
            }
          }
        }
      }
    }
    return dp[0][str.length() - 1];
  }
}
