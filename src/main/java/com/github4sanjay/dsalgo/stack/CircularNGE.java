package com.github4sanjay.dsalgo.stack;

import java.util.LinkedList;

/**
 * Next Greater Element Ii Easy
 *
 * <p>Given a circular integer array nums (i.e., the next element of nums[nums.length - 1] is
 * nums[0]), return the next greater number for every element in nums.
 *
 * <p>Constraints 1: 1 <= nums.length <= 10^4 2: -10^9 <= nums[i] <= 10^9
 *
 * <p>Format Input Input is managed for you
 *
 * <p>Output Output is managed for you
 *
 * <p>Example Sample Input
 *
 * <p>3 1 2 1
 *
 * <p>Sample Output 3 2 -1 2
 */
public class CircularNGE {

  public static int[] find(int[] input) {
    var stack = new LinkedList<Integer>();
    for (int i = input.length - 2; i >= 0; i--) {
      while (!stack.isEmpty() && stack.peek() <= input[i]) stack.pop();
      stack.push(input[i]);
    }
    var ans = new int[input.length];
    for (int i = input.length - 1; i >= 0; i--) {
      while (!stack.isEmpty() && stack.peek() <= input[i]) stack.pop();
      if (stack.isEmpty()) {
        ans[i] = -1;
      } else {
        ans[i] = stack.peek();
      }
      stack.push(input[i]);
    }
    return ans;
  }
}
