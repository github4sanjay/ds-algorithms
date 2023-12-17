package com.github4sanjay.dsalgo.linkedlist;

import com.github4sanjay.dsalgo.linkedlist.structure.LinkNode;
import com.github4sanjay.dsalgo.linkedlist.structure.LinkedList;

/**
 * Reverse a Linked List in groups of given size | Set 1 Given a linked list, write a function to
 * reverse every k nodes (where k is an input to the function).
 *
 * <p>Example:
 *
 * <p>Input: 1->2->3->4->5->6->7->8->NULL, K = 3 Output: 3->2->1->6->5->4->8->7->NULL
 *
 * <p>Input: 1->2->3->4->5->6->7->8->NULL, K = 5 Output: 5->4->3->2->1->8->7->6->NULL
 */
public class KReverseLinkedList {

  public static void kReverseLinkedList(LinkedList<Integer> linkedList, int k) {
    var currentLinkedList = new LinkedList<Integer>();
    LinkNode<Integer> previous = null;
    LinkNode<Integer> head = null;
    int size = linkedList.getSize();
    while (linkedList.getSize() != 0) {
      for (int i = 0; i < k && linkedList.getSize() != 0; i++) {
        currentLinkedList.addFirst(linkedList.removeFirst());
      }
      if (previous == null) {
        head = currentLinkedList.getHead();
      } else {
        previous.setNext(currentLinkedList.getHead());
      }
      previous = currentLinkedList.getTail();
      currentLinkedList = new LinkedList<>();
    }
    linkedList.setHead(head);
    linkedList.setTail(currentLinkedList.getTail());
    linkedList.setSize(size);
  }

  public static void kReverseLinkedListKeepingLastPartSame(LinkedList<Integer> linkedList, int k) {
    var currentLinkedList = new LinkedList<Integer>();
    LinkNode<Integer> previous = null;
    LinkNode<Integer> head = null;
    int size = linkedList.getSize();
    while (linkedList.getSize() != 0) {
      if (linkedList.getSize() >= k) {
        for (int i = 0; i < k && linkedList.getSize() != 0; i++) {
          currentLinkedList.addFirst(linkedList.removeFirst());
        }
      } else {
        for (int i = 0; i < k && linkedList.getSize() != 0; i++) {
          currentLinkedList.addLast(linkedList.removeFirst());
        }
      }

      if (previous == null) {
        head = currentLinkedList.getHead();
      } else {
        previous.setNext(currentLinkedList.getHead());
      }
      previous = currentLinkedList.getTail();
      currentLinkedList = new LinkedList<>();
    }
    linkedList.setHead(head);
    linkedList.setTail(currentLinkedList.getTail());
    linkedList.setSize(size);
  }

  public static <T> LinkNode<T> reverseBlockOfNodes(LinkNode<T> head, int k) {
    if (head == null) return head;
    var current = head;
    var prevCurrent = head;
    LinkNode<T> prevTail = null;
    while (current != null) {
      LinkNode<T> prev = null;
      int count = k;
      while (current != null && count > 0) {
        var next = current.getNext();
        current.setNext(prev);
        prev = current;
        current = next;
        count--;
      }
      if (prevTail == null) {
        head = prev;
      } else {
        prevTail.setNext(prev);
      }
      prevTail = prevCurrent;
      prevCurrent = current;
    }
    return head;
  }
}
