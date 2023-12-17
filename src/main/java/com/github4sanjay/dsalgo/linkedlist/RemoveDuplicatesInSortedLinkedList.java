package com.github4sanjay.dsalgo.linkedlist;

import com.github4sanjay.dsalgo.linkedlist.structure.LinkNode;
import com.github4sanjay.dsalgo.linkedlist.structure.LinkedList;
import java.util.HashMap;

public class RemoveDuplicatesInSortedLinkedList {

  public static <T extends Comparable<T>> void remove(LinkNode<T> head) {
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

  public static <T extends Comparable<T>> LinkedList<T> removeCreatingNewLinkedList(
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

  public static <T> LinkNode<T> removeWithMap(LinkNode<T> head) {
    var map = new HashMap<T, Boolean>();
    var prev = head;
    map.put(prev.getData(), true);
    var current = head.getNext();
    while (current != null) {
      if (map.get(current.getData()) != null) {
        prev.setNext(current.getNext());
      } else {
        map.put(current.getData(), true);
      }
      prev = current;
      current = current.getNext();
    }
    return head;
  }
}
