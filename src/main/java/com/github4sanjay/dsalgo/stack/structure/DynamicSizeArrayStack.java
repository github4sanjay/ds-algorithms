package com.github4sanjay.dsalgo.stack.structure;

public class DynamicSizeArrayStack {
  private static final int DEFAUT_CAPACITY = 10;
  private int[] stackRepo;
  private int capacity;
  private int top = -1;

  public DynamicSizeArrayStack(int capacity) {
    this.capacity = capacity;
    stackRepo = new int[capacity];
  }

  public DynamicSizeArrayStack() {
    this(DEFAUT_CAPACITY);
  }

  public boolean isEmpty() {
    return top < 0;
  }

  public int size() {
    return top + 1;
  }

  public int pop() throws Exception {
    if (isEmpty()) {
      throw new Exception("Stack is empty");
    }
    int data = stackRepo[top];
    stackRepo[top--] = Integer.MIN_VALUE;
    return data;
  }

  public void push(int data) throws Exception {
    if (size() == capacity) {
      increaseCapacity();
    }
    stackRepo[++top] = data;
  }

  private void increaseCapacity() {
    int[] repo = new int[2 * this.capacity];
    for (int i = 0; i < this.capacity; i++) {
      repo[i] = this.stackRepo[i];
    }
    this.capacity = 2 * this.capacity;
    this.stackRepo = repo;
  }

  public static void main(String[] args) throws Exception {
    var stack = new DynamicSizeArrayStack(2);
    stack.push(1);
    stack.push(2);
    stack.push(4);
    stack.push(3);
    System.out.println(stack.pop());
    System.out.println(stack.pop());
  }
}
