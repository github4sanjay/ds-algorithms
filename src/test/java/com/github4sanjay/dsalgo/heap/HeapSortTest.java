package com.github4sanjay.dsalgo.heap;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class HeapSortTest {

  @Test
  public void test() {
    var array = new int[] {2, 8, 6, 34, 1, 7};
    Assertions.assertArrayEquals(new int[] {1, 2, 6, 7, 8, 34}, HeapSort.heapSort(array));
  }
}
