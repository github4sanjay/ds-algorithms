package com.github4sanjay.dsalgo.recurssion;

public class PrintEncoding {
  private static final String[] ALPHABET = {
    "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s",
    "t", "u", "v", "w", "x", "y", "z"
  };

  public static void main(String[] args) {
    /** output: abjc ljc */
    PrintEncoding.print("12103");
    // PrintEncoding.print("226");
    // PrintEncoding.print("0");
  }

  private static void print(String str) {
    print("", str);
  }

  private static void print(String answer, String question) {
    if (question.startsWith("0")) {
      return;
    }
    if (question.length() == 0) {
      System.out.println(answer);
      return;
    }

    int firstChar = Integer.parseInt(question.substring(0, 1), 10);
    if (question.length() > 1) {
      int secondChar = Integer.parseInt(question.substring(0, 2), 10);
      if (secondChar < 27 && secondChar > 9) {
        print(answer + ALPHABET[firstChar - 1], question.substring(1));
        print(answer + ALPHABET[secondChar - 1], question.substring(2));
      }
    } else {
      print(answer + ALPHABET[firstChar - 1], question.substring(1));
    }
  }
}
