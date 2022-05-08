package com.github4sanjay.dsalgo.dynamic.category5;

/**
 * Given a string, find the longest substring which is palindrome. For example,
 *
 * <p>Input: Given string :"forgeeksskeegfor", Output: "geeksskeeg"
 *
 * <p>Input: Given string :"Geeks", Output: "ee"
 */
public class LongestPalindromicSubstring {

  public static void main(String[] args) {
    System.out.println(LongestPalindromicSubstring.find("forgeeksskeegfor")); // 10
    System.out.println(LongestPalindromicSubstring.find("Geeks")); // 2
  }

  /**
   * highest gap + 1
   *
   * @param str find longest palindromic substrings in this string
   * @return length of longest palindromic substring
   */
  private static int find(String str) {

    boolean[][] dp = new boolean[str.length()][str.length()];
    int maxLength = 0;
    for (int gap = 0; gap < str.length(); gap++) {
      for (int i = 0, j = gap; j < str.length(); j++, i++) {
        if (gap == 0) {
          dp[i][j] = true; // length 1 always palindrome
        } else if (gap == 1) {
          if (str.charAt(i) == str.charAt(j)) {
            dp[i][j] = true; // length 2 always palindrome true
          } else {
            dp[i][j] = false; // length 2 always palindrome false
          }
        } else {
          if (str.charAt(i) == str.charAt(j)) {
            dp[i][j] = dp[i + 1][j - 1];
          } else {
            dp[i][j] = false;
          }
        }

        if (dp[i][j]) {
          maxLength = Math.max(maxLength, gap + 1);
        }
      }
    }
    return maxLength;
  }
}
