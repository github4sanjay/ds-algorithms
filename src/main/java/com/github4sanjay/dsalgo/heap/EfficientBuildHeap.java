package com.github4sanjay.dsalgo.heap;

import com.github4sanjay.dsalgo.heap.structure.Heap;

public class EfficientBuildHeap {

  public static Heap<Integer> buildHeap(int[] A) {
    var heap = new Heap<Integer>();
    for (int i = 0; i < A.length; i++) {
      heap.add(A[i]);
    }
    int lastLeaf = heap.getSize() - 1;
    // start from parent of last leaf node
    for (int i = (lastLeaf - 1) / 2; i >= 0; i--) {
      heap.percolateDown(i);
    }
    return heap;
  }
}
