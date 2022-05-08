package com.github4sanjay.dsalgo.backtracking;

import java.util.ArrayList;
import java.util.List;

/** Tug of war */
public class MinimumSubsetSumDifference {

  static Integer min = Integer.MAX_VALUE;
  /**
   * Input: arr[] = {1, 6, 11, 5} Output: 1 Explanation: Subset1 = {1, 5, 6}, sum of Subset1 = 12
   * Subset2 = {11}, sum of Subset2 = 11
   */
  public static void main(String[] args) {

    MinimumSubsetSumDifference.tugOfWar(new int[] {1, 6, 11, 5}); // 1
    MinimumSubsetSumDifference.tugOfWar(new int[] {3, 4, 5, -3, 100, 1, 89, 54, 23, 20}); // 0
  }

  private static void tugOfWar(int[] arr) {
    var answers = new ArrayList<List<Integer>>();
    answers.add(new ArrayList<>()); // first set
    answers.add(new ArrayList<>()); // second set

    find(arr, 0, 2, answers);
    System.out.println(min);
  }

  private static void find(
      int[] arr, int index, int partitionAllowed, List<List<Integer>> answers) {
    if (arr.length == index) {
      if (partitionAllowed == 0) {
        List<Integer> set1 = answers.get(0);
        List<Integer> set2 = answers.get(1);
        int sum1 = 0, sum2 = 0;
        for (Integer integer : set1) {
          sum1 += integer;
        }

        for (Integer integer : set2) {
          sum2 += integer;
        }
        int currentMin = Math.abs(sum1 - sum2);
        if (currentMin < min) {
          min = currentMin;
        }
      }
      return;
    }

    int current = arr[index];
    for (int i = 0; i < answers.size(); i++) {
      var set = answers.get(i);
      if (set.size() > 0) {
        set.add(current);
        find(arr, index + 1, partitionAllowed, answers);
        set.remove(set.size() - 1);
      } else {
        set.add(current);
        find(arr, index + 1, partitionAllowed - 1, answers);
        set.remove(set.size() - 1);
        break;
      }
    }
  }
}
