package com.github4sanjay.dsalgo.dynamic.category1;

/*
416. Partition Equal Subset Sum

Given an integer array nums, return true if you can partition the array into two subsets such that the
sum of the elements in both subsets is equal or false otherwise.


Example 1:

Input: nums = [1,5,11,5]
Output: true
Explanation: The array can be partitioned as [1, 5, 5] and [11].
Example 2:

Input: nums = [1,2,3,5]
Output: false
Explanation: The array cannot be partitioned into equal sum subsets.


Constraints:

1 <= nums.length <= 200
1 <= nums[i] <= 100
 */
public class PartitionEqualSubsets {

  public static void main(String[] args) {
    System.out.println(find(new int[] {1, 5, 11, 5}));
    System.out.println(find(new int[] {1, 2, 3, 5}));
    System.out.println(find(new int[] {1, 5, 3}));
    System.out.println(find(new int[] {2, 3, 3, 3, 4, 5}));
  }

  public static boolean find(int[] arr) {
    int sum = 0;
    for (int item : arr) {
      sum = sum + item;
    }
    if (sum % 2 == 1) return false;
    return TargetSumSubsets.tabular(arr, sum / 2);
  }
}
