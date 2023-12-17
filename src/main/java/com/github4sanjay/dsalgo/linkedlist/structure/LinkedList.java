package com.github4sanjay.dsalgo.linkedlist.structure;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class LinkedList<T> {
  private LinkNode<T> head;
  private LinkNode<T> tail;
  private int size;

  public void addLast(T data) {
    var node = new LinkNode<>(data, null);
    if (size == 0) {
      head = node;
    } else {
      tail.setNext(node);
    }
    tail = node;
    size++;
  }

  public void print() {
    if (size != 0) {
      var curr = head;
      while (curr != null) {
        System.out.println(curr.getData());
        curr = curr.getNext();
      }
    }
  }

  public T removeFirst() {
    if (size == 0) {
      return null;
    } else {
      var temp = head;
      head = head.getNext();
      size--;
      if (size == 0) {
        tail = null;
      }
      return temp.getData();
    }
  }

  public void reverse() {
    if (size == 0) return;
    LinkNode<T> prev = null;
    tail = head;
    var node = head;
    while (node.getNext() != null) {
      var nextNode = node.getNext();
      node.setNext(prev);
      prev = node;
      node = nextNode;
    }
    node.setNext(prev);
    head = node;
  }

  public void reverseDataIterative() {
    int i = 0;
    int j = size - 1;
    while (i < j) {
      var left = getNodeAtIndex(i);
      var right = getNodeAtIndex(j);
      T temp = left.getData();
      left.setData(right.getData());
      right.setData(temp);
      i++;
      j--;
    }
  }

  public T getFirst() {
    if (size == 0) {
      throw new RuntimeException("Linked list is empty");
    }
    return head.getData();
  }

  public T getLast() {
    if (size == 0) {
      throw new RuntimeException("Linked list is empty");
    }
    return tail.getData();
  }

  public T getAtIndex(int i) {
    if (size == 0) {
      throw new RuntimeException("Linked list is empty");
    }
    if (i >= size) {
      throw new RuntimeException("index is greater than size");
    }
    int index = 0;
    var node = head;
    while (index < i) {
      node = node.getNext();
      index++;
    }
    return node.getData();
  }

  public void addFirst(T item) {
    var node = new LinkNode<>(item, null);
    if (size == 0) {
      head = node;
      tail = node;
    } else {
      node.setNext(head);
      head = node;
    }
    size++;
  }

  public void addAtIndex(int index, T item) {
    if (index < 0) index = 0;
    if (index > size) index = size;

    if (index == 0) {
      addFirst(item);
    } else if (index == size) {
      addLast(item);
    } else {
      int currentIndex = 0;
      var currentNode = head;
      while (currentIndex < index - 1) {
        currentNode = currentNode.getNext();
        currentIndex++;
      }

      var newNode = new LinkNode<>(item, currentNode.getNext());
      currentNode.setNext(newNode);
      size++;
    }
  }

  public T removeLast() {
    if (size == 0) {
      throw new RuntimeException("Linked list is empty");
    } else if (size == 1) {
      var data = head.getData();
      head = tail = null;
      size--;
      return data;
    } else {
      var currentNode = head;
      while (currentNode.getNext().getNext() != null) {
        currentNode = currentNode.getNext();
      }
      var lastNode = currentNode.getNext();
      tail = currentNode;
      currentNode.setNext(null);
      size--;
      return lastNode.getData();
    }
  }

  public T removeAtIndex(int index) {
    if (index < 0) index = 0;
    if (index > size) index = size;

    if (index == 0) {
      return removeFirst();
    } else if (index == size - 1) {
      return removeLast();
    } else {
      var currentNode = head;
      var currentIndex = 0;
      while (currentIndex < index - 1) {
        currentNode = currentNode.getNext();
        currentIndex++;
      }
      var removeNode = currentNode.getNext();
      currentNode.setNext(removeNode.getNext());
      size--;
      return removeNode.getData();
    }
  }

  public LinkNode<T> getNodeAtIndex(int i) {
    if (size == 0) {
      throw new RuntimeException("Linked list is empty");
    }
    if (i >= size) {
      throw new RuntimeException("index is greater than size");
    }
    int index = 0;
    var node = head;
    while (index < i) {
      node = node.getNext();
      index++;
    }
    return node;
  }

  public T getFromEnd(int k) {
    if (k > size) throw new RuntimeException("index is greater than size");
    var fasterNode = head;
    var index = 0;
    while (index < k) {
      fasterNode = fasterNode.getNext();
      index++;
    }

    var slowerNode = head;
    while (fasterNode.getNext() != null) {
      fasterNode = fasterNode.getNext();
      slowerNode = slowerNode.getNext();
    }

    return slowerNode.getData();
  }

  public T getMid() {
    if (head == null) {
      throw new RuntimeException("Linked list is empty");
    }
    if (head == tail) {
      return head.getData();
    }

    if (head.getNext() == tail) {
      return head.getData();
    }
    var fasterNode = head;
    var slowerNode = head;
    while (fasterNode.getNext() != null && fasterNode.getNext().getNext() != null) {
      fasterNode = fasterNode.getNext().getNext();
      slowerNode = slowerNode.getNext();
    }

    return slowerNode.getData();
  }

  public T removeAtIndexFromLast(int index) {
    if (index > getSize() - 1) {
      throw new RuntimeException("Invalid index");
    }
    if (index == 0) {
      return removeFirst();
    }

    if (index == getSize() - 1) {
      return removeLast();
    }
    var slowPointer = getHead();
    var fastPointer = getHead();
    for (int i = 0; i < index; i++) {
      fastPointer = fastPointer.getNext();
    }
    while (fastPointer.getNext() != null) {
      fastPointer = fastPointer.getNext();
      slowPointer = slowPointer.getNext();
    }
    var next = slowPointer.getNext();
    slowPointer.setNext(next.getNext());
    size--;
    return next.getData();
  }
}
