package com.github4sanjay.dsalgo.linkedlist.structure;

public class LinkedListUtil {

  public static <T> LinkNode<T> getMidNode(LinkNode<T> head, LinkNode<T> tail) {
    var faster = head;
    var slower = head;

    while (faster != tail && faster.getNext() != tail) {
      faster = faster.getNext().getNext();
      slower = slower.getNext();
    }
    return slower;
  }

  public static <T extends Comparable<T>> LinkedList<T> mergeSorted(
      LinkNode<T> head1, LinkNode<T> head2) {

    var newLinkedList = new LinkedList<T>();
    while (head1 != null && head2 != null) {
      if (head1.getData().compareTo(head2.getData()) < 0) {
        newLinkedList.addLast(head1.getData());
        head1 = head1.getNext();
      } else if (head2.getData().compareTo(head1.getData()) < 0) {
        newLinkedList.addLast(head2.getData());
        head2 = head2.getNext();
      } else {
        newLinkedList.addLast(head1.getData());
        newLinkedList.addLast(head2.getData());
        head1 = head1.getNext();
        head2 = head2.getNext();
      }
    }

    if (head1 != null) {
      while (head1 != null) {
        newLinkedList.addLast(head1.getData());
        head1 = head1.getNext();
      }
    }

    if (head2 != null) {
      while (head2 != null) {
        newLinkedList.addLast(head2.getData());
        head2 = head2.getNext();
      }
    }

    return newLinkedList;
  }

  public static <T extends Comparable<T>> LinkedList<T> mergeSort(LinkedList<T> linkedList) {
    return mergeSort(linkedList.getHead(), linkedList.getTail());
  }

  private static <T extends Comparable<T>> LinkedList<T> mergeSort(
      LinkNode<T> head, LinkNode<T> tail) {
    if (head == tail) {
      var newLinkedList = new LinkedList<T>();
      newLinkedList.addFirst(head.getData());
      return newLinkedList;
    }
    var mid = LinkedListUtil.getMidNode(head, tail);
    var list1 = mergeSort(head, mid);
    var list2 = mergeSort(mid.getNext(), tail);
    return LinkedListUtil.mergeSorted(list1.getHead(), list2.getHead());
  }

  public static <T extends Comparable<T>> void removeDuplicates(LinkNode<T> head) {
    var currentNode = head;
    var prev = head;

    while (currentNode.getNext() != null) {
      var next = currentNode.getNext();
      if (next.getData().equals(currentNode.getData())) {
        currentNode = currentNode.getNext();
      } else {
        prev.setNext(next);
        prev = currentNode = next;
      }
    }

    prev.setNext(null);
  }

  public static <T extends Comparable<T>> LinkedList<T> removeDuplicatesCreatingNewLinkedList(
      LinkNode<T> head) {
    var newLinkedList = new LinkedList<T>();
    var currentNode = head;
    newLinkedList.addLast(currentNode.getData());
    currentNode = currentNode.getNext();
    while (currentNode.getNext() != null) {
      var data = currentNode.getNext().getData();
      if (!data.equals(newLinkedList.getLast())) {
        newLinkedList.addLast(data);
      }
      currentNode = currentNode.getNext();
    }
    return newLinkedList;
  }
}
