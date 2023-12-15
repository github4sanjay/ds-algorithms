package com.github4sanjay.dsalgo.sorting;

import com.github4sanjay.dsalgo.util.Pair;
import java.util.ArrayList;
import java.util.List;

public class TargetSumPair {

  public static void main(String[] args) {
    int[] arr = {10, 12, 10, 15, -1, 7, 6, 5, 4, 2, 1, 1, 1};
    findPair(arr, 11);

    /** output -1 , 12 1 , 10 1 , 10 4 , 7 5 , 6 */
  }

  public static List<Pair> findPair(int[] arr, int sum) {
    var list = new ArrayList<Pair>();
    arr = MergeSort.sort(arr);
    int i = 0, j = arr.length - 1;
    while (i < j) {
      if (arr[i] + arr[j] < sum) {
        i++;
      } else if (arr[i] + arr[j] > sum) {
        j--;
      } else {
        list.add(new Pair(arr[i], arr[j]));
        i++;
        j--;
      }
    }
    return list;
  }
}
