package com.github4sanjay.dsalgo.linkedlist;

import com.github4sanjay.dsalgo.linkedlist.structure.LinkNode;
import com.github4sanjay.dsalgo.linkedlist.structure.LinkedList;

/**
 * Given a singly linkedlist : l0 -> ln -> l1 -> ln-1 -> l2 -> ln-2 -> l3 -> ln-3 -> ..... reorder
 * it : l0 -> l1 -> l2 -> l3 -> l4 -> l5 -> l6 ..... -> ln-1 -> ln for more information watch video.
 *
 * <p>Constraints 0 <= N <= 10^6
 *
 * <p>Format Input 1->7->2->6->3->5->4->null
 *
 * <p>Output 1->2->3->4->5->6->7->null
 *
 * <p>Example Sample Input
 *
 * <p>9 5 1 1 4 4 6 6 9 9
 *
 * <p>Sample Output 5 1 4 6 9 9 6 4 1
 */
public class UnfoldLinkedList {

  public static void main(String[] args) {
    LinkedList<Integer> linkedList = new LinkedList<>();
    linkedList.addLast(1);
    linkedList.addLast(8);
    linkedList.addLast(2);
    linkedList.addLast(7);
    linkedList.addLast(3);
    linkedList.addLast(6);
    linkedList.addLast(4);
    linkedList.addLast(5);

    UnfoldLinkedList.unfold(linkedList.getHead());

    linkedList.print();

    LinkedList<Integer> linkedList2 = new LinkedList<>();
    linkedList2.addLast(1);
    linkedList2.addLast(5);
    linkedList2.addLast(2);
    linkedList2.addLast(4);
    linkedList2.addLast(3);

    UnfoldLinkedList.unfold(linkedList2.getHead());

    linkedList2.print();
  }

  public static LinkNode<Integer> unfold(LinkNode<Integer> head) {
    if (head == null || head.getNext() == null) return head;
    var firstHead = head;
    var secondHead = head.getNext();

    var firsPrev = firstHead;
    var secondPrev = secondHead;
    while (secondPrev != null && secondPrev.getNext() != null) {
      var forward = secondPrev.getNext();
      firsPrev.setNext(forward);
      secondPrev.setNext(forward.getNext());
      firsPrev = firsPrev.getNext();
      secondPrev = secondPrev.getNext();
    }
    firsPrev.setNext(null);
    secondHead = reverse(secondHead);
    firsPrev.setNext(secondHead);
    return head;
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
