package com.github4sanjay.dsalgo.backtracking;

/*
 * You are given a word.
 * You have to generate all abbreviations of that word.
 * For example:
 * Sample Input-> pep
 *
 * Sample Output-> pep   pe1  p1p   p2   1ep  1e1  2p 3 (in different lines)
 *
 * HOW?
 * First of all, generate all the binaries of the length equal to the length of the input string.
 *
 * Binaries -
 *
 * 000 -> pep
 * 001 -> pe1
 * 010 -> p1p
 * 011 -> p2
 * 100 -> 1ep
 * 101 -> 1e1
 * 110 -> 2p
 * 111 -> 3
 */
public class Abbreviation {

  public static void print(String str) {
    print(str, new int[str.length()], str.length());
  }

  private static void print(String str, int[] binary, int n) {
    if (n < 1) {
      StringBuilder abbreviation = new StringBuilder();
      int sum = 0;
      for (int i = 0; i < binary.length; i++) {
        if (binary[i] == 0) {
          if (sum != 0) {
            abbreviation.append(sum);
          }
          sum = 0;
          abbreviation.append(str.charAt(i));
        } else {
          sum = sum + 1;
        }
      }
      if (sum != 0) {
        abbreviation.append(sum);
      }
      System.out.println(abbreviation);
    } else {
      binary[n - 1] = 0;
      print(str, binary, n - 1);
      binary[n - 1] = 1;
      print(str, binary, n - 1);
    }
  }

  public static void printWithoutBinary(String str) {
    printWithoutBinary(str, "", 0, 0);
  }

  private static void printWithoutBinary(String question, String answer, int count, int position) {
    if (position == question.length()) {
      if (count == 0) {
        System.out.println(answer);
      } else {
        System.out.println(answer + count);
      }
      return;
    }
    if (count > 0) {
      printWithoutBinary(question, answer + count + question.charAt(position), 0, position + 1);
    } else {
      printWithoutBinary(question, answer + question.charAt(position), 0, position + 1);
    }
    printWithoutBinary(question, answer, count + 1, position + 1);
  }
}
