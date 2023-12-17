package com.github4sanjay.dsalgo.linkedlist;

import com.github4sanjay.dsalgo.linkedlist.structure.LinkNode;
import com.github4sanjay.dsalgo.linkedlist.structure.LinkedList;

/**
 * Rearrange a given linked list in-place. Given a singly linked list L0 -> L1 -> … -> Ln-1 -> Ln.
 * Rearrange the nodes in the list so that the new formed list is : L0 -> Ln -> L1 -> Ln-1 -> L2 ->
 * Ln-2 … You are required to do this in-place without altering the nodes’ values. Examples:
 *
 * <p>Input: 1 -> 2 -> 3 -> 4 Output: 1 -> 4 -> 2 -> 3
 *
 * <p>Input: 1 -> 2 -> 3 -> 4 -> 5 Output: 1 -> 5 -> 2 -> 4 -> 3
 */
public class FoldLinkedList {

  /*
   * Find mid node by slow and fast pointer
   * Add all the nodes after middle node to stack
   * Remove elements from stack one by one and append in linked list and also remove last element from
   * linked list as its already used from stack
   */
  public static void foldWithStack(LinkedList<Integer> linkedList) {
    var faster = linkedList.getHead();
    var slower = linkedList.getHead();
    var stack = new LinkedList<Integer>();
    while (faster.getNext() != null && faster.getNext().getNext() != null) {
      slower = slower.getNext();
      faster = faster.getNext().getNext();
    }
    slower = slower.getNext();
    while (slower != null) {
      stack.addFirst(slower.getData());
      slower = slower.getNext();
    }

    var currentNode = linkedList.getHead();
    while (stack.getSize() != 0) {
      var node = stack.removeFirst();
      var next = currentNode.getNext();
      currentNode.setNext(new LinkNode<>(node, next));
      currentNode = next;
      linkedList.removeLast();
    }
  }

  public static void fold(LinkNode<Integer> head) {
    var mid = mid(head);
    var headLastPart = mid.getNext();
    mid.setNext(null);
    headLastPart = reverse(headLastPart);
    var current1 = head;
    var current2 = headLastPart;
    // 1 2 3 4 5
    // 8 7 6
    while (current2 != null) {
      var next1 = current1.getNext();
      var next2 = current2.getNext();
      current2.setNext(current1.getNext());
      current1.setNext(current2);
      current2 = next2;
      current1 = next1;
    }
  }

  private static LinkNode<Integer> mid(LinkNode<Integer> head) {
    if (head == null || head.getNext() == null) return head;
    var slow = head.getNext();
    var fast = head.getNext();

    while (fast.getNext() != null && fast.getNext().getNext() != null) {
      slow = slow.getNext();
      fast = fast.getNext().getNext();
    }
    return slow;
  }

  private static LinkNode<Integer> reverse(LinkNode<Integer> head) {
    if (head == null || head.getNext() == null) return head;
    var current = head;
    LinkNode<Integer> prev = null;

    while (current != null) {
      var forward = current.getNext();
      current.setNext(prev);
      prev = current;
      current = forward;
    }
    return prev;
  }
}
