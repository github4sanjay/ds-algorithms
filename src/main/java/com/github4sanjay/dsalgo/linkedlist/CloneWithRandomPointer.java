package com.github4sanjay.dsalgo.linkedlist;

import java.util.HashMap;
import lombok.Getter;
import lombok.Setter;

/**
 * Given a linked list having two pointers in each node. The first one points to the next node of
 * the list, however, the other pointer is random and can point to any node of the list.
 */
public class CloneWithRandomPointer {

  public static void main(String[] args) {}

  //  O(1) space, i.e., without any extra space.
  public Node<Integer> cloneWithoutExtraSpace(Node<Integer> root) {
    var curr = root;
    while (curr != null) {
      var newNode = new Node<>(curr.getData());
      newNode.setNext(curr.getNext());
      curr.setNext(newNode);
      curr = curr.getNext();
    }

    curr = root;
    while (curr != null) {
      if (curr.getNext() != null) {
        curr.getNext().setRandom(curr.getRandom() != null ? curr.getRandom().getNext() : null);
      }
      curr = curr.getNext() != null ? curr.getNext().getNext() : null;
    }

    curr = root;
    var clonedCurr = root.getNext();
    var clonedRoot = clonedCurr;
    while (curr != null && clonedCurr != null) {
      curr.setNext(curr.getNext() != null ? curr.getNext().getNext() : null);
      curr = curr.getNext() != null ? curr.getNext().getNext() : null;

      clonedCurr.setNext(clonedCurr.getNext() != null ? clonedCurr.getNext().getNext() : null);
      clonedCurr = clonedCurr.getNext() != null ? clonedCurr.getNext().getNext() : null;
    }

    return clonedRoot;
  }

  //  o(n) space complexity
  public Node<Integer> cloneWithExtraSpace(Node<Integer> root) {
    var map = new HashMap<Node<Integer>, Node<Integer>>();
    var curr = root;
    while (curr != null) {
      map.put(curr, new Node<>(curr.getData()));
      curr = curr.getNext();
    }

    curr = root;
    var clonedRoot = map.get(root);
    while (curr != null) {
      var clonedCurr = map.get(curr);
      clonedCurr.setNext(map.get(curr.getNext()));
      clonedCurr.setRandom(map.get(curr.getRandom()));
      curr = curr.getNext();
    }

    return clonedRoot;
  }

  @Setter
  @Getter
  public static class Node<T> {
    private T data;
    private Node<T> next;
    private Node<T> random;

    public Node(T data) {
      this.data = data;
    }
  }
}
