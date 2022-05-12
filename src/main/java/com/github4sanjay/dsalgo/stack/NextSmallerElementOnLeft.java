package com.github4sanjay.dsalgo.stack;

import java.util.Arrays;
import java.util.Stack;

/**
 * Next Smaller Element To The Right Medium
 *
 * <p>1. You are given a number n, representing the size of array a. 2. You are given n numbers,
 * representing elements of array a. 3. You are required to "next smaller element on the right" for
 * all elements of array 4. Input and output is handled for you.
 *
 * <p>"Next smaller element on the right" of an element x is defined as the first element to right
 * of x having value smaller than x. Note -> If an element does not have any element on it's right
 * side smaller than it, consider -1 as it's "next smaller element on right" e.g. for the array [2 5
 * 9 3 1 12 6 8 7] Next smaller for 2 is 1 Next smaller for 5 is 3 Next smaller for 9 is 3 Next
 * smaller for 3 is 1 Next smaller for 1 is -1 Next smaller for 12 is 6 Next smaller for 6 is -1
 * Next smaller for 8 is 7 Next smaller for 7 is -1
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
 * <p>Sample Output 3 -2 -2 -1 -1
 */
public class NextSmallerElementOnLeft {

  public static void main(String[] args) {
    System.out.println(
        Arrays.toString(
            NextSmallerElementOnLeft.find(new int[] {5, 3, 8, -2, 7}))); //   [-1, -1, 3, -1, -2]
    System.out.println(
        Arrays.toString(
            NextSmallerElementOnLeft.find(new int[] {4, 5, 2, 25}))); //   [-1, 4, -1, 2]
    System.out.println(
        Arrays.toString(
            NextSmallerElementOnLeft.find(new int[] {5, 3, 8, -2, 7}))); //   [-1, -1, 3, -1, -2]
  }

  public static int[] find(int[] array) {
    int[] nge = new int[array.length];
    nge[0] = -1;
    var stack = new Stack<Integer>();
    stack.push(array[0]);
    for (int i = 1; i < array.length; i++) {
      while (!stack.isEmpty() && array[i] <= stack.peek()) {
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
