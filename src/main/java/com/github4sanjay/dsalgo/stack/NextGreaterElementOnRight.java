package com.github4sanjay.dsalgo.stack;

import java.util.Arrays;
import java.util.Stack;

/**
 * Given an array, print the Next Greater Element (NGE) for every element. The Next greater Element
 * for an element x is the first greater element on the right side of x in array. Elements for which
 * no greater element exist, consider next greater element as -1.
 *
 * <p>Examples:
 *
 * <p>For any array, rightmost element always has next greater element as -1. For an array which is
 * sorted in decreasing order, all elements have next greater element as -1. For the input array [4,
 * 5, 2, 25}, the next greater elements for each element are as follows. Element NGE 4 --> 5 5 -->
 * 25 2 --> 25 25 --> -1 d) For the input array [13, 7, 6, 12}, the next greater elements for each
 * element are as follows.
 *
 * <p>Element NGE 13 --> -1 7 --> 12 6 --> 12 12 --> -1
 */
public class NextGreaterElementOnRight {

  public static void main(String[] args) {
    System.out.println(
        Arrays.toString(
            NextGreaterElementOnRight.find(new int[] {13, 7, 6, 12}))); //   [-1, 12, 12, -1]
    System.out.println(
        Arrays.toString(
            NextGreaterElementOnRight.find(new int[] {4, 5, 2, 25}))); //   [5, 25, 25, -1]
    System.out.println(
        Arrays.toString(
            NextGreaterElementOnRight.find(new int[] {5, 3, 8, -2, 7}))); //   [8, 8, -1, 7, -1]
  }

  /**
   * Pop from stack until stack is not empty or peek element is greater than current array element
   * if stack is empty then no element greater than current element so put -1 else peek element is
   * greater that current element so put nge as peek element of stack push current element into
   * stack
   *
   * <p>Time complexity : 2n
   */
  public static int[] find(int[] array) {
    int[] nge = new int[array.length];
    nge[array.length - 1] = -1;
    var stack = new Stack<Integer>();
    stack.push(array[array.length - 1]);
    for (int i = array.length - 2; i >= 0; i--) {
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
