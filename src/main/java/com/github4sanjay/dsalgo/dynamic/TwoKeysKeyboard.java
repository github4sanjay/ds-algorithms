package com.github4sanjay.dsalgo.dynamic;

/**
 * There is only one character 'A' on the screen of a notepad. You can perform one of two operations
 * on this notepad for each step:
 *
 * <p>Copy All: You can copy all the characters present on the screen (a partial copy is not
 * allowed). Paste: You can paste the characters which are copied last time. Given an integer n,
 * return the minimum number of operations to get the character 'A' exactly n times on the screen.
 *
 * <p>Example 1:
 *
 * <p>Input: n = 3 Output: 3 Explanation: Initially, we have one character 'A'. In step 1, we use
 * Copy All operation. In step 2, we use Paste operation to get 'AA'. In step 3, we use Paste
 * operation to get 'AAA'. Example 2:
 *
 * <p>Input: n = 1 Output: 0
 */
public class TwoKeysKeyboard {

  public static int dp(int n) {
    int ans = 0;
    for (int i = 2; i * i <= n; ) {
      if (n % i == 0) {
        ans = ans + i;
        n = n / i;
      } else {
        i++;
      }
    }
    if (n != 1) {
      ans = ans + n;
    }
    return ans;
  }

  public static int recursion(int n) {
    var answer = new Answer(Integer.MAX_VALUE);
    recursion(n, 0, 1, 0, answer);
    return answer.min;
  }

  private static int recursion(
      int requiredA, Integer numberOfCopiedA, int currentNumberOfA, int operations, Answer answer) {

    if (currentNumberOfA > requiredA) {
      return Integer.MAX_VALUE;
    }
    if (currentNumberOfA == requiredA) {
      answer.min = Math.min(answer.min, operations);
      return 0;
    }

    if (numberOfCopiedA == 0) {
      return recursion(requiredA, 1, 2, operations + 2, answer);
    }
    var directPaste =
        recursion(
            requiredA, numberOfCopiedA, currentNumberOfA + numberOfCopiedA, operations + 1, answer);
    var copyPaste =
        2 + recursion(requiredA, currentNumberOfA, currentNumberOfA * 2, operations + 2, answer);
    return Math.min(directPaste, copyPaste);
  }

  public static class Answer {
    int min;

    public Answer(int min) {
      this.min = min;
    }
  }
}
