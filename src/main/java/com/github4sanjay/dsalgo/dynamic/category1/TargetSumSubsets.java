package com.github4sanjay.dsalgo.dynamic.category1;

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

  public static void main(String[] args) {
    int[] set = {3, 34, 4, 12, 5, 2};
    int sum = 25;
    int n = set.length;
    if (isSubsetSum(set, sum)) System.out.println("Found a subset" + " with given sum");
    else System.out.println("No subset with" + " given sum");

    if (recursiveDP(set, sum, set.length - 1))
      System.out.println("Found a subset" + " with given sum");
    else System.out.println("No subset with" + " given sum");
  }

  private static boolean isSubsetSum(int[] set, int sum) {
    boolean[][] dp = new boolean[set.length + 1][sum + 1];

    for (int i = 0; i < dp.length; i++) {
      for (int j = 0; j < dp[0].length; j++) {
        if (i == 0 && j == 0) {
          dp[i][0] = true; // sum 0 is possible by all subsets
        } else if (i == 0) {
          dp[0][j] = false;
        } else if (j == 0) {
          dp[i][0] = true; // sum 0 is possible by all subsets
        } else {
          // if item from set not taken
          boolean ifNotTaken = dp[i - 1][j];
          boolean ifTaken = false;
          if (j - set[i - 1] >= 0) { // i-1 as set is 1 lesser in length
            ifTaken = dp[i - 1][j - set[i - 1]];
          }
          if (ifNotTaken || ifTaken) {
            dp[i][j] = true;
          }
        }
      }
    }
    return dp[set.length][sum];
  }

  public static boolean recursive(int[] set, int sum, int index) {
    if (sum == 0) return true;
    if (index == 0) {
      return set[index] == sum;
    }
    boolean notTake = recursive(set, sum, index - 1);
    boolean take = false;
    if (sum >= set[index]) {
      take = recursive(set, sum - set[index], index - 1);
    }
    return notTake || take;
  }

  public static boolean recursiveDP(int[] set, int sum, int index) {
    return recursiveDP(set, sum, index, new Boolean[set.length][sum + 1]);
  }

  public static boolean recursiveDP(int[] set, int sum, int index, Boolean[][] dp) {
    if (sum == 0) return true;
    if (index == 0) {
      return set[index] == sum;
    }
    if (dp[index][sum] != null) return dp[index][sum];
    boolean notTake = recursive(set, sum, index - 1);
    boolean take = false;
    if (sum >= set[index]) {
      take = recursive(set, sum - set[index], index - 1);
    }
    var result = notTake || take;
    dp[index][sum] = result;
    return result;
  }
}
