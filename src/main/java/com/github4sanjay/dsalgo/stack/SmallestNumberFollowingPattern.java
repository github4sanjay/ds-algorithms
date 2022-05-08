package com.github4sanjay.dsalgo.stack;

import java.util.Stack;

/**
 * Form minimum number from given sequence
 *
 * <p>Given a pattern containing only I’s and D’s. I for increasing and D for decreasing. Devise an
 * algorithm to print the minimum number following that pattern. Digits from 1-9 and digits can’t
 * repeat.
 *
 * <p>Examples:
 *
 * <p>Input: D Output: 21 Input: I Output: 12 Input: DD Output: 321 Input: II Output: 123 Input:
 * DIDI Output: 21435 Input: IIDDD Output: 126543 Input: DDIDDIID Output: 321654798
 */
public class SmallestNumberFollowingPattern {

  public static void main(String[] args) {
    System.out.println(SmallestNumberFollowingPattern.find("DDIDDIID"));
    System.out.println(SmallestNumberFollowingPattern.find("IIDDD"));
  }

  /**
   * 1. Create stack and keep a counter initially starting with 1 2. push the current counter and
   * increase counter by 1 3. if character in pattern is I then pop and print all the elements from
   * stack 4. Lastly push the current counter and pop and print all the elements from stack
   */
  private static String find(String pattern) {
    int currentDigit = 1;
    var stack = new Stack<Integer>();
    StringBuilder answer = new StringBuilder();
    for (char ch : pattern.toCharArray()) {
      stack.push(currentDigit);
      currentDigit++;
      if (ch == 'I') {
        while (!stack.isEmpty()) {
          answer.append(stack.pop());
        }
      }
    }
    stack.push(currentDigit);
    while (!stack.isEmpty()) {
      answer.append(stack.pop());
    }
    return answer.toString();
  }
}
