package com.github4sanjay.dsalgo.string;

/**
 * 1. You are given a string that contains only lowercase and uppercase alphabets. 2. You have to
 * form a string that contains the difference of ASCII values of every two consecutive characters
 * between those characters. For "abecd", the answer should be "a1b3e-2c1d", as 'b'-'a' = 1 'e'-'b'
 * = 3 'c'-'e' = -2 'd'-'c' = 1
 */
public class DifferenceOfEvery2ConsecutiveChar {

  public static void main(String[] args) {
    System.out.println(
        DifferenceOfEvery2ConsecutiveChar.find("pepCODinG")); // p-11e11p-45C12O-11D37i5n-39G
  }

  private static String find(String str) {
    StringBuilder finalString = new StringBuilder();
    char prev = str.charAt(0);
    for (int i = 1; i < str.length(); i++) {
      char ch = str.charAt(i);
      int difference = ch - prev;
      finalString.append(prev).append(difference);
      prev = ch;
    }
    finalString.append(prev);
    return finalString.toString();
  }
}
