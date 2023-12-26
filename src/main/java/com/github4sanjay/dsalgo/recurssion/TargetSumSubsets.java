package com.github4sanjay.dsalgo.recurssion;

import java.util.ArrayList;
import java.util.List;

public class TargetSumSubsets {

  public static void print(int[] array, int targetSum) {
    print(array, targetSum, 0, "");
  }

  private static void print(int[] array, int targetSum, int index, String set) {
    if (targetSum < 0) return;
    if (targetSum == 0) {
      System.out.println(set);
      return;
    }
    if (index > array.length - 1) return;
    print(array, targetSum, index + 1, set);
    print(array, targetSum - array[index], index + 1, set + array[index] + ",");
  }

  public static List<List<Integer>> find(int[] arr, int targetSum) {
    var list = new ArrayList<List<Integer>>();
    find(arr, targetSum, new ArrayList<>(), 0, list);
    return list;
  }

  private static void find(
      int[] arr, int targetSum, List<Integer> set, int idx, List<List<Integer>> finalList) {
    if (targetSum < 0) return;
    if (targetSum == 0) {
      finalList.add(new ArrayList<>(set));
      return;
    }
    if (idx > arr.length - 1) return;
    find(arr, targetSum, set, idx + 1, finalList);
    set.add(arr[idx]);
    find(arr, targetSum - arr[idx], set, idx + 1, finalList);
    set.removeLast();
  }
}
