package com.github4sanjay.dsalgo.hashmap.max.consecutive.one;

/**
 * 1. You are given an array(arr) which contains only 0's and 1's. 2. You have to find the maximum
 * number of consecutive 1's in the given array if you can flip at most one zero.
 *
 * <p>Input 1 1 0 0 1 1
 *
 * <p>Output 3
 */
public class OneZeroFlipAllowed {

  public static void main(String[] args) {
    System.out.println(OneZeroFlipAllowed.find(new int[] {1, 1, 0, 0, 1, 1})); // 3
    System.out.println(OneZeroFlipAllowed.find(new int[] {0, 1, 0, 0, 1, 1, 1, 1, 0})); // 5
    System.out.println(OneZeroFlipAllowed.find(new int[] {0, 1, 0, 1, 1, 1, 1, 0})); // 6
    System.out.println(OneZeroFlipAllowed.find(new int[] {1, 1, 1, 1, 1, 1, 1, 0})); // 8
    System.out.println(OneZeroFlipAllowed.find(new int[] {1, 1, 1, 1, 1, 1, 1})); // 7
    System.out.println(OneZeroFlipAllowed.find(new int[] {0, 1, 1, 1, 1, 1, 1})); // 7
    System.out.println(OneZeroFlipAllowed.find(new int[] {1, 0, 0, 1, 1, 1, 1, 1})); // 6
  }

  private static int find(int[] array) {
    int i = 0, j = -1;
    int maxLength = Integer.MIN_VALUE;
    int zeroCount = 0;
    while (i < array.length) {
      if (array[i] == 0) {
        zeroCount++;
      }

      while (zeroCount > 1) {
        j++;
        if (array[j] == 0) {
          zeroCount--;
        }
      }
      maxLength = Math.max(maxLength, i - j);
      i++;
    }
    return maxLength;
  }
}
