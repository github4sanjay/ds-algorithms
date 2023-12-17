package com.github4sanjay.dsalgo.linkedlist;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class QueueWithLinkedListTest {

  @Test
  public void testAddAndPeek() {
    QueueWithLinkedList<Integer> queue = new QueueWithLinkedList<>();
    queue.add(10);
    queue.add(20);
    queue.add(30);

    assertEquals(10, queue.peek());
  }

  @Test
  public void testRemove() {
    QueueWithLinkedList<Integer> queue = new QueueWithLinkedList<>();
    queue.add(10);
    queue.add(20);

    int removed = queue.remove();
    assertEquals(10, removed);
    assertEquals(20, queue.peek());
  }

  @Test
  public void testEmptyQueue() {
    QueueWithLinkedList<Integer> queue = new QueueWithLinkedList<>();

    assertThrows(RuntimeException.class, queue::remove);
    assertThrows(RuntimeException.class, queue::peek);
  }

  @Test
  public void testRemoveAll() {
    QueueWithLinkedList<Integer> queue = new QueueWithLinkedList<>();
    queue.add(10);
    queue.add(20);
    queue.add(30);

    assertEquals(10, queue.remove());
    assertEquals(20, queue.remove());
    assertEquals(30, queue.remove());
    assertThrows(RuntimeException.class, queue::remove);
  }
}
