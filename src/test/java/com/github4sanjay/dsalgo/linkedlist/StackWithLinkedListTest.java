package com.github4sanjay.dsalgo.linkedlist;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class StackWithLinkedListTest {

  @Test
  public void testPushAndTop() {
    StackWithLinkedList<Integer> stack = new StackWithLinkedList<>();
    stack.push(10);
    stack.push(20);
    stack.push(30);

    assertEquals(30, stack.top());
  }

  @Test
  public void testPop() {
    StackWithLinkedList<Integer> stack = new StackWithLinkedList<>();
    stack.push(10);
    stack.push(20);

    int popped = stack.pop();
    assertEquals(20, popped);
    assertEquals(10, stack.top());
  }

  @Test
  public void testEmptyStack() {
    StackWithLinkedList<Integer> stack = new StackWithLinkedList<>();

    assertThrows(RuntimeException.class, stack::pop);
    assertThrows(RuntimeException.class, stack::top);
  }

  @Test
  public void testPopAll() {
    StackWithLinkedList<Integer> stack = new StackWithLinkedList<>();
    stack.push(10);
    stack.push(20);
    stack.push(30);

    assertEquals(30, stack.pop());
    assertEquals(20, stack.pop());
    assertEquals(10, stack.pop());
    assertThrows(RuntimeException.class, stack::pop);
  }
}
