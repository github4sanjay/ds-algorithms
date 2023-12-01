package com.github4sanjay.dsalgo.cache;

import java.util.HashMap;
import java.util.Map;

public class LRU {

  int capacity;
  Map<Integer, Node> cache;
  Node head, tail;

  public LRU(int capacity) {
    this.capacity = capacity;
    this.cache = new HashMap<>();
    this.head = new Node();
    this.tail = new Node();

    this.head.next = this.tail;
    this.tail.prev = this.head;
  }

  public int get(int key) {
    Node node = cache.get(key);
    if (node == null) return -1;
    else {
      moveToFront(node);
      return node.value;
    }
  }

  public void put(int key, int value) {
    Node node = cache.get(key);
    if (node == null) {
      node = new Node();
      node.key = key;
      node.value = value;

      if (cache.size() == capacity) {
        Node lruNode = tail.prev;
        cache.remove(lruNode.key);
        remove(lruNode);
      }
      cache.put(key, node);
      addFirst(node);
    } else {
      node.value = value;
      moveToFront(node);
    }
  }

  public static class Node {
    Node prev, next;
    int key, value;
  }

  private void addFirst(Node node) {
    node.next = tail;
    node.prev = head;
    head.next = node;
    tail.prev = node;
  }

  private void remove(Node node) {
    node.prev.next = node.next;
    node.next.prev = node.prev;
    node.next = node.prev = null;
  }

  private void moveToFront(Node node) {
    remove(node);
    addFirst(node);
  }

  public static void main(String[] args) {
    var lru = new LRU(3);
    lru.put(1, 10);
    lru.put(2, 20);
    lru.put(3, 30);
    System.out.println(lru.get(1));
    lru.put(1, 15);
    System.out.println(lru.get(1));
    System.out.println(lru.get(2));
    lru.put(4, 40);
    System.out.println(lru.get(3));
    System.out.println(lru.get(4));
  }
}
