package com.github4sanjay.dsalgo.stack;

/**
 * Create a data structure twoStacks that represents two stacks. Implementation of twoStacks should
 * use only one array, i.e., both stacks should use the same array for storing elements.
 *
 * <p>Following functions must be supported by twoStacks. push1(int x) –> pushes x to first stack
 * push2(int x) –> pushes x to second stack
 *
 * <p>pop1() –> pops an element from first stack and return the popped element pop2() –> pops an
 * element from second stack and return the popped element
 *
 * <p>Implementation of twoStack should be space efficient.
 */
public class TwoStackInArray {
  private int[] repo;
  private int top1;
  private int top2;

  public TwoStackInArray(int cap) {
    this.repo = new int[cap];
    this.top1 = -1;
    this.top2 = cap;
  }

  public void push1(int data) {
    if (top1 + 1 == top2) {
      throw new RuntimeException("stack is full");
    }
    this.repo[++top1] = data;
  }

  public void push2(int data) {
    if (top2 - 1 == top1) {
      throw new RuntimeException("stack is full");
    }
    this.repo[--top2] = data;
  }

  public int pop1() {
    if (top1 == -1) {
      throw new RuntimeException("stack is empty");
    }
    return this.repo[top1--];
  }

  public int pop2() {
    if (top2 == repo.length) {
      throw new RuntimeException("stack is empty");
    }
    return this.repo[top2++];
  }

  public int peek1() {
    if (top1 == -1) {
      throw new RuntimeException("stack is empty");
    }
    return this.repo[top1];
  }

  public int peek2() {
    if (top2 == repo.length) {
      throw new RuntimeException("stack is empty");
    }
    return this.repo[top2];
  }

  public static void main(String[] args) {
    var twoStack = new TwoStackInArray(10);
    twoStack.push1(10);
    twoStack.push1(20);

    System.out.println(twoStack.peek1()); // 20

    twoStack.push2(30);
    twoStack.push2(40);

    System.out.println(twoStack.peek2()); // 40

    System.out.println(twoStack.pop1()); // 20
    System.out.println(twoStack.pop2()); // 40
    System.out.println(twoStack.pop1()); // 10
  }
}
