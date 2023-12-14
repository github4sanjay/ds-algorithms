package com.github4sanjay.dsalgo.array;

import java.util.ArrayList;
import java.util.List;

public class SubsetOfArray {

  public static List<String> find(int[] arr) {
    var result = new ArrayList<String>();
    int size = (int) Math.pow(2, arr.length);
    for (int i = 0; i < size; i++) {
      StringBuilder subset = new StringBuilder();
      int tempI = i;
      for (int j = arr.length - 1; j >= 0; j--) {
        int remainder = tempI % 2;
        tempI = tempI / 2;
        if (remainder == 1) {
          subset.insert(0, arr[j]);
        }
      }
      result.add(subset.toString());
    }
    return result;
  }
}
