package com.github4sanjay.dsalgo.dynamic.category1;

/*
Partition a set into two subsets such that the difference of subset sums is minimum

Given a set of integers, the task is to divide it into two sets S1 and S2 such that the absolute difference between their sums is minimum.
If there is a set S with n elements, then if we assume Subset1 has m elements, Subset2 must have n-m elements and the value of abs(sum(Subset1) – sum(Subset2)) should be minimum.

Example:

Input:  arr[] = {1, 6, 11, 5}
Output: 1
Explanation:
Subset1 = {1, 5, 6}, sum of Subset1 = 12
Subset2 = {11}, sum of Subset2 = 11
 */
public class PartitionInto2SubsetsWithMinDiff {

  public static void main(String[] args) {
    System.out.println(find(new int[] {1, 6, 11, 5})); // 1
    System.out.println(find(new int[] {3, 1, 4, 2, 2, 1})); // 1
    System.out.println(find(new int[] {3, 9, 7, 3})); // 2
  }

  public static int find(int[] arr) {
    var totalSum = 0;
    for (var item : arr) {
      totalSum = totalSum + item;
    }

    var dp = new boolean[arr.length + 1][totalSum + 1];
    for (int i = 0; i < dp.length; i++) {
      dp[i][0] = true;
    }

    for (int j = 1; j <= totalSum; j++) {
      dp[0][j] = false;
    }

    for (int i = 1; i < dp.length; i++) {
      for (int j = 1; j < dp[0].length; j++) {
        boolean notTake = dp[i - 1][j];
        boolean take = false;
        if (j >= arr[i - 1]) {
          take = dp[i - 1][j - arr[i - 1]];
        }
        var result = notTake || take;
        dp[i][j] = result;
      }
    }

    var result = Integer.MAX_VALUE;
    for (int j = 0; j < dp[0].length; j++) {
      if (dp[dp.length - 1][j]) {
        int sum2 = totalSum - j;
        result = Math.min(result, Math.abs(j - sum2));
      }
    }
    return result;
  }
}
