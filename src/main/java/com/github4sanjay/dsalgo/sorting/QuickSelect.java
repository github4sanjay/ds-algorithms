package com.github4sanjay.dsalgo.sorting;

public class QuickSelect {

  public static int selectKthLargestElement(int[] A, int k) {
    return QuickSelect.selectKthLargestElement(A, k, 0, A.length - 1);
  }

  public static int selectKthLargestElement(int[] A, int k, int low, int high) {
    int partitionIndex = PartitioningArray.partition(A, A[high], low, high);
    if (k > partitionIndex) {
      return selectKthLargestElement(A, k, partitionIndex + 1, high);
    } else if (k < partitionIndex) {
      return selectKthLargestElement(A, k, low, partitionIndex - 1);
    } else {
      return A[partitionIndex];
    }
  }
}
