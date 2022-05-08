package com.github4sanjay.dsalgo.array;

import java.util.Arrays;

/**
 * Given an array, rotate the array to the right by k steps, where k is non-negative.
 *
 * <p>Follow up:
 *
 * <p>Try to come up as many solutions as you can, there are at least 3 different ways to solve this
 * problem. Could you do it in-place with O(1) extra space?
 *
 * <p>Example 1:
 *
 * <p>Input: nums = [1,2,3,4,5,6,7], k = 3 Output: [5,6,7,1,2,3,4] Explanation: rotate 1 steps to
 * the right: [7,1,2,3,4,5,6] rotate 2 steps to the right: [6,7,1,2,3,4,5] rotate 3 steps to the
 * right: [5,6,7,1,2,3,4] Example 2:
 *
 * <p>Input: nums = [-1,-100,3,99], k = 2 Output: [3,99,-1,-100] Explanation: rotate 1 steps to the
 * right: [99,-1,-100,3] rotate 2 steps to the right: [3,99,-1,-100]
 */
public class Rotate {

  public static void main(String[] args) {
    int[] arr = new int[] {1, 2, 3, 4, 5, 6, 7};
    rotate(arr, 3);
    System.out.println(Arrays.toString(arr));

    int[] arr1 = new int[] {1, 2, 3, 4, 5, 6, 7};
    rotate(arr1, -3);
    System.out.println(Arrays.toString(arr1));
  }

  public static void rotate(int[] arr, int k) {
    k = k % arr.length;
    if (k < 0) {
      k = k + arr.length;
    }
    reverse(0, arr.length - k - 1, arr);
    reverse(arr.length - k, arr.length - 1, arr);
    reverse(0, arr.length - 1, arr);
  }

  private static void reverse(int i, int j, int[] arr) {
    while (i < j) {
      int temp = arr[j];
      arr[j] = arr[i];
      arr[i] = temp;
      i++;
      j--;
    }
  }
}
