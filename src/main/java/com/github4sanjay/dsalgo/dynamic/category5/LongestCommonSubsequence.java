package com.github4sanjay.dsalgo.dynamic.category5;

import com.github4sanjay.dsalgo.recurssion.Subsequence;

/**
 * LCS Problem Statement: Given two sequences, find the length of longest subsequence present in
 * both of them. A subsequence is a sequence that appears in the same relative order, but not
 * necessarily contiguous. For example, “abc”, “abg”, “bdf”, “aeg”, ‘”acefg”, .. etc are
 * subsequences of “abcdefg”.
 *
 * <p>Examples: LCS for input Sequences “HABCDH” and “AEDFHR” is “ADH” of length 3. LCS for input
 * Sequences “AGGTAB” and “GXTXAYB” is “GTAB” of length 4.
 */
public class LongestCommonSubsequence {

  public static void main(String[] args) {
    System.out.println("Length of LCS is" + " " + LongestCommonSubsequence.lcs("HABCDH", "AEDFHR"));
    System.out.println(
        "Length of LCS is" + " " + LongestCommonSubsequence.lcs("AGGTAB", "GXTXAYB"));
  }

  /**
   * -------------------Brute
   * force-----------------------------------------------------------------------------
   *
   * <p>In order to find out the complexity of brute force approach, we need to first know the
   * number of possible different subsequences of a string with length n, i.e., find the number of
   * subsequences with lengths ranging from 1,2,..n-1. Recall from theory of permutation and
   * combination that number of combinations with 1 element are nC1. Number of combinations with 2
   * elements are nC2 and so forth and so on. We know that nC0 + nC1 + nC2 + … nCn = 2n. So a string
   * of length n has 2n-1 different possible subsequences since we do not consider the subsequence
   * with length 0. This implies that the time complexity of the brute force approach will be O(n *
   * 2n). Note that it takes O(n) time to check if a subsequence is common to both the strings. This
   * time complexity can be improved using dynamic programming.
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

  /**
   * LCS (s1, s2) = LCS (c1r1, c2r2) = subsequence in c1r1 * subsequence in c2r2 = _ subsequence in
   * r1 | _ subsequence in r2 c1 subsequence in r1 | c2 subsequence in r2
   *
   * <p>= _ subsequence in r1 * _ subsequence in r2 -----> 1 _ subsequence in r1 * c2 subsequence in
   * r2 ----> 2 c1 subsequence in r1 * _ subsequence in r2 -----> 3 c1 subsequence in r1 * c2
   * subsequence in r2 ----> 4
   *
   * <p>if c1 and c2 equal then longest would be available in 4 only else longest would be available
   * in 1/2/3 _______________________________________________ LCS (s1, s2) = | 1 + LCS (r1, r2) if
   * c1 = c2 | | max ( LCS(s1, r2), LCS(r1, s2) if c1 != c2 |
   * ------------------------------------------------
   *
   * <p>LCS(r1, s2) = sequence of r1 * sequence of s2 = sequence of r1 * | sequence of _ s(r2) ---->
   * 1 and 2 | sequence of c2 s(r2)
   *
   * <p>LCS(s1, r2) = sequence of s1 * sequence of r2 = sequence of _ s(r1) | sequence of r2 * ---->
   * 1 and 3 sequence of c1 s(r1) |
   *
   * <p>where s1 = first string, s2 = second string r1 = s1.substring(1), r2 = s2.substring(1) c1=
   * s1.charAt(0), c2= s2.charAt(0)
   *
   * <p>Below solution is keeping in mind LCS (s1, s2) = LCS (r1c1, r2c2)
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
}
