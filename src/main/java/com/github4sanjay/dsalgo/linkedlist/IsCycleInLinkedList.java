package com.github4sanjay.dsalgo.linkedlist;

import com.github4sanjay.dsalgo.linkedlist.structure.LinkNode;
import java.util.HashSet;

public class IsCycleInLinkedList {

  /*
   * detecting a cycle in a linked list using a HashSet to store visited nodes.
   *
   * You're iterating through the linked list using the currentNode pointer.
   * While traversing, you're adding each node to the HashSet.
   * If you encounter a node that is already in the set, it means there is a cycle, and your function correctly returns true.
   * This method works well for detecting cycles in linked lists.
   *
   * It has a time complexity of O(n)
   * Space complexity O(n)
   */
  public static <T> boolean findWithExtraSpace(LinkNode<T> head) {
    boolean isCycle = false;
    var set = new HashSet<LinkNode<T>>();
    var currentNode = head;
    while (currentNode != null) {
      if (set.contains(currentNode)) {
        isCycle = true;
        break;
      }
      set.add(currentNode);
      currentNode = currentNode.getNext();
    }
    return isCycle;
  }

  /**
   * The idea is to have two pointers moving through the linked list at different speeds. If there's
   * a cycle, these pointers will eventually meet at some node within the cycle.
   *
   * <p>Here's an outline of the algorithm:
   *
   * <p>Initialize two pointers, slow and fast, both starting at the head of the linked list. Move
   * slow one step at a time and fast two steps at a time. If there's a cycle, the slow and fast
   * pointers will eventually meet at some point within the cycle. If fast reaches the end of the
   * list (i.e., fast encounters a null next node), it means there's no cycle.
   */
  public static <T> boolean find(LinkNode<T> head) {
    if (head == null || head.getNext() == null) {
      return false; // No cycle if empty list or single node
    }

    boolean isCycle = true;
    var slowPtr = head;
    var fastPtr = head;
    while (fastPtr.getNext() != null && fastPtr.getNext().getNext() != null) {
      slowPtr = slowPtr.getNext();
      fastPtr = fastPtr.getNext().getNext();
      if (slowPtr == fastPtr) {
        break;
      }
    }
    if (fastPtr.getNext() == null) {
      isCycle = false;
    }
    return isCycle;
  }
}
