package com.github4sanjay.dsalgo.dynamic;

/*
Given an array X[] of n integers, write a program to find the maximum sum of a subarray among all subarrays.
A subarray of array X[] is a contiguous segment of elements from X[i] through X[j], where 0 <= i <= j <= n.
If the array contains all non-negative numbers, the maximum subarray sum would be the sum of the entire array.
Several different subarrays may have the same max sum, but we only need to return the value of the max subarray sum.

Example 1
Input: X[] = [-4, 5,  7, -6, 10,  -15,  3], Output: 16
Explanation: The subarray [5, 7, -6, 10] has the maximum sum.

Example 2
Input: X[] = [-3, 2, -1, 4,-2], Output: 5
Explanation: The subarray [2, -1, 4] has the maximum sum.
 */
public class MaxSumSubArrayKadaneAlgo {

  public static void main(String[] args) {
    System.out.println(get(new int[] {-4, 5, 7, -6, 10, -15, 3})); // 16
    System.out.println(get(new int[] {-3, 2, -1, 4, -2})); // 5
  }

  public static int get(int[] arr) {
    int sum = Integer.MIN_VALUE;
    int currentSum = arr[0];
    for (int i = 1; i < arr.length; i++) {
      if (sum < 0) {
        currentSum = arr[i];
      } else {
        currentSum = currentSum + arr[i];
      }
      sum = Math.max(currentSum, sum);
    }
    return sum;
  }
}
