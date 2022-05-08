package com.github4sanjay.dsalgo.stack;

import java.util.Stack;

/**
 * 1. You are given a prefix expression. 2. You are required to evaluate it and print it's value. 3.
 * You are required to convert it to infix and print it. 4. You are required to convert it to
 * postfix and print it.
 *
 * <p>Note -> Use brackets in infix expression for indicating precedence. Check sample input output
 * for more details.
 *
 * <p>Input Format expression
 *
 * <p>Output Format value, a number infix prefix
 *
 * <p>Constraints 1. Expression is a valid prefix expression 2. The only operators used are +, -, *,
 * / 3. All operands are single digit numbers.
 *
 * <p>Sample Input -+2/*6483
 *
 * <p>Sample Output 2 ((2+((6*4)/8))-3) 264*8/+3-
 */
public class PrefixEvaluationAndConversion {

  public static void main(String[] args) {
    System.out.println(PrefixEvaluationAndConversion.execute("-+2/*6483"));
  }

  /**
   * Difference between postfix and prefix evaluation is we traverse here from end of expression
   * Since we traverse from end so operand that is popped first is considered as first operand for
   * example 6 --> popped first 5 --> popped second and operator is - then value is 6 - 5 infix is
   * (6-5) postfix is 65-
   *
   * <p>For value evaluation : | 6 | | | | 4 | | 24 | | 8 | ---> current character is operator and
   * equal to '*' ----> | 8 | | 3 | then pop '6' and '4' and push 6*4 = 24 | 3 | |_____| |_____|
   *
   * <p>For infix evaluation : | 6 | | | | 4 | |(6*4)| | 8 | ---> current character is operator and
   * equal to '*' ----> | 8 | | 3 | then pop '4' and '6' and push (6*4) | 3 | |_____| |_____|
   *
   * <p>For postfix evaluation : | 6 | | | | 4 | | 64* | | 8 | ---> current character is operator
   * and equal to '*' ----> | 8 | | 3 | then pop '4' and '6' and push *64 | 3 | |_____| |_____|
   */
  private static Answer execute(String expression) {
    var valueStack = new Stack<Integer>();
    var infixStack = new Stack<String>();
    var postfixStack = new Stack<String>();

    for (int i = expression.length() - 1; i >= 0; i--) {
      char ch = expression.charAt(i);
      if (isOperator(ch)) {
        evaluateValue(valueStack, ch);
        evaluateInfix(infixStack, ch);
        evaluatePostfix(postfixStack, ch);
      } else if (Character.isDigit(ch)) {
        valueStack.push(ch - '0');
        infixStack.push(String.valueOf(ch));
        postfixStack.push(String.valueOf(ch));
      }
    }

    return new Answer(valueStack.pop(), infixStack.pop(), postfixStack.pop());
  }

  private static void evaluatePostfix(Stack<String> prefixStack, char operator) {
    var first = prefixStack.pop();
    var second = prefixStack.pop();
    prefixStack.push(evaluatePostfix(first, second, operator));
  }

  private static String evaluatePostfix(String first, String second, char operator) {
    return operator + first + second;
  }

  private static void evaluateInfix(Stack<String> infixStack, char operator) {
    var first = infixStack.pop();
    var second = infixStack.pop();
    infixStack.push(evaluateInfix(first, second, operator));
  }

  private static String evaluateInfix(String first, String second, char operator) {
    return "(" + first + operator + second + ")";
  }

  private static void evaluateValue(Stack<Integer> valueStack, char operator) {
    var first = valueStack.pop();
    var second = valueStack.pop();
    valueStack.push(evaluateValue(first, second, operator));
  }

  private static int evaluateValue(Integer firstOperand, Integer secondOperand, char operator) {
    if (operator == '*') {
      return firstOperand * secondOperand;
    } else if (operator == '-') {
      return firstOperand - secondOperand;
    } else if (operator == '+') {
      return firstOperand + secondOperand;
    } else if (operator == '/') {
      return firstOperand / secondOperand;
    }
    return 0;
  }

  private static boolean isOperator(char ch) {
    return (ch == '*' || ch == '+' || ch == '-' || ch == '/');
  }

  public static class Answer {
    int value;
    String infix;
    String postfix;

    public Answer(int value, String infix, String postfix) {
      this.value = value;
      this.infix = infix;
      this.postfix = postfix;
    }

    @Override
    public String toString() {
      return "Answer{"
          + "value="
          + value
          + ", infix='"
          + infix
          + '\''
          + ", prefix='"
          + postfix
          + '\''
          + '}';
    }
  }
}
