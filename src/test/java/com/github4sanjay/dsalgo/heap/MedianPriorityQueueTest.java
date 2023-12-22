package com.github4sanjay.dsalgo.heap;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MedianPriorityQueueTest {

  @Test
  public void test() {
    var queue = new MedianPriorityQueue();
    queue.add(10);
    Assertions.assertEquals(10, queue.getMedian());
    queue.add(20);
    Assertions.assertEquals(10, queue.getMedian());
    queue.add(30);
    Assertions.assertEquals(20, queue.getMedian());
    queue.add(40);
    Assertions.assertEquals(20, queue.getMedian());
    queue.add(5);
    Assertions.assertEquals(20, queue.getMedian());
    queue.add(50);
    Assertions.assertEquals(20, queue.getMedian());
    queue.remove();
    Assertions.assertEquals(30, queue.getMedian());
  }
}
