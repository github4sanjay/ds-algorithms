package com.github4sanjay.dsalgo.stack;

import java.util.Arrays;
import java.util.Stack;

/**
 * Next Greater Element To The Left Medium
 *
 * <p>1. You are given a number n, representing the size of array a. 2. You are given n numbers,
 * representing elements of array a. 3. You are required to find "next greater element on the left"
 * for all elements of array 4. Input and output is handled for you.
 *
 * <p>"Next greater element on the left" of an element x is defined as the first element to left of
 * x having value greater than x. Note -> If an element does not have any element on it's left side
 * greater than it, consider -1 as it's "next greater element on left" e.g. for the array [2 5 9 3 1
 * 12 6 8 7] Next greater for 2 is -1 Next greater for 5 is -1 Next greater for 9 is -1 Next greater
 * for 3 is 9 Next greater for 1 is 3 Next greater for 12 is -1 Next greater for 6 is 12 Next
 * greater for 8 is 12 Next greater for 7 is 8
 *
 * <p>Constraints 0 <= n < 10^5 -10^9 <= a[i] <= 10^9
 *
 * <p>Format Input Input is managed for you
 *
 * <p>Output Output is managed for you
 *
 * <p>Example Sample Input
 *
 * <p>5 5 3 8 -2 7
 *
 * <p>Sample Output -1 5 -1 8 8
 */
public class NextGreaterElementOnLeft {

  public static void main(String[] args) {
    System.out.println(
        Arrays.toString(
            NextGreaterElementOnLeft.find(new int[] {5, 3, 8, -2, 7}))); //   [-1, 5, -1, 8, 8]
    System.out.println(
        Arrays.toString(
            NextGreaterElementOnLeft.find(new int[] {4, 5, 2, 25}))); //   [-1, -1, 5, -1]
    System.out.println(
        Arrays.toString(
            NextGreaterElementOnLeft.find(new int[] {5, 3, 8, -2, 7}))); //   [-1, 5, -1, 8, 8]
  }

  public static int[] find(int[] array) {
    int[] nge = new int[array.length];
    nge[0] = -1;
    var stack = new Stack<Integer>();
    stack.push(array[0]);
    for (int i = 1; i < array.length; i++) {
      while (!stack.isEmpty() && array[i] >= stack.peek()) {
        stack.pop();
      }
      if (stack.isEmpty()) {
        nge[i] = -1;
      } else {
        nge[i] = stack.peek();
      }
      stack.push(array[i]);
    }
    return nge;
  }
}
