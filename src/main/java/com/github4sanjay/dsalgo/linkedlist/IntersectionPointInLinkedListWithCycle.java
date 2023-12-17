package com.github4sanjay.dsalgo.linkedlist;

import com.github4sanjay.dsalgo.linkedlist.structure.LinkNode;

public class IntersectionPointInLinkedListWithCycle {

  /**
   * In the Floyd's Tortoise and Hare algorithm for cycle detection, the intersection point of the
   * slow and fast pointers can be used to find the start of the cycle in a linked list.
   *
   * <p>Once the two pointers meet, indicating the presence of a cycle, you can find the
   * intersection point using the following steps:
   *
   * <p>Initialize two pointers - ptr1 and ptr2 - both starting at the head of the linked list. Move
   * ptr1 by one step and ptr2 by two steps until they meet at the intersection point within the
   * cycle.
   */
  public static <T> LinkNode<T> findIntersection(LinkNode<T> head) {
    LinkNode<T> intersection = null;
    var slowPtr = head;
    var fastPtr = head;

    // Detect cycle
    while (fastPtr != null && fastPtr.getNext() != null) {
      slowPtr = slowPtr.getNext();
      fastPtr = fastPtr.getNext().getNext();

      if (slowPtr == fastPtr) {
        break; // Cycle detected, intersection point found
      }
    }

    // If there's a cycle, find the intersection point
    if (slowPtr == fastPtr) {
      slowPtr = head;
      while (slowPtr != fastPtr) {
        slowPtr = slowPtr.getNext();
        fastPtr = fastPtr.getNext();
      }
      intersection = slowPtr; // Intersection point found
    }

    return intersection; // Return the intersection node
  }
}
