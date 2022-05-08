package com.github4sanjay.dsalgo.backtracking;

import com.github4sanjay.dsalgo.util.AlgoUtil;
import java.util.ArrayList;
import java.util.List;

public class EqualSumSubsetsKPartition {

  public static void main(String[] args) {
    /**
     * Answer is [1, 5, 5][11]
     *
     * <p>Answer is [9][4, 5][9]
     */
    int[] n1 = new int[] {1, 5, 11, 5};
    int k1 = 2;
    EqualSumSubsetsKPartition.partition(n1, k1);

    int[] n2 = new int[] {9, 4, 5, 9};
    int k2 = 3;
    EqualSumSubsetsKPartition.partition(n2, k2);
  }

  private static void partition(int[] n, int k) {
    List<List<Integer>> answers = new ArrayList<>();
    for (int i = 0; i < k; i++) {
      answers.add(new ArrayList<>());
    }
    partition(n, k, 0, answers, 0);
  }

  private static void partition(
      int[] n, int k, int index, List<List<Integer>> answers, int noOfPartition) {

    if (index > n.length - 1) {
      if (k == noOfPartition) {
        var listSum = new ArrayList<Integer>();
        for (List<Integer> integers : answers) {
          int sum = 0;
          for (int number : integers) {
            sum = sum + number;
          }
          listSum.add(sum);
        }
        if (AlgoUtil.verifyAllEqual(listSum)) {
          System.out.println("Answer is");
          for (List<Integer> integers : answers) {
            System.out.print(integers);
          }
        }
        System.out.println("");
      }
      return;
    }

    for (int i = 0; i < answers.size(); i++) {
      var set = answers.get(i);
      if (set.size() > 0) {
        set.add(n[index]);
        partition(n, k, index + 1, answers, noOfPartition);
        set.remove(set.size() - 1);
      } else {
        set.add(n[index]);
        partition(n, k, index + 1, answers, noOfPartition + 1);
        set.remove(set.size() - 1);
        break;
      }
    }
  }
}
