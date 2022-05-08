package com.github4sanjay.dsalgo.hashmap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GetCommonElements1 {

  public static void main(String[] args) {
    System.out.println(
        GetCommonElements1.get(new int[] {1, 2, 3, 4, 5}, new int[] {5, 6, 7, 8, 9}));
  }

  private static List<Integer> get(int[] array1, int[] array2) {
    var map = new HashMap<Integer, Boolean>();
    for (int i : array1) {
      map.put(i, true);
    }
    var list = new ArrayList<Integer>();
    for (int i : array2) {
      if (map.containsKey(i)) {
        list.add(i);
      }
    }
    return list;
  }
}
