package com.github4sanjay.dsalgo.dynamic.subsequences;

/**
 * Given a set of non-negative integers, and a value sum, determine if there is a subset of the
 * given set with sum equal to given sum.
 *
 * <p>Example:
 *
 * <p>Input: set[] = {3, 34, 4, 12, 5, 2}, sum = 9 Output: True There is a subset (4, 5) with sum 9.
 *
 * <p>Input: set[] = {3, 34, 4, 12, 5, 2}, sum = 30 Output: False There is no subset that add up to
 * 30.
 *
 * <p>Complexity Analysis:
 *
 * <p>Time Complexity: O(sum*n), where sum is the ‘target sum’ and ‘n’ is the size of array.
 * Auxiliary Space: O(sum*n), as the size of 2-D array is sum*n.
 */
public class TargetSumSubsets {

  public static boolean recursion(int[] set, int target) {
    return recursion(set, set.length - 1, target);
  }

  private static boolean recursion(int[] set, int index, int target) {
    if (index == 0) {
      if (target == 0) return true;
      if (set[index] == target) {
        return true;
      } else {
        return false;
      }
    }
    var notTake = recursion(set, index - 1, target);
    var take = false;
    if (set[index] <= target) {
      take = recursion(set, index - 1, target - set[index]);
    }
    return notTake || take;
  }

  public static boolean memoization(int[] set, int target) {
    var dp = new Boolean[set.length][target + 1];
    dp[set.length - 1][target] = memoization(set, set.length - 1, target, dp);
    return dp[set.length - 1][target];
  }

  private static boolean memoization(int[] set, int index, int target, Boolean[][] dp) {
    if (index == 0) {
      if (target == 0) return true;
      if (set[index] == target) {
        return true;
      } else {
        return false;
      }
    }
    if (dp[index][target] != null) {
      return dp[index][target];
    }
    var notTake = memoization(set, index - 1, target, dp);
    var take = false;
    if (set[index] <= target) {
      take = memoization(set, index - 1, target - set[index], dp);
    }
    var result = notTake || take;
    dp[index][target] = result;
    return result;
  }

  public static boolean tabular(int[] set, int target) {
    var dp = new Boolean[set.length][target + 1];
    dp[set.length - 1][target] = tabular(set, set.length - 1, target, dp);
    return dp[set.length - 1][target];
  }

  private static boolean tabular(int[] set, int INDEX, int TARGET, Boolean[][] dp) {
    for (int index = 0; index <= INDEX; index++) {
      for (int target = 0; target <= TARGET; target++) {
        if (index == 0) {
          if (target == 0) {
            dp[index][target] = true;
            continue;
          }
          if (set[index] == target) {
            dp[index][target] = true;
            continue;
          } else {
            dp[index][target] = false;
            continue;
          }
        }

        var notTake = dp[index - 1][target];
        var take = false;
        if (set[index] <= target) {
          take = dp[index - 1][target - set[index]];
        }
        var result = notTake || take;
        dp[index][target] = result;
      }
    }
    return dp[INDEX][TARGET];
  }
}
