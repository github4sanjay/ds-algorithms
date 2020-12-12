package backtracking;

import java.util.HashSet;
import java.util.Stack;

public class RemoveInvalidParenthesis {

    public static void main(String[] args) {
        /**
         * (())()
         * ()()()
         */
        RemoveInvalidParenthesis.remove("()())()");
    }

    private static void remove(String expression) {
        int minimumRemovalAllowed = getMin(expression);
        RemoveInvalidParenthesis.find(expression, minimumRemovalAllowed, new HashSet<>());
    }

    private static void find(String expression, int minimumRemovalAllowed, HashSet<String> set) {
        if (minimumRemovalAllowed == 0){
            if (isBalanced(expression)){
                if (!set.contains(expression)){
                    set.add(expression);
                    System.out.println(expression);
                }
            }
            return;
        }
        for (int i=0; i< expression.length(); i++){
            String left = expression.substring(0, i);
            String right = expression.substring(i+1);
            find(left+right, minimumRemovalAllowed-1, set);
        }
    }

    private static int getMin(String expression) {
        Stack<Character> stack = new Stack<>();
        for (char bracket : expression.toCharArray()){
            if (bracket == '(') {
                stack.push(bracket);
            } else {
                if (stack.empty() || stack.peek() == ')'){
                    stack.push(bracket);
                } else {
                    stack.pop();
                }
            }
        }
        return stack.size();
    }

    private static boolean isBalanced(String expression) {
        Stack<Character> stack = new Stack<>();
        for (char bracket : expression.toCharArray()){
            if (bracket == '(') {
                stack.push('(');
            } else {
              if (stack.empty()) return false;
              else {
                  if (stack.peek() != '('){
                      return false;
                  }
                  stack.pop();
              }
            }
        }
        return stack.empty();
    }
}
