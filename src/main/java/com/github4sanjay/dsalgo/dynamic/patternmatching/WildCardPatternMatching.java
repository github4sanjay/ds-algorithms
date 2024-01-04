package com.github4sanjay.dsalgo.dynamic.patternmatching;

/*
 * Wildcard Pattern Matching
 * Last Updated: 23-10-2020
 * Given a text and a wildcard pattern, implement wildcard pattern matching algorithm that finds
 * if wildcard pattern is matched with text. The matching should cover the entire text (not partial text).
 * The wildcard pattern can include the characters ‘?’ and ‘*’
 * ‘?’ – matches any single character
 * ‘*’ – Matches any sequence of characters (including the empty sequence)
 *
 * For example,
 *
 * Text = "baaabab",
 * Pattern = “*****ba*****ab", output : true
 * Pattern = "baaa?ab", output : true
 * Pattern = "ba*a?", output : true
 * Pattern = "a*ab", output : false
 */
public class WildCardPatternMatching {

  /*
   *Case 1: The character is ‘*’
   *   Here two cases arise
   *    1. We can ignore ‘*’ character and move to next character in the Pattern.
   *    2. ‘*’ character matches with one or more characters in Text. Here we will move to next character in the string.
   *
   * Case 2: The character is ‘?’
   *  We can ignore current character in Text and move to next character in the Pattern and Text.
   *
   * Case 3: The character is not a wildcard character
   *   If current character in Text matches with current character in Pattern, we move to next character in the Pattern and Text.
   *   If they do not match, wildcard pattern and Text do not match.
   *
   *
   * We can use Dynamic Programming to solve this problem –
   *  row(i)-> patterns
   *  col(j)-> given string
   *  Let dp[i][j] is true if last dp[0].length - j characters in given string matches the last dp.length - i characters of pattern.
   *
   *  cases:
   *  1. when pattern character is non wild card:
   *      a. if pattern character matches with string character then dp[i][j] = dp[i+1][j+1]
   *      b. if not equal then dp[i][j] = false
   *  2. when pattern character is ? :
   *      then dp[i][j] = dp[i+1][j+1]
   *  3. when pattern character is * :
   *      a. if we take * as blank then dp[i][j] = dp[i+1][j]
   *      b. if we take 1 character from given string then dp[i][j] = dp[i+1][j+1]
   *      c. if we take 2 character from given string then dp[i][j] = dp[i+1][j+2]
   *      so similarly till all columns
   *      dp[i][j] is true if any of dp[i+1][j+k] where k=0 to dp[0].length-j is true
   *      else false
   *
   * Important we can also solve like this when * taken and when start not taken
   * this will solve the question in n^2 complexity.
   *
   *         | b   |  a   |   a   |   a   |   b   |    a  |     b  |    _   |
   *      ___|_____|______|_______|_______|_______|_______|________|________|_
   *      b  |     |      |       |       |       |       |        |  false |
   *      ___|_____|______|_______|_______|_______|_______|________|________|_
   *      a  |     |      |       |       |       |       |        |  false |
   *      ___|_____|______|_______|_______|_______|_______|________|________|_
   *      *  |     |      |       |       |       |       |        | false  |
   *      ___|_____|______|_______|_______|_______|_______|________|________|_
   *      a  |     |      |       |       |       |       |        | false  |
   *      ___|_____|______|_______|_______|_______|_______|________|________|_
   *      ?  |     |      |       |       |       |       |        |  false |
   *      ___|_____|______|_______|_______|_______|_______|________|________|_
   *      -  |false| false|  false| false |false  | false |  false |  true  |
   *      ___|_____|______|_______|_______|_______|_______|________|________|_
   */
  public static boolean find(String str, String pattern) {
    boolean[][] dp = new boolean[pattern.length() + 1][str.length() + 1];
    for (int i = dp.length - 1; i >= 0; i--) {
      for (int j = dp[0].length - 1; j >= 0; j--) {
        if (i == dp.length - 1 && j == dp[0].length - 1) {
          dp[i][j] = true;
        } else if (i == dp.length - 1) {
          dp[i][j] = false;
        } else if (j == dp[0].length - 1) {
          if (pattern.charAt(i) == '*') {
            dp[i][j] = dp[i - 1][j];
          } else {
            dp[i][j] = false;
          }
        } else {
          if (pattern.charAt(i) == '*') {
            // boolean foundInPreviousRow = whenStar(dp, dp[i + 1], j);
            //          when * taken     when * not taken
            dp[i][j] = dp[i][j + 1] || dp[i + 1][j];
          } else if (pattern.charAt(i) == '?') {
            dp[i][j] = dp[i + 1][j + 1];
          } else {
            if (pattern.charAt(i) == str.charAt(j)) {
              dp[i][j] = dp[i + 1][j + 1];
            } else {
              dp[i][j] = false;
            }
          }
        }
      }
    }
    return dp[0][0];
  }

  public static boolean recursion(String input, String pattern) {
    return recursion(input, pattern, input.length() - 1, pattern.length() - 1);
  }

  private static boolean recursion(String input, String pattern, int inputIndex, int patternIndex) {
    if (patternIndex < 0 && inputIndex < 0) {
      return true;
    }
    if (inputIndex >= 0 && patternIndex < 0) {
      return false;
    }
    if (inputIndex < 0 && patternIndex >= 0) {
      for (int i = 0; i <= patternIndex; i++) {
        if (pattern.charAt(i) != '*') {
          return false;
        }
      }
      return true;
    }

    var inputChar = input.charAt(inputIndex);
    var patternChar = pattern.charAt(patternIndex);
    if (inputChar == patternChar || patternChar == '?') {
      return recursion(input, pattern, inputIndex - 1, patternIndex - 1);
    } else if (patternChar == '*') {
      var takeStar = recursion(input, pattern, inputIndex, patternIndex - 1);
      var takeStarForOneChar = recursion(input, pattern, inputIndex - 1, patternIndex);
      return takeStar || takeStarForOneChar;
    }
    return false;
  }

  public static boolean memoization(String input, String pattern) {
    var dp = new Boolean[input.length()][pattern.length()];
    dp[input.length() - 1][pattern.length() - 1] =
        memoization(input, pattern, input.length() - 1, pattern.length() - 1, dp);
    return dp[input.length() - 1][pattern.length() - 1];
  }

  private static boolean memoization(
      String input, String pattern, int inputIndex, int patternIndex, Boolean[][] dp) {
    if (patternIndex < 0 && inputIndex < 0) {
      return true;
    }
    if (inputIndex >= 0 && patternIndex < 0) {
      return false;
    }
    if (inputIndex < 0 && patternIndex >= 0) {
      for (int i = 0; i <= patternIndex; i++) {
        if (pattern.charAt(i) != '*') {
          return false;
        }
      }
      return true;
    }

    if (dp[inputIndex][patternIndex] != null) {
      return dp[inputIndex][patternIndex];
    }

    var inputChar = input.charAt(inputIndex);
    var patternChar = pattern.charAt(patternIndex);
    if (inputChar == patternChar || patternChar == '?') {
      dp[inputIndex][patternIndex] =
          memoization(input, pattern, inputIndex - 1, patternIndex - 1, dp);
      return dp[inputIndex][patternIndex];
    } else if (patternChar == '*') {
      var takeStar = memoization(input, pattern, inputIndex, patternIndex - 1, dp);
      var takeStarForOneChar = memoization(input, pattern, inputIndex - 1, patternIndex, dp);
      dp[inputIndex][patternIndex] = takeStar || takeStarForOneChar;
      return dp[inputIndex][patternIndex];
    }
    dp[inputIndex][patternIndex] = false;
    return dp[inputIndex][patternIndex];
  }

  public static boolean tabulation(String input, String pattern) {
    var dp = new Boolean[input.length() + 1][pattern.length() + 1];
    dp[input.length()][pattern.length()] =
        tabulation(input, pattern, input.length(), pattern.length(), dp);
    return dp[input.length()][pattern.length()];
  }

  private static boolean tabulation(
      String input, String pattern, int INPUT_INDEX, int PATTERN_INDEX, Boolean[][] dp) {
    for (int inputIndex = 0; inputIndex <= INPUT_INDEX; inputIndex++) {
      for (int patternIndex = 0; patternIndex <= PATTERN_INDEX; patternIndex++) {

        if (patternIndex == 0 && inputIndex == 0) {
          dp[inputIndex][patternIndex] = true;
          continue;
        }

        if (inputIndex > 0 && patternIndex == 0) {
          dp[inputIndex][patternIndex] = false;
          continue;
        }
        if (inputIndex == 0 && patternIndex > 0) {
          var result = true;
          for (int i = 1; i <= patternIndex; i++) {
            if (pattern.charAt(i - 1) != '*') {
              result = false;
              break;
            }
          }
          dp[inputIndex][patternIndex] = result;
          continue;
        }

        var inputChar = input.charAt(inputIndex - 1);
        var patternChar = pattern.charAt(patternIndex - 1);
        if (inputChar == patternChar || patternChar == '?') {
          dp[inputIndex][patternIndex] = dp[inputIndex - 1][patternIndex - 1];
          continue;
        } else if (patternChar == '*') {
          var takeStar = dp[inputIndex][patternIndex - 1];
          var takeStarForOneChar = dp[inputIndex - 1][patternIndex];
          dp[inputIndex][patternIndex] = takeStar || takeStarForOneChar;
          continue;
        }
        dp[inputIndex][patternIndex] = false;
      }
    }
    return dp[INPUT_INDEX][PATTERN_INDEX];
  }

  /*
   * a. if we take * as blank then dp[i][j] = dp[i+1][j]
   * b. if we take 1 character from given string then dp[i][j] = dp[i+1][j+1]
   * c. if we take 2 character from given string then dp[i][j] = dp[i+1][j+2]
   * so similarly till all columns
   *
   * this makes it n^3 time complexity
   */
  private static boolean whenStar(boolean[][] dp, boolean[] booleans, int j) {
    boolean foundInPreviousRow = false;
    for (int k = 0; k < dp[0].length - j; k++) {
      if (booleans[j + k]) {
        foundInPreviousRow = true;
        break;
      }
    }
    return foundInPreviousRow;
  }
}
