package com.github4sanjay.dsalgo.backtracking;

import java.util.ArrayList;
import java.util.List;

public class PartitionKSubsets {

  /**
   * Input: n = 3, k = 2 Output: 3 Explanation: Let the set be {1, 2, 3}, we can partition it into 2
   * subsets in following ways {{1,2}, {3}}, {{1}, {2,3}}, {{1,3}, {2}}
   *
   * <p>Input: n = 3, k = 1 Output: 1 Explanation: There is only one way {{1, 2, 3}}
   */
  public static void main(String[] args) {
    int n = 4, k = 2;
    PartitionKSubsets.partition(n, k);
  }

  private static void partition(int n, int k) {

    List<List<Integer>> answers = new ArrayList<>();
    for (int i = 0; i < k; i++) {
      answers.add(new ArrayList<>());
    }
    partition(n, k, 1, answers, 0);
  }

  private static void partition(
      int n, int k, int index, List<List<Integer>> answer, int noOfPartition) {

    if (index > n) {
      if (noOfPartition == k) {
        System.out.println("Answer is");
        for (List<Integer> integers : answer) {
          System.out.print(integers);
        }
      }
      System.out.println("");
      return;
    }

    for (int i = 0; i < answer.size(); i++) {
      var set = answer.get(i);
      if (!set.isEmpty()) {
        set.add(index);
        partition(n, k, index + 1, answer, noOfPartition); // no partition created
        set.remove(set.size() - 1);
      } else {
        set.add(index);
        partition(n, k, index + 1, answer, noOfPartition + 1); // partition created
        set.remove(set.size() - 1);
        break; // only first non empty its necessary because {{1,3},{2},{}} is same as
        // {{1,3},{},{2}}
      }
    }
  }
}
