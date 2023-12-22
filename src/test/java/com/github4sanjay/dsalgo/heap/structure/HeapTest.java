package com.github4sanjay.dsalgo.heap.structure;

import java.util.Comparator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class HeapTest {

  @Test
  public void test() {
    var heap = new Heap<Integer>();
    heap.add(10);
    heap.add(20);
    heap.add(30);
    Assertions.assertEquals(10, heap.peek());
    heap.add(50);
    heap.add(5);
    heap.add(8);
    heap.add(11);
    heap.add(70);

    Assertions.assertEquals(5, heap.peek());
    Assertions.assertEquals(5, heap.get());
    Assertions.assertEquals(8, heap.peek());
  }

  @Test
  public void testCustomComparator() {
    var heap = new Heap<>((Comparator<Integer>) (o1, o2) -> -o1.compareTo(o2));
    heap.add(10);
    heap.add(20);
    heap.add(30);
    Assertions.assertEquals(30, heap.peek());
    heap.add(50);
    heap.add(5);
    heap.add(8);
    heap.add(11);
    heap.add(70);

    Assertions.assertEquals(70, heap.peek());
    Assertions.assertEquals(70, heap.get());
    Assertions.assertEquals(50, heap.peek());
  }
}
