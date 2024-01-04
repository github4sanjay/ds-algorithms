package com.github4sanjay.dsalgo.dynamic.strings;

/*
 * Given two strings word1 and word2, return the minimum number of operations required to convert word1 to word2.
 *
 * You have the following three operations permitted on a word:
 *
 * Insert a character
 * Delete a character
 * Replace a character
 *
 *
 * Example 1:
 *
 * Input: word1 = "horse", word2 = "ros"
 * Output: 3
 * Explanation:
 * horse -> rorse (replace 'h' with 'r')
 * rorse -> rose (remove 'r')
 * rose -> ros (remove 'e')
 * Example 2:
 *
 * Input: word1 = "intention", word2 = "execution"
 * Output: 5
 * Explanation:
 * intention -> inention (remove 't')
 * inention -> enention (replace 'i' with 'e')
 * enention -> exention (replace 'n' with 'x')
 * exention -> exection (replace 'n' with 'c')
 * exection -> execution (insert 'u')
 */
public class EditDistance {

  public static int recursion(String word1, String word2) {
    return recursion(word1, word2, word1.length() - 1, word2.length() - 1);
  }

  private static int recursion(String word1, String word2, int i, int j) {
    if (i < 0) {
      return j + 1;
    }
    if (j < 0) {
      return i + 1;
    }

    if (word1.charAt(i) == word2.charAt(j)) {
      return recursion(word1, word2, i - 1, j - 1);
    }
    return 1
        + Math.min(
            recursion(word1, word2, i - 1, j),
            Math.min(recursion(word1, word2, i, j - 1), recursion(word1, word2, i - 1, j - 1)));
  }

  public static int memoization(String word1, String word2) {
    var dp = new Integer[word1.length()][word2.length()];
    dp[word1.length() - 1][word2.length() - 1] =
        memoization(word1, word2, word1.length() - 1, word2.length() - 1, dp);
    return dp[word1.length() - 1][word2.length() - 1];
  }

  private static int memoization(String word1, String word2, int i, int j, Integer[][] dp) {
    if (i < 0) {
      return j + 1;
    }
    if (j < 0) {
      return i + 1;
    }

    if (dp[i][j] != null) {
      return dp[i][j];
    }

    if (word1.charAt(i) == word2.charAt(j)) {
      dp[i][j] = memoization(word1, word2, i - 1, j - 1, dp);
      return dp[i][j];
    }
    dp[i][j] =
        1
            + Math.min(
                memoization(word1, word2, i - 1, j, dp),
                Math.min(
                    memoization(word1, word2, i, j - 1, dp),
                    memoization(word1, word2, i - 1, j - 1, dp)));
    return dp[i][j];
  }

  public static int tabulation(String word1, String word2) {
    var dp = new Integer[word1.length() + 1][word2.length() + 1];
    dp[word1.length()][word2.length()] =
        tabulation(word1, word2, word1.length(), word2.length(), dp);
    return dp[word1.length()][word2.length()];
  }

  private static int tabulation(String word1, String word2, int I, int J, Integer[][] dp) {
    for (int i = 0; i <= I; i++) {
      for (int j = 0; j <= J; j++) {
        if (i == 0) {
          dp[i][j] = j;
          continue;
        }
        if (j == 0) {
          dp[i][j] = i;
          continue;
        }

        if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
          dp[i][j] = dp[i - 1][j - 1];
        } else {
          dp[i][j] = 1 + Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1]));
        }
      }
    }
    return dp[I][J];
  }
}
