package com.github4sanjay.dsalgo.dynamic.strings;

public class FindLongestCommonSubsequence {

  public static void main(String[] args) {
    System.out.println("Length of LCS is" + " " + find("HABCDH", "AEDFHR"));
    System.out.println("Length of LCS is" + " " + find("AGGTAB", "GXTXAYB"));
  }

  public static String find(String str1, String str2) {
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

    int i = str1.length(), j = str2.length();
    StringBuilder result = new StringBuilder();
    while (i > 0 && j > 0) {
      if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
        result.append(str1.charAt(i - 1));
        i--;
        j--;
      } else {
        if (dp[i - 1][j] > dp[i][j - 1]) {
          i--;
        } else {
          j--;
        }
      }
    }
    return result.reverse().toString();
  }
}
