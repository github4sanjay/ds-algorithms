package com.github4sanjay.dsalgo.stack;

import java.util.Stack;

/**
 * Find if an expression has duplicate parenthesis or not Given a balanced expression, find if it
 * contains duplicate parenthesis or not. A set of parenthesis are duplicate if the same
 * subexpression is surrounded by multiple parenthesis.
 *
 * <p>Examples:
 *
 * <p>Below expressions have duplicate parenthesis - ((a+b)+((c+d))) The subexpression "c+d" is
 * surrounded by two pairs of brackets.
 *
 * <p>(((a+(b)))+(c+d)) The subexpression "a+(b)" is surrounded by two pairs of brackets.
 *
 * <p>(((a+(b))+c+d)) The whole expression is surrounded by two pairs of brackets.
 *
 * <p>Below expressions don't have any duplicate parenthesis - ((a+b)+(c+d)) No subsexpression is
 * surrounded by duplicate brackets.
 *
 * <p>((a+(b))+(c+d)) No subsexpression is surrounded by duplicate brackets.
 */
public class DuplicateBrackets {

  public static void main(String[] args) {
    System.out.println(DuplicateBrackets.hasExtra("((a+(b))+(c+d))")); //  false
    System.out.println(DuplicateBrackets.hasExtra("(((a+(b)))+(c+d))")); //  true
    System.out.println(DuplicateBrackets.hasExtra("((a+b)+((c+d)))")); //  true
  }

  /**
   * Iterate over each character 1. if character is not equal to ')' push in stack 2. if character
   * is ')' if peek character is '(' then return true as nothing was between opening and closing
   * bracket if peek character is other than '(' then pop until opening bracket including opening
   * bracket
   */
  private static boolean hasExtra(String expression) {
    Stack<Character> stack = new Stack<>();
    for (char ch : expression.toCharArray()) {
      if (ch != ')') {
        stack.push(ch);
      } else {
        if (stack.peek() == '(') { // if nothing between opening and closing it means extra
          return true;
        }
        while (!stack.isEmpty()) { // pop until found a closing bracket
          char peekChar = stack.pop();
          if (peekChar == '(') {
            break;
          }
        }
      }
    }
    return false;
  }
}
