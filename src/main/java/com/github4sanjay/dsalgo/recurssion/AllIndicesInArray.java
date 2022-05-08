package com.github4sanjay.dsalgo.recurssion;

import java.util.Arrays;

public class AllIndicesInArray {

  public static void main(String[] args) {
    var result =
        AllIndicesInArray.find(
            new int[] {3, 4, 5, 6, 5, 6, 8, 9, 2
              // 0,1,2,3,  4, 5, 6, 7, 8
            },
            0,
            5,
            0);
    System.out.println(Arrays.toString(result)); // [2, 4]
  }

  private static int[] find(int[] ints, int currentIndex, int n, int foundSoFar) {
    if (currentIndex == ints.length) {
      return new int[foundSoFar];
    }
    if (ints[currentIndex] == n) {
      foundSoFar++;
    }
    int[] filledSoFar = find(ints, currentIndex + 1, n, foundSoFar);
    if (ints[currentIndex] == n) {
      foundSoFar--;
      filledSoFar[foundSoFar] = currentIndex;
    }
    return filledSoFar;
  }
}
