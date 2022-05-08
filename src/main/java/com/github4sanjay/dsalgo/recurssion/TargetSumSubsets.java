package com.github4sanjay.dsalgo.recurssion;

import java.util.ArrayList;
import java.util.List;

public class TargetSumSubsets {
  public static void main(String[] args) {

    TargetSumSubsets.print(new int[] {10, 20, 30, 40, 50}, 70);
    var finalList = new ArrayList<List<Integer>>();
    TargetSumSubsets.find(new int[] {10, 20, 30, 40, 50}, 70, 0, new ArrayList<>(), 0, finalList);
    System.out.println(finalList);
  }

  private static void print(int[] arr, int sum) {
    print(arr, sum, 0, "", 0);
  }

  private static void print(int[] arr, int targetSum, int sum, String set, int idx) {
    if (sum < 0 || idx == arr.length) {
      if (sum == targetSum) {
        System.out.println(set);
      }
      return;
    }

    print(arr, targetSum, sum, set, idx + 1);
    print(arr, targetSum, sum + arr[idx], set + arr[idx] + ",", idx + 1);
  }

  private static void find(
      int[] arr,
      int targetSum,
      int sum,
      List<Integer> set,
      int idx,
      List<List<Integer>> finalList) {
    if (sum < 0 || idx == arr.length) {
      if (sum == targetSum) {
        finalList.add(new ArrayList<>(set));
        return;
      }
      return;
    }

    find(arr, targetSum, sum, set, idx + 1, finalList);
    set.add(arr[idx]);
    find(arr, targetSum, sum + arr[idx], set, idx + 1, finalList);
    set.remove(set.size() - 1);
  }
}
