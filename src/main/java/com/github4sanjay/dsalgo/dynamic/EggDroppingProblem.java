package com.github4sanjay.dsalgo.dynamic;

/*
 * You are given A eggs, and you have access to a building with B floors from 1 to B.
 *
 * Each egg is identical in function, and if an egg breaks, you cannot drop it again.
 *
 * You know that there exists a floor C with 0 <= C <= B  such that any egg dropped at a floor higher than C will break, and any egg dropped at or below floor C will not break.
 *
 * Each move, you may take an egg (if you have an unbroken one) and drop it from any floor X (with 1 <= X <= B).
 *
 * Your goal is to know with certainty what the value of C is.
 *
 * What is the minimum number of moves that you need to know with certainty what C is, regardless of the initial value of C?
 *
 * Examples:
 *
 * Input: A = 1, B = 2
 * Output: 2
 * Explanation:
 *
 * Drop the egg from floor 1.  If it breaks, we know with certainty that F = 0.
 * Otherwise, drop the egg from floor 2.  If it breaks, we know with certainty that F = 1.
 *  If it didn’t break, then we know with certainty F = 2.
 *
 *  Hence, we needed 2 moves in the worst case to know what F is with certainty.
 * Input:  A = 2, B = 10
 *
 * Output: 4
 *
 * Example 2:

Input: k = 2, n = 6
Output: 3
Example 3:

Input: k = 3, n = 14
Output: 4
 */
public class EggDroppingProblem {

  public static int recursion(int eggs, int floors) {
    if (floors == 0) {
      return 0;
    }
    if (floors == 1) {
      return 1;
    }
    if (eggs == 1) {
      return floors;
    }
    if (eggs == 0) {
      return Integer.MIN_VALUE;
    }

    var result = Integer.MAX_VALUE;
    for (int f = 1; f <= floors; f++) {
      var whenBreak = recursion(eggs - 1, f - 1);
      var whenNotBreak = recursion(eggs, floors - f);
      var localResult = Math.max(whenBreak, whenNotBreak);
      result = Math.min(result, localResult);
    }
    return 1 + result;
  }

  public static int memoization(int eggs, int floors) {
    var dp = new Integer[eggs + 1][floors + 1];
    dp[eggs][floors] = memoization(eggs, floors, dp);
    return dp[eggs][floors];
  }

  public static int memoization(int eggs, int floors, Integer[][] dp) {
    if (floors == 0) {
      return 0;
    }
    if (floors == 1) {
      return 1;
    }
    if (eggs == 1) {
      return floors;
    }
    if (eggs == 0) {
      return Integer.MIN_VALUE;
    }

    if (dp[eggs][floors] != null) {
      return dp[eggs][floors];
    }

    var result = Integer.MAX_VALUE;
    for (int f = 1; f <= floors; f++) {
      // if break means one less egg and f-1 floors
      var whenBreak = memoization(eggs - 1, f - 1, dp);
      // if not break means same number of egg and floors-f floors(all floors above f need to check)
      var whenNotBreak = memoization(eggs, floors - f, dp);
      // always take the worst for guaranteed result
      var localResult = Math.max(whenBreak, whenNotBreak);
      // always take the best of the worst
      result = Math.min(result, localResult);
    }
    dp[eggs][floors] = 1 + result;
    return dp[eggs][floors];
  }

  public static int tabulation(int eggs, int floors) {
    var dp = new Integer[eggs + 1][floors + 1];
    dp[eggs][floors] = memoization(eggs, floors, dp);
    return dp[eggs][floors];
  }

  public static int tabulation(int EGGS, int FLOORS, Integer[][] dp) {

    for (int eggs = 0; eggs <= EGGS; eggs++) {
      for (int floors = 0; floors <= FLOORS; floors++) {
        if (floors == 0) {
          dp[eggs][floors] = 0;
          continue;
        }
        if (floors == 1) {
          dp[eggs][floors] = 1;
          continue;
        }
        if (eggs == 1) {
          dp[eggs][floors] = floors;
          continue;
        }
        if (eggs == 0) {
          dp[eggs][floors] = Integer.MIN_VALUE;
          continue;
        }

        var result = Integer.MAX_VALUE;
        for (int f = 1; f <= floors; f++) {
          var whenBreak = dp[eggs - 1][f - 1];
          var whenNotBreak = dp[eggs][floors - f];
          var localResult = Math.max(whenBreak, whenNotBreak);
          result = Math.min(result, localResult);
        }
        dp[eggs][floors] = 1 + result;
      }
    }
    return dp[EGGS][FLOORS];
  }
}
