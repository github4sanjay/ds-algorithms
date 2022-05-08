package com.github4sanjay.dsalgo.backtracking;

import com.github4sanjay.dsalgo.string.Palindrome;

public class PalindromePartitioning {

  public static void main(String[] args) {
    String str = "abaaba";

    /**
     * {a}{b}{a}{a}{b}{a} {a}{b}{a}{aba} {a}{b}{aa}{b}{a} {a}{baab}{a} {aba}{a}{b}{a} {aba}{aba}
     * {abaaba}
     */
    PalindromePartitioning.execute(str, "");
  }

  private static void execute(String question, String answer) {

    if (question.length() == 0) {
      System.out.println(answer);
      return;
    }
    for (int i = 0; i < question.length(); i++) {
      String prefix = question.substring(0, i + 1);
      if (Palindrome.isPalindrome(prefix)) {
        execute(question.substring(i + 1), answer + "{" + prefix + "}");
      }
    }
  }
}
