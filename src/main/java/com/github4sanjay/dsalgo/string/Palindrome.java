package com.github4sanjay.dsalgo.string;

public class Palindrome {

  public static boolean isPalindrome(String str) {
    int mid = str.length() / 2;
    for (int i = 0; i <= mid; i++) {
      if (str.charAt(i) != str.charAt(str.length() - 1 - i)) {
        return false;
      }
    }
    return true;
  }

  public static boolean isPalindrome(String s, int i, int j) {
    if (i > j) return true;
    if (s.charAt(i) != s.charAt(j)) return false;
    return isPalindrome(s, i + 1, j - 1);
  }
}
