package com.github4sanjay.dsalgo.string;

import java.util.List;
import java.util.stream.Collectors;

public class FindAllPalindromicSubstrings {

  public static void main(String[] args) {
    System.out.println(FindAllPalindromicSubstrings.find("abcc"));
  }

  private static List<String> find(String str) {
    return FindSubstring.find(str).stream()
        .filter(Palindrome::isPalindrome)
        .collect(Collectors.toList());
  }
}
