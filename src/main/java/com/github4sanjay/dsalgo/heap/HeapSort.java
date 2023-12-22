package com.github4sanjay.dsalgo.heap;

/**
 * Since time complexity of both insertion and deletion is logn and total elements is n so heap sort
 * time complexity is nlogn
 */
public class HeapSort {
  public static int[] heapSort(int[] A) {
    int[] result = new int[A.length];
    var maxHeap = EfficientBuildHeap.buildHeap(A);
    for (int i = 0; i < A.length; i++) {
      int temp = maxHeap.get();
      result[i] = temp;
    }
    return result;
  }
}
