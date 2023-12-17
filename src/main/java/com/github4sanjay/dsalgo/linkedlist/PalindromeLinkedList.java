package com.github4sanjay.dsalgo.linkedlist;

import com.github4sanjay.dsalgo.linkedlist.structure.LinkNode;
import com.github4sanjay.dsalgo.linkedlist.structure.LinkedList;

public class PalindromeLinkedList {

  public static boolean isPalindrome(LinkNode<Integer> head) {
    if (head == null || head.getNext() == null) return true;
    var mid = getMid(head);
    var headLastHalf = mid.getNext();
    mid.setNext(null);
    headLastHalf = reverse(headLastHalf);

    var currentFirstHalf = head;
    var currentSecondHalf = headLastHalf;
    var res = true;
    while (currentSecondHalf != null) {
      if (!currentFirstHalf.getData().equals(currentSecondHalf.getData())) {
        res = false;
        break;
      }
      currentFirstHalf = currentFirstHalf.getNext();
      currentSecondHalf = currentSecondHalf.getNext();
    }
    mid.setNext(reverse(headLastHalf));
    return res;
  }

  private static LinkNode<Integer> getMid(LinkNode<Integer> head) {
    if (head == null || head.getNext() == null) return head;
    var slow = head;
    var fast = head;
    while (fast.getNext() != null && fast.getNext().getNext() != null) {
      slow = slow.getNext();
      fast = fast.getNext().getNext();
    }
    return slow;
  }

  private static LinkNode<Integer> reverse(LinkNode<Integer> head) {
    if (head == null || head.getNext() == null) return head;
    LinkNode<Integer> prev = null;
    var current = head;
    while (current != null) {
      var next = current.getNext();
      current.setNext(prev);
      prev = current;
      current = next;
    }
    return prev;
  }

  /**
   * Find mid node by slow and fast pointer Add all the nodes after middle node to stack Remove
   * elements from stack one by one and check in the linked list current node if equal increase
   * current node to next node of linked list if not equal return false once stack is empty 1. check
   * if slow pointer is same as current node ( for case when odd number of elements) 2. check if
   * slow pointer next is same as current node ( for case when even number of elements)
   */
  public static boolean isPalindromeWithStack(LinkedList<Integer> linkedList) {
    var slower = linkedList.getHead();
    var faster = linkedList.getHead();

    while (faster.getNext() != null && faster.getNext().getNext() != null) {
      slower = slower.getNext();
      faster = faster.getNext().getNext();
    }

    var startOfRightPart = slower.getNext();
    var stack = new LinkedList<Integer>();
    while (startOfRightPart != null) {
      stack.addFirst(startOfRightPart.getData());
      startOfRightPart = startOfRightPart.getNext();
    }

    var currentNode = linkedList.getHead();
    while (stack.getSize() != 0) {
      var node = stack.removeFirst();
      if (!currentNode.getData().equals(node)) {
        return false;
      }
      currentNode = currentNode.getNext();
    }

    if (slower.getNext() == currentNode || slower == currentNode) {
      return true;
    } else {
      return false;
    }
  }
}
