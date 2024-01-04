package com.github4sanjay.dsalgo.dynamic.arrangements;

/*
 * 1. You are given a string str of digits. (will never start with a 0)
 * 2. You are required to encode the str as per following rules
 *     1 -> a
 *     2 -> b
 *     3 -> c
 *     ..
 *     25 -> y
 *     26 -> z
 * 3. You are required to calculate and print the count of encodings for the string str.
 *
 *      For 124 -> there are 3 encodings. abc, aw, lc
 *      For 993 -> there is 1 encoding. iic
 *      For 013 -> This is an invalid input. A string starting with 0 will not be passed.
 *      For 103 -> there is 1 encoding. jc
 *      For 303 -> there are 0 encodings. But such a string maybe passed. In this case
 *      print 0.
 */
public class CountEncodings {

  public static int recursion(String word) {
    return recursion(word, word.length() - 1);
  }

  private static int recursion(String word, int index) {
    char firstCharacter = word.charAt(0);
    if (firstCharacter == '0') return 0;
    if (index < 0) {
      return 0;
    }
    if (index == 0) {
      return 1;
    }
    var lastCharacter = word.charAt(index);
    var secondLastCharacter = word.charAt(index - 1);
    if (lastCharacter == '0' && secondLastCharacter == '0') {
      return 0;
    } else if (secondLastCharacter == '0') {
      return recursion(word, index - 1);
    } else if (lastCharacter == '0') {
      if (index - 2 < 0) {
        return 1;
      } else {
        return recursion(word, index - 2);
      }
    } else {
      int integer = Integer.parseInt(new String(new char[] {secondLastCharacter, lastCharacter}));
      if (integer > 26) {
        return recursion(word, index - 1);
      } else {
        if (index - 2 < 0) {
          return 1 + recursion(word, index - 1);
        } else {
          return recursion(word, index - 2) + recursion(word, index - 1);
        }
      }
    }
  }

  public static int memoization(String word) {
    var dp = new Integer[word.length()];
    dp[word.length() - 1] = memoization(word, word.length() - 1, dp);
    return dp[word.length() - 1];
  }

  private static int memoization(String word, int index, Integer[] dp) {
    char firstCharacter = word.charAt(0);
    if (firstCharacter == '0') return 0;
    if (index < 0) {
      return 0;
    }
    if (index == 0) {
      return 1;
    }
    if (dp[index] != null) {
      return dp[index];
    }
    var lastCharacter = word.charAt(index);
    var secondLastCharacter = word.charAt(index - 1);
    int result = 0;
    if (lastCharacter == '0' && secondLastCharacter == '0') {
      result = 0;
    } else if (secondLastCharacter == '0') {
      result = memoization(word, index - 1, dp);
    } else if (lastCharacter == '0') {
      if (index - 2 < 0) {
        result = 1;
      } else {
        result = memoization(word, index - 2, dp);
      }
    } else {
      int integer = Integer.parseInt(new String(new char[] {secondLastCharacter, lastCharacter}));
      if (integer > 26) {
        result = memoization(word, index - 1, dp);
      } else {
        if (index - 2 < 0) {
          result = 1 + memoization(word, index - 1, dp);
        } else {
          result = memoization(word, index - 2, dp) + memoization(word, index - 1, dp);
        }
      }
    }
    dp[index] = result;
    return result;
  }

  public static int tabulation(String str) {

    char firstCharacter = str.charAt(0);
    if (firstCharacter == '0') return 0;

    int[] dp = new int[str.length()];
    dp[0] = 1; // always one
    for (int i = 1; i < str.length(); i++) {
      char currentCharacter = str.charAt(i);
      char lastCharacter = str.charAt(i - 1);
      int integer = Integer.parseInt(new String(new char[] {lastCharacter, currentCharacter}));
      if (currentCharacter == '0' && lastCharacter == '0') {
        dp[i] = 0;
      } else if (currentCharacter == '0') {
        if (integer > 26) {
          dp[i] = 0;
        } else {
          dp[i] = (i - 2 >= 0 ? dp[i - 2] : 1);
        }
      } else if (lastCharacter == '0') {
        dp[i] = dp[i - 1];
      } else {
        if (integer > 26) {
          dp[i] = dp[i - 1];
        } else {
          dp[i] = (i - 2 >= 0 ? dp[i - 2] : 1) + dp[i - 1];
        }
      }
    }

    return dp[str.length() - 1];
  }
}
