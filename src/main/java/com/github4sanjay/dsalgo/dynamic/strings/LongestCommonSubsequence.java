package com.github4sanjay.dsalgo.dynamic.strings;

import com.github4sanjay.dsalgo.recurssion.Subsequence;

/*
 * LCS Problem Statement: Given two sequences, find the length of longest subsequence present in both of them.
 * A subsequence is a sequence that appears in the same relative order, but not necessarily contiguous.
 * For example, “abc”, “abg”, “bdf”, “aeg”, ‘”acefg”, .. etc are subsequences of “abcdefg”.
 *
 * Examples:
 * LCS for input Sequences “HABCDH” and “AEDFHR” is “ADH” of length 3.
 * LCS for input Sequences “AGGTAB” and “GXTXAYB” is “GTAB” of length 4.
 *
 */
public class LongestCommonSubsequence {

  public static void main(String[] args) {
    System.out.println("Length of LCS is" + " " + LongestCommonSubsequence.lcs("HABCDH", "AEDFHR"));
    System.out.println(
        "Length of LCS is" + " " + LongestCommonSubsequence.lcs("AGGTAB", "GXTXAYB"));

    System.out.println(
        "Length of LCS is" + " " + LongestCommonSubsequence.recursive("HABCDH", "AEDFHR"));
    System.out.println(
        "Length of LCS is" + " " + LongestCommonSubsequence.recursive("AGGTAB", "GXTXAYB"));

    System.out.println(
        "Length of LCS is" + " " + LongestCommonSubsequence.memoization("HABCDH", "AEDFHR"));
    System.out.println(
        "Length of LCS is" + " " + LongestCommonSubsequence.memoization("AGGTAB", "GXTXAYB"));

    System.out.println(
        "Length of LCS is" + " " + LongestCommonSubsequence.tabular("HABCDH", "AEDFHR"));
    System.out.println(
        "Length of LCS is" + " " + LongestCommonSubsequence.tabular("AGGTAB", "GXTXAYB"));
  }

  /*
   * Brute force
   * 2^(n+m) time complexity
   *
   */
  private static int lcsBruteForce(String str1, String str2) {
    var list1 = Subsequence.get(str1);
    var list2 = Subsequence.get(str2);

    int maxLength = Integer.MIN_VALUE;

    for (String item1 : list1) {
      for (String item2 : list2) {
        if (item1.equals(item2)) {
          maxLength = Math.max(maxLength, item1.length());
        }
      }
    }
    if (maxLength == Integer.MIN_VALUE) {
      return 0;
    } else {
      return maxLength;
    }
  }

  /*
   *
   * LCS (s1, s2) = LCS (c1r1, c2r2) = subsequence in c1r1 * subsequence in c2r2
   *                                 =  _ subsequence in r1   |  _ subsequence in r2
   *                                   c1 subsequence in r1   | c2 subsequence in r2
   *
   *                                 =   _ subsequence in r1  *  _ subsequence in r2 -----> 1
   *                                     _ subsequence in r1  *  c2 subsequence in r2 ----> 2
   *                                     c1 subsequence in r1 *  _ subsequence in r2 -----> 3
   *                                     c1 subsequence in r1 *  c2 subsequence in r2 ----> 4
   *
   *  if c1 and c2 equal then longest would be available in 4 only
   *  else longest would be available in 1/2/3
   *                 _______________________________________________
   *  LCS (s1, s2) = |  1 + LCS (r1, r2) if c1 = c2                 |
   *                |  max ( LCS(s1, r2), LCS(r1, s2) if c1 != c2  |
   *                ------------------------------------------------
   *
   *                LCS(r1, s2) = sequence of r1 * sequence of s2
   *                            = sequence of r1 * | sequence of _ s(r2)  ---->  1 and 2
   *                                               | sequence of c2 s(r2)
   *
   *               LCS(s1, r2)  = sequence of s1 * sequence of r2
   *                            = sequence of _ s(r1)   |  sequence of r2 *  ---->  1 and 3
   *                              sequence of c1 s(r1)  |
   *
   *
   *  where
   *  s1 = first string, s2 = second string
   *  r1 = s1.substring(1), r2 = s2.substring(1)
   *  c1= s1.charAt(0), c2= s2.charAt(0)
   *
   *  Below solution is keeping in mind LCS (s1, s2) = LCS (r1c1, r2c2)
   *
   * @param str1 string 1
   * @param str2 string 2
   * @return longest common subsequence
   */
  private static int lcs(String str1, String str2) {
    int[][] dp = new int[str1.length() + 1][str2.length() + 1];
    for (int i = 1; i < dp.length; i++) {
      for (int j = 1; j < dp[0].length; j++) {
        if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
          dp[i][j] = 1 + dp[i - 1][j - 1]; // if character equal 1 + lcs in substrings
        } else {
          dp[i][j] =
              Math.max(
                  dp[i][j - 1], // first string and substring in second string
                  dp[i - 1][j] // substring of first string and second string
                  );
        }
      }
    }
    return dp[dp.length - 1][dp[0].length - 1];
  }

  public static int recursive(String str1, String str2) {
    return recursive(str1.length() - 1, str2.length() - 1, str1, str2);
  }

  private static int recursive(int i1, int i2, String str1, String str2) {
    if (i1 < 0 || i2 < 0) return 0;
    if (str1.charAt(i1) == str2.charAt(i2)) {
      return 1 + recursive(i1 - 1, i2 - 1, str1, str2);
    } else {
      return Math.max(recursive(i1 - 1, i2, str1, str2), recursive(i1, i2 - 1, str1, str2));
    }
  }

  public static int memoization(String str1, String str2) {
    return memoization(
        str1.length() - 1, // str1.length() when shift
        str2.length() - 1, // str2.length() when shift
        str1,
        str2,
        new Integer[str1.length()]
            [str2.length()]); // Integer[str1.length()+1][str2.length()+1]) when shift
  }

  private static int memoization(int i1, int i2, String str1, String str2, Integer[][] dp) {
    if (i1 < 0 || i2 < 0) return 0; // if (i1 == 0 || i2 == 0) return 0; when shift
    if (dp[i1][i2] != null) return dp[i1][i2];
    int result;
    if (str1.charAt(i1)
        == str2.charAt(i2)) { // if (str1.charAt(i1-1) == str2.charAt(i2-1)) { when shift
      result = 1 + memoization(i1 - 1, i2 - 1, str1, str2, dp);
    } else {
      result =
          Math.max(
              memoization(i1 - 1, i2, str1, str2, dp), memoization(i1, i2 - 1, str1, str2, dp));
    }
    dp[i1][i2] = result;
    return result;
  }

  private static int tabular(String str1, String str2) {
    var dp = new int[str1.length() + 1][str2.length() + 1]; // shift by one for easy base case
    for (int i1 = 1; i1 < str1.length() + 1; i1++) {
      for (int i2 = 1; i2 < str2.length() + 1; i2++) {
        int result;
        if (str1.charAt(i1 - 1) == str2.charAt(i2 - 1)) {
          result = 1 + dp[i1 - 1][i2 - 1];
        } else {
          result = Math.max(dp[i1 - 1][i2], dp[i1][i2 - 1]);
        }
        dp[i1][i2] = result;
      }
    }

    return dp[str1.length()][str2.length()];
  }
}
