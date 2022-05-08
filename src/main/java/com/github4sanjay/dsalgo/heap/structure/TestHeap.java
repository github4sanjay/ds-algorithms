package com.github4sanjay.dsalgo.heap.structure;

import java.util.Comparator;

public class TestHeap {

  public static void main(String[] args) {
    var heap = new Heap<>((Comparator<Integer>) (o1, o2) -> -o1.compareTo(o2));
    heap.add(10);
    heap.add(20);
    heap.add(30);
    heap.add(50);
    heap.add(5);
    heap.add(8);
    heap.add(11);
    heap.add(70);

    System.out.println(heap.peek());
    System.out.println(heap.get());
    System.out.println(heap.peek());

    while (!heap.isEmpty()) {
      System.out.println(heap.get());
    }
  }
}
