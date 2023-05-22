package com.github4sanjay.dsalgo.java.stream;

import java.util.*;

public class FindSecondHighestNumberFromArray {

  public static void main(String[] args) {
    System.out.println(get(new int[] {5, 9, 11, 2, 8, 21, 1}));
  }

  private static Integer get(int[] arr) {
    return Arrays.stream(arr)
        .boxed()
        .sorted(Comparator.reverseOrder())
        .skip(1)
        .findFirst()
        .orElse(null);
  }
}
