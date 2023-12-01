package com.github4sanjay.dsalgo.dynamic.strings;

/*
 Longest Common Substring
   Easy

   1. You are given two strings S1 and S2.
   2. You are required to print the length of the longest common substring of two strings.

   Constraints
   1 < length of strings S1 and S2 <= 200

   Format
   Input
   2 strings S1 and S2

   Output
   A number representing the length of longest common substring of two strings.

   Example
   Sample Input

   abcdgh
   acdghr

   Sample Output
   4
*/
public class LongestCommonSubstring {

  /*
   str1 = "pqabcxy"
   Str2 = "xyzabcp"
   prefixes of "pqabcxy" = p, pq, pqa, pqqb, pqabc, pqabcx, pqabcxy
   prefixes of "pqabcxy" = x, xy, xyz, xyza, xyzab, xyzabc, xyzabcp

   longest common suffix of prefixes :  "pqabc" and  "xyzabc" is abc which whould be the
    longest common susbstring

    s1 and s2
    if s1 = r1c1 and s2 = r2c2
    if c1 = c2, then long common suffix = (whatever in s1 and s2) + 1
    if c1 != c2, then 0
  */
  public static int find(String str1, String str2) {
    int[][] dp = new int[str1.length() + 1][str2.length() + 1];
    int max = 0;
    for (int i = 0; i <= str1.length(); i++) {
      for (int j = 0; j <= str2.length(); j++) {
        if (i == 0 || j == 0) {
          dp[i][j] = 0;
        } else {
          if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
            dp[i][j] = dp[i - 1][j - 1] + 1;
            max = Math.max(max, dp[i][j]);
          } else {
            dp[i][j] = 0;
          }
        }
      }
    }
    return max;
  }
}
