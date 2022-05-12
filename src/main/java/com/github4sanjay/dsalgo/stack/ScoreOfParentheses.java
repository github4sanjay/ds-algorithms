package com.github4sanjay.dsalgo.stack;

import java.util.LinkedList;

/**
 * Given a balanced parentheses string s, return the score of the string.
 *
 * <p>The score of a balanced parentheses string is based on the following rule:
 *
 * <p>"()" has score 1. AB has score A + B, where A and B are balanced parentheses strings. (A) has
 * score 2 * A, where A is a balanced parentheses string.
 *
 * <p>Example 1:
 *
 * <p>Input: s = "()" Output: 1 Example 2:
 *
 * <p>Input: s = "(())" Output: 2 Example 3:
 *
 * <p>Input: s = "()()" Output: 2
 *
 * <p>Constraints:
 *
 * <p>2 <= s.length <= 50 s consists of only '(' and ')'. s is a balanced parentheses string.
 */
public class ScoreOfParentheses {

  public static int find(String input) {
    // store -1 as '(' as we need to score also in the stack
    var stack = new LinkedList<Integer>();
    for (var character : input.toCharArray()) {
      if (character == '(') {
        stack.push(-1);
      } else {
        var sum = 0;
        var base = true;
        while (!stack.isEmpty() && stack.peek() != -1) {
          base = false;
          var popped = stack.pop();
          sum = sum + popped;
        }
        if (!stack.isEmpty()) {
          stack.pop();
        }
        if (base) {
          stack.push(1);
        } else {
          stack.push(2 * sum);
        }
      }
    }
    var finalSum = 0;
    while (!stack.isEmpty()) {
      finalSum = finalSum + stack.pop();
    }
    return finalSum;
  }

  public static int sum(int i1, int i2) {
    return i1 + i2;
  }

  public static void main(String[] args) {
    var s = new ScoreOfParentheses();
    System.out.println(str);
  }

  private static String str;

  public void ScoreOfParentheses() {
    System.out.println("sdfkjsdf");
    str = "hello world";
  }
}
