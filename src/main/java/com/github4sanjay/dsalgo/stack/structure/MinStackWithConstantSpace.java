package com.github4sanjay.dsalgo.stack.structure;

import java.util.Stack;

/**
 * Design a Data Structure SpecialStack that supports all the stack operations like push(), pop(),
 * isEmpty(), isFull() and an additional operation getMin() which should return minimum element from
 * the SpecialStack. All these operations of SpecialStack must be O(1). T o implement SpecialStack,
 * you should only use standard Stack data structure and no other data structure like arrays, list,
 * .. etc.
 *
 * <p>Example:
 *
 * <p>Consider the following SpecialStack 16 --> TOP 15 29 19 18
 *
 * <p>When getMin() is called it should return 15, which is the minimum element in the current
 * stack.
 *
 * <p>If we do pop two times on stack, the stack becomes 29 --> TOP 19 18
 *
 * <p>When getMin() is called, it should return 18 which is the minimum in the current stack.
 */
public class MinStackWithConstantSpace {
  private final Stack<Integer> stack;
  private Integer min;

  public MinStackWithConstantSpace() {
    this.stack = new Stack<>();
    this.min = null;
  }

  public Integer getMin() {
    if (stack.isEmpty()) {
      throw new RuntimeException("stack is empty");
    }
    return min;
  }

  public boolean isEmpty() {
    return stack.isEmpty();
  }

  public int size() {
    return stack.size();
  }

  public Integer top() {
    if (stack.isEmpty()) {
      throw new RuntimeException("stack is empty");
    }
    var peek = stack.peek();
    if (peek < min) {
      return min;
    } else {
      return peek;
    }
  }

  public Integer pop() {
    if (stack.isEmpty()) {
      throw new RuntimeException("stack is empty");
    }
    if (stack.peek() >= min) {
      return stack.pop();
    } else {
      int temp = min;
      min = 2 * min - stack.pop();
      return temp;
    }
  }

  public void push(Integer data) {
    if (min == null) {
      min = data;
      stack.push(data);
    } else if (data >= min) {
      stack.push(data);
    } else {
      stack.push(data + data - min);
      min = data;
    }
  }

  public static void main(String[] args) {
    var minStack = new MinStackWithConstantSpace();
    minStack.push(10);
    System.out.println(minStack.getMin());

    minStack.push(5);
    System.out.println(minStack.getMin());

    minStack.push(15);
    System.out.println(minStack.getMin());

    minStack.pop();
    System.out.println(minStack.getMin());

    minStack.pop();
    System.out.println(minStack.getMin());
  }
}
