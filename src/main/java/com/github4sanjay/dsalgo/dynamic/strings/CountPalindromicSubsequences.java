package com.github4sanjay.dsalgo.dynamic.strings;

import com.github4sanjay.dsalgo.recurssion.Subsequence;
import com.github4sanjay.dsalgo.string.Palindrome;

/*
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

  /**
   * The naive solution for this problem is to generate all subsequences of the given sequence and
   * check is palindromic subsequence increase count
   *
   * <p>This solution is exponential in term of time complexity.
   *
   * <p>time complexity = n2^n
   *
   * @param str string to find count of palindromic subsequence
   * @return count of palindromic subsequence
   */
  public static int countBruteForce(String str) {
    var list = Subsequence.get(str);
    int count = 0;
    for (var item : list) {
      if (Palindrome.isPalindrome(item)) {
        count++;
      }
    }
    return count;
  }

  /*
   * count(str) -> count(c1mc2)
   * where c1 = prefix, m = middle part, c2= suffix
   *
   * count(c1mc2) = count in subsequence(m)      +
   *                count in c1+subsequence(m)   +
   *                count in subsequence(m)+c2   +
   *                count in c1+subsequence(m)+c2
   * when c1 == c2
   * count(c1mc2) = 1 + count(subsequence(m)) +  count(c1+subsequence(m)) + count(subsequence(m)+c2) + count(subsequence(m))
   *                    _________________________________________________   _______________________________________________
   *              = 1 +  count(subsequence(c1m))                          +     count(subsequence(mc2))
   *
   * when c1 != c2
   * count(c1mc2) = c(m) +  c(c1m) + c(mc2)
   *              = c(m) +  c(c1m) + c(mc2) + c(m) - c(m)
   *              = c(c1m) + c(mc2) - c(m)
   *
   * Important to realise that
   * for a string "c1mc2", prefix is "c1m" and suffix is "mc2"
   *
   *        .    |      a    |     b      |        c     |       c        |       b        |           c
   *    _________|___________|____________|______________|________________|________________|_____________________
   *        a    |    1   (a)|      2 (ab)|         (abc)|          (abcc)|         (abccb)|             (abccbc)
   *    _________|___________|____________|______________|________________|________________|_____________________
   *        b    |      .    |     1   (b)|       2  (bc)|           (bcc)|          (bccb)|              (bccbc)
   *    _________|___________|____________|______________|________________|_____________|__|_____________________
   *        c    |           |            |       1   (c)|     3      (cc)|           (ccb)|               (ccbc)
   *    _________|___________|____________|______________|________________|_____________|__|_____________________
   *        c    |           |            |              |     1       (c)|     2      (cb)|                (cbc)
   *    _________|___________|____________|______________|________________|_____________|__|_____________________
   *        b    |           |            |              |                |     1       (b)|        2        (bc)
   *    _________|___________|____________|______________|________________|_____________|__|_____________________
   *        c    |           |            |              |                |             |  |        1         (c)
   *    _________|___________|____________|______________|________________|_____________|__|_____________________
   *             |           |            |              |                |             |  |
   *                                                                                    |
   *                                                                                    |
   *                         important ------------------------------>for abccb, prefix is abcc and suffix is bccb
   *
   *
   * @param str string to find count of palindromic subsequence
   * @return count of palindromic subsequence
   */
  public static int recursion(String input) {
    return recursion(input, 0, input.length() - 1);
  }

  private static int recursion(String input, int startIndex, int endIndex) {
    if (startIndex > input.length() - 1 || endIndex < 0) {
      return 0;
    }
    if (startIndex == endIndex) {
      return 1;
    }
    var firstChar = input.charAt(startIndex);
    var lastChar = input.charAt(endIndex);
    if (firstChar == lastChar) {
      return 1
          + recursion(input, startIndex, endIndex - 1)
          + recursion(input, startIndex + 1, endIndex);
    } else {
      return recursion(input, startIndex, endIndex - 1)
          + recursion(input, startIndex + 1, endIndex)
          - recursion(input, startIndex + 1, endIndex - 1);
    }
  }

  public static int memoization(String input) {
    var dp = new Integer[input.length()][input.length()];
    dp[0][input.length() - 1] = memoization(input, 0, input.length() - 1, dp);
    return dp[0][input.length() - 1];
  }

  private static int memoization(String input, int startIndex, int endIndex, Integer[][] dp) {
    if (startIndex > input.length() - 1 || endIndex < 0) {
      return 0;
    }
    if (startIndex == endIndex) {
      dp[startIndex][startIndex] = 1;
      return dp[startIndex][startIndex];
    }
    if (dp[startIndex][endIndex] != null) {
      return dp[startIndex][endIndex];
    }
    var firstChar = input.charAt(startIndex);
    var lastChar = input.charAt(endIndex);
    if (firstChar == lastChar) {
      dp[startIndex][endIndex] =
          1
              + memoization(input, startIndex, endIndex - 1, dp)
              + memoization(input, startIndex + 1, endIndex, dp);
    } else {
      dp[startIndex][endIndex] =
          memoization(input, startIndex, endIndex - 1, dp)
              + memoization(input, startIndex + 1, endIndex, dp)
              - memoization(input, startIndex + 1, endIndex - 1, dp);
    }
    return dp[startIndex][endIndex];
  }

  public static int tabular(String input) {
    var dp = new Integer[input.length()][input.length()];
    dp[0][input.length() - 1] = tabular(input, dp);
    return dp[0][input.length() - 1];
  }

  private static int tabular(String input, Integer[][] dp) {
    for (int gap = 0; gap < input.length(); gap++) {
      for (int startIndex = 0, endIndex = gap;
          endIndex < input.length();
          startIndex++, endIndex++) {

        if (startIndex == endIndex) {
          dp[startIndex][endIndex] = 1;
          continue;
        }
        var firstChar = input.charAt(startIndex);
        var lastChar = input.charAt(endIndex);
        if (startIndex + 1 == endIndex) {
          if (firstChar == lastChar) { //  aa -> a, a, aa
            dp[startIndex][endIndex] = 3;
          } else { //  ab -> a, b
            dp[startIndex][endIndex] = 2;
          }
          continue;
        }
        if (firstChar == lastChar) {
          dp[startIndex][endIndex] =
              1 + dp[startIndex][endIndex - 1] + dp[startIndex + 1][endIndex];
        } else {
          dp[startIndex][endIndex] =
              +dp[startIndex][endIndex - 1]
                  + dp[startIndex + 1][endIndex]
                  - dp[startIndex + 1][endIndex - 1];
        }
      }
    }
    return dp[0][input.length() - 1];
  }

  public static int count(String str) {

    int[][] dp = new int[str.length()][str.length()];
    for (int g = 0; g < str.length(); g++) {
      for (int i = 0, j = g; j < str.length(); i++, j++) {
        boolean isEqual = str.charAt(i) == str.charAt(j);
        if (g == 0) {
          dp[i][j] = 1;
        } else if (g == 1) {
          if (isEqual) { //  aa -> a, a, aa
            dp[i][j] = 3;
          } else { //  ab -> a, b
            dp[i][j] = 2;
          }
        } else {
          if (isEqual) {
            dp[i][j] = 1 + dp[i][j - 1] + dp[i + 1][j];
          } else {
            dp[i][j] = dp[i][j - 1] + dp[i + 1][j] - dp[i + 1][j - 1];
          }
        }
      }
    }
    return dp[0][str.length() - 1];
  }
}
