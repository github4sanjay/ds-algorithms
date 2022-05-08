package com.github4sanjay.dsalgo.stack;

import java.util.Stack;

/**
 * Infix to postfix a+b*(c^d-e)^(f+g*h)-i ------> abcd^e-fgh*+^*+i-
 *
 * <p>Infix to prefix (a-b/c)*(a/k-l) ------> *-a/bc-/akl
 */
public class InfixConversion {

  public static void main(String[] args) {
    System.out.println(InfixConversion.postfix("a+b*(c^d-e)^(f+g*h)-i"));
    System.out.println(InfixConversion.prefix("(a-b/c)*(a/k-l)"));
  }

  /**
   * | | | | | | | | | b | | | if current character is operator and equal to '/' | a | | * | then
   * pop 'a' and 'b' and push ab* |_____| |_____|
   */
  private static String postfix(String expression) {
    var postfixStack = new Stack<String>();
    var operatorStack = new Stack<Character>();
    for (char currentChar : expression.toCharArray()) {
      if (currentChar == '(') {
        operatorStack.push(currentChar);
      } else if (currentChar == ')') {
        while (!operatorStack.isEmpty()) {
          var pop = operatorStack.pop();
          if (pop.equals('(')) {
            break;
          }
          var firstOperand = postfixStack.pop();
          var secondOperand = postfixStack.pop();
          var evaluate = evaluatePostfix(secondOperand, firstOperand, pop);
          postfixStack.push(evaluate);
        }
      } else if (isOperand(currentChar)) {
        postfixStack.push(String.valueOf(currentChar));
      } else if (isOperator(currentChar)) {
        while (!operatorStack.isEmpty()
            && isHigherOrEqualPrecedence(currentChar, operatorStack.peek())) {
          var pop = operatorStack.pop();
          var firstOperand = postfixStack.pop();
          var secondOperand = postfixStack.pop();
          var evaluate = evaluatePostfix(secondOperand, firstOperand, pop);
          postfixStack.push(evaluate);
        }
        operatorStack.push(currentChar);
      }
    }
    while (!operatorStack.isEmpty()) {
      var pop = operatorStack.pop();
      var firstOperand = postfixStack.pop();
      var secondOperand = postfixStack.pop();
      var evaluate = evaluatePostfix(secondOperand, firstOperand, pop);
      postfixStack.push(evaluate);
    }
    return postfixStack.pop();
  }

  /**
   * | | | | | | | | | b | | | if current character is operator and equal to '/' | a | | * | then
   * pop 'a' and 'b' and push *ab |_____| |_____|
   */
  private static String prefix(String expression) {
    var prefixStack = new Stack<String>();
    var operatorStack = new Stack<Character>();
    for (char currentChar : expression.toCharArray()) {
      if (currentChar == '(') {
        operatorStack.push(currentChar);
      } else if (currentChar == ')') {
        while (!operatorStack.isEmpty()) {
          var pop = operatorStack.pop();
          if (pop.equals('(')) {
            break;
          }
          var firstOperand = prefixStack.pop();
          var secondOperand = prefixStack.pop();
          var evaluate = evaluatePrefix(secondOperand, firstOperand, pop);
          prefixStack.push(evaluate);
        }
      } else if (isOperand(currentChar)) {
        prefixStack.push(String.valueOf(currentChar));
      } else if (isOperator(currentChar)) {
        while (!operatorStack.isEmpty()
            && isHigherOrEqualPrecedence(currentChar, operatorStack.peek())) {
          var pop = operatorStack.pop();
          var firstOperand = prefixStack.pop();
          var secondOperand = prefixStack.pop();
          var evaluate = evaluatePrefix(secondOperand, firstOperand, pop);
          prefixStack.push(evaluate);
        }
        operatorStack.push(currentChar);
      }
    }
    while (!operatorStack.isEmpty()) {
      var pop = operatorStack.pop();
      var firstOperand = prefixStack.pop();
      var secondOperand = prefixStack.pop();
      var evaluate = evaluatePrefix(secondOperand, firstOperand, pop);
      prefixStack.push(evaluate);
    }
    return prefixStack.pop();
  }

  private static boolean isHigherOrEqualPrecedence(char currentChar, char peek) {
    return operatorPrecedence(peek) >= operatorPrecedence(currentChar);
  }

  private static String evaluatePostfix(String secondOperand, String firstOperand, char pop) {
    return secondOperand + firstOperand + pop;
  }

  private static String evaluatePrefix(String secondOperand, String firstOperand, Character pop) {
    return pop + secondOperand + firstOperand;
  }

  private static int operatorPrecedence(char operator) {
    if (operator == '*') {
      return 2;
    } else if (operator == '-') {
      return 1;
    } else if (operator == '+') {
      return 1;
    } else if (operator == '/') {
      return 2;
    } else if (operator == '^') {
      return 3;
    } else { // for the case where '(' brackets come so they are not popped as its less precedence
      return -1;
    }
  }

  private static boolean isOperator(char ch) {
    return (ch == '*' || ch == '+' || ch == '-' || ch == '/' || ch == '^');
  }

  private static boolean isOperand(char currentChar) {
    return (currentChar >= '0' && currentChar <= '9') || (currentChar >= 'a' && currentChar <= 'z');
  }
}
