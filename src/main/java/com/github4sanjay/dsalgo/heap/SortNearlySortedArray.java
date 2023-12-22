package com.github4sanjay.dsalgo.heap;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class SortNearlySortedArray {

  public static List<Integer> sortNearlySortedArray(int[] A, int k) {
    var list = new ArrayList<Integer>();
    var queue = new PriorityQueue<Integer>();
    for (int i = 0; i <= k; i++) {
      queue.add(A[i]);
    }
    for (int i = k + 1; i < A.length; i++) {
      list.add(queue.remove());
      queue.add(A[i]);
    }

    while (queue.size() > 0) {
      list.add(queue.remove());
    }
    return list;
  }

  public static void main(String[] args) {
    System.out.println(
        SortNearlySortedArray.sortNearlySortedArray(new int[] {2, 3, 1, 4, 6, 7, 5, 8, 9}, 2));
  }
}
