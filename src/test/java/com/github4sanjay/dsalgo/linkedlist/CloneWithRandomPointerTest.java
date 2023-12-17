package com.github4sanjay.dsalgo.linkedlist;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class CloneWithRandomPointerTest {

  @Test
  @Disabled
  public void testCloneWithoutExtraSpace() {
    CloneWithRandomPointer.Node<Integer> head = new CloneWithRandomPointer.Node<>(1);
    head.setNext(new CloneWithRandomPointer.Node<>(2));
    head.setRandom(head.getNext());

    CloneWithRandomPointer cloner = new CloneWithRandomPointer();
    CloneWithRandomPointer.Node<Integer> cloned = cloner.cloneWithoutExtraSpace(head);

    // Test next pointers
    assertEquals(head.getData(), cloned.getData());
    assertEquals(head.getNext().getData(), cloned.getNext().getData());

    // Test random pointers
    assertEquals(head.getRandom().getData(), cloned.getRandom().getData());
  }

  @Test
  public void testCloneWithExtraSpace() {
    CloneWithRandomPointer.Node<Integer> head = new CloneWithRandomPointer.Node<>(1);
    head.setNext(new CloneWithRandomPointer.Node<>(2));
    head.setRandom(head.getNext());

    CloneWithRandomPointer cloner = new CloneWithRandomPointer();
    CloneWithRandomPointer.Node<Integer> cloned = cloner.cloneWithExtraSpace(head);

    // Test next pointers
    assertEquals(head.getData(), cloned.getData());
    assertEquals(head.getNext().getData(), cloned.getNext().getData());

    // Test random pointers
    assertEquals(head.getRandom().getData(), cloned.getRandom().getData());
  }
}
