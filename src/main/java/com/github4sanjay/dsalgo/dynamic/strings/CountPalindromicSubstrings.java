package com.github4sanjay.dsalgo.dynamic.strings;

import com.github4sanjay.dsalgo.string.FindSubstring;
import com.github4sanjay.dsalgo.string.Palindrome;

/*
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

  /**
   * Brute force approach gives n^2 * n = n^3 time complexity
   *
   * @param str palindromic substrings in this string
   * @return count how many palindromic substrings in this string
   */
  private static int countBruteForce(String str) {
    var list = FindSubstring.find(str);
    int count = 0;
    for (String item : list) {
      if (Palindrome.isPalindrome(item)) {
        count++;
      }
    }
    return count;
  }

  /*
   * Recursive method:
   * If i and j are the starting and the ending index of the string then,
   *
   * Algorithm:
   *
   * If i>j then no such substring is possible therefore we return 0;
   * If i==j then there is only a single character in the substring and as we know every character is a palindromic substring therefore we return 1;
   * we have a substring from i to j and now we check if the substring is palindrome or not.
   * If the substring from i to j is a palindrome then we increment the number of palindromic substrings by 1 and recursively check for the substrings (i, j-1) and (i+1, j) and remove the common palindrome substring (i+1,j-1).
   * If the substring from i to j is not a palindrome then we recursively check for rest palindromic substrings (i, j-1) and (i+1, j) and remove common palindrome substring (i+1 , j-1).
   *
   */
  public static int recursion(String input) {
    return recursion(0, input.length() - 1, input);
  }

  private static int recursion(int i, int j, String str) {
    if (i > j) {
      return 0;
    }

    if (i == j) {
      return 1;
    }

    if (Palindrome.isPalindrome(str, i, j)) {
      return 1 + recursion(i + 1, j, str) + recursion(i, j - 1, str) - recursion(i + 1, j - 1, str);
    } else {
      return recursion(i + 1, j, str) + recursion(i, j - 1, str) - recursion(i + 1, j - 1, str);
    }
  }

  public static int memoization(String input) {
    var dp = new Integer[input.length()][input.length()];
    dp[0][input.length() - 1] = memoization(0, input.length() - 1, input, dp);
    return dp[0][input.length() - 1];
  }

  private static int memoization(int i, int j, String str, Integer[][] dp) {
    if (i > j) {
      return 0;
    }

    if (i == j) {
      dp[i][j] = 1;
      return dp[i][j];
    }

    if (dp[i][j] != null) {
      return dp[i][j];
    }

    var count =
        memoization(i + 1, j, str, dp)
            + memoization(i, j - 1, str, dp)
            - memoization(i + 1, j - 1, str, dp);
    if (Palindrome.isPalindrome(str, i, j)) {
      count++;
    }
    dp[i][j] = count;
    return dp[i][j];
  }

  public static int tabulation(String input) {
    var dp = new Integer[input.length()][input.length()];
    dp[0][input.length() - 1] = tabulation(input, dp);
    return dp[0][input.length() - 1];
  }

  private static int tabulation(String str, Integer[][] dp) {
    for (int gap = 0; gap < str.length(); gap++) {
      for (int i = 0, j = gap; j < str.length(); i++, j++) {

        if (i - j == 0) {
          dp[i][j] = 1;
          continue;
        }

        if (j - i == 1) {
          if (str.charAt(i) == str.charAt(j)) {
            dp[i][j] = 1 + dp[i + 1][j] + dp[i][j - 1];
          } else {
            dp[i][j] = dp[i + 1][j] + dp[i][j - 1];
          }
          continue;
        }
        var count = dp[i + 1][j] + dp[i][j - 1] - dp[i + 1][j - 1];
        if (Palindrome.isPalindrome(str, i, j)) {
          count++;
        }
        dp[i][j] = count;
      }
    }
    return dp[0][str.length() - 1];
  }

  /*
   * Time complexity = n^2
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
  public static int count(String str) {

    boolean[][] dp = new boolean[str.length()][str.length()];
    int count = 0;
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
          count++;
        }
      }
    }
    return count;
  }
}
