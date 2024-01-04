package com.github4sanjay.dsalgo.dynamic.stairs;

/*
 * 1. You are given a number n, representing the number of stairs in a staircase.
 * 2. You are on the 0th step and are required to climb to the top.
 * 3. You are given n numbers, where ith element's value represents - till how far from the step you
 *      could jump to in a single move.  You can of-course fewer number of steps in the move.
 * 4. You are required to print the number of minimum moves in which you can reach the top of
 *      staircase.
 * Note -> If there is no path through the staircase print null.
 */
public class StairsPathMinMoves {

  public static Integer recursion(int[] jumps) {
    return recursion(0, jumps);
  }

  private static Integer recursion(int n, int[] jumps) {
    if (n > jumps.length) return null;
    if (n == jumps.length) return 0;

    Integer min = null;
    for (int i = 1; i <= jumps[n]; i++) {
      var moves = recursion(n + i, jumps);
      if (moves != null) {
        if (min == null) {
          min = moves;
        } else {
          min = Math.min(min, moves);
        }
      }
    }
    return min != null ? min + 1 : null;
  }

  public static Integer memoization(int[] jumps) {
    var dp = new Integer[jumps.length];
    return memoization(0, jumps, dp);
  }

  private static Integer memoization(int n, int[] jumps, Integer[] dp) {
    if (n > jumps.length) return null;
    if (n == jumps.length) return 0;

    if (dp[n] != null) {
      return dp[n];
    }
    Integer min = null;
    for (int i = 1; i <= jumps[n]; i++) {
      var moves = memoization(n + i, jumps, dp);
      if (moves != null) {
        if (min == null) {
          min = moves;
        } else {
          min = Math.min(min, moves);
        }
      }
    }
    dp[n] = min != null ? min + 1 : null;
    return min != null ? min + 1 : null;
  }

  public static Integer tabulation(int[] jumps) {
    var dp = new Integer[jumps.length + 1];
    dp[0] = tabulation(0, jumps, dp);
    return dp[0];
  }

  private static Integer tabulation(int N, int[] jumps, Integer[] dp) {
    for (int n = jumps.length; n >= 0; n--) {
      // if (n > jumps.length) return null;
      if (n == jumps.length) {
        dp[n] = 0;
        continue;
      }

      Integer min = null;
      for (int i = 1; i <= jumps[n]; i++) {
        var moves = dp[n + i];
        if (moves != null) {
          if (min == null) {
            min = moves;
          } else {
            min = Math.min(min, moves);
          }
        }
      }
      dp[n] = min != null ? min + 1 : null;
    }
    return dp[0];
  }
}
