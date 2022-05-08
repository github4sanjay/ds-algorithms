package com.github4sanjay.dsalgo.string.matching;

/**
 * Given a text txt[0..n-1] and a pattern pat[0..m-1], write a function search(char pat[], char
 * txt[]) that prints all occurrences of pat[] in txt[]. You may assume that n > m. Examples:
 *
 * <p>Input: txt[] = "THIS IS A TEST TEXT" pat[] = "TEST" Output: Pattern found at index 10
 *
 * <p>Input: txt[] = "AABAACAADAABAABA" pat[] = "AABA" Output: Pattern found at index 0 Pattern
 * found at index 9 Pattern found at index 12
 */
public class StringMatchingBruteForce {

  public static void main(String[] args) {
    System.out.println(find("abcbcfgm", "bcfg")); // true
    System.out.println(find("abcbcfgm", "bcfm")); // false
  }

  public static boolean find(String str, String pattern) {
    for (int i = 0; i < str.length() - pattern.length(); i++) {
      int j = 0;
      while (j < pattern.length() && str.charAt(i + j) == pattern.charAt(j)) {
        j++;
      }
      if (j == pattern.length()) {
        return true;
      }
    }
    return false;
  }
}
