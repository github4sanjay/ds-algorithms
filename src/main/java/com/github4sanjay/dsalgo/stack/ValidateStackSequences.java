package com.github4sanjay.dsalgo.stack;

import java.util.LinkedList;

/**
 * Validate Stack Sequences Medium
 *
 * <p>1: Given two sequences pushed and popped with distinct values. 2: You have to return true if
 * and only if this could have been the result of a sequence of push and pop operations on an
 * initially empty stack
 *
 * <p>Constraints 1: pushed is a permutation of popped 2: pushed and popped have distinct values
 *
 * <p>Format Input Input is managed for you
 *
 * <p>Output Output is managed for you
 *
 * <p>Example Sample Input
 *
 * <p>1 2 3 4 5 4 5 3 2 1
 *
 * <p>Sample Output true
 */
public class ValidateStackSequences {

  public static boolean check(int[] pushed, int[] popped) {
    int poppedIndex = 0;
    var stack = new LinkedList<Integer>();
    stack.push(pushed[0]);
    int pushedIndex = 1;
    while (!stack.isEmpty()) {
      if (poppedIndex > popped.length - 1) return false;
      if (stack.peek() == popped[poppedIndex]) {
        poppedIndex++;
        stack.pop();
      } else {
        if (pushedIndex > pushed.length - 1) return false;
        stack.push(pushed[pushedIndex]);
        pushedIndex++;
      }
    }
    return poppedIndex == popped.length;
  }
}
