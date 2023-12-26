package com.github4sanjay.dsalgo.backtracking;

/** Generate all string of n bits / Print Permutations */
public class AllStringsOfNBitsKTypes {

  public static void print(int n, int k) {
    print(n, k, new int[n]);
  }

  private static void print(int n, int k, int[] A) {
    if (n < 1) {
      String tempStr = "";
      for (int value : A) {
        tempStr = tempStr.concat(String.valueOf(value));
      }
      System.out.println(tempStr);
    } else {
      for (int j = 0; j < k; j++) {
        A[n - 1] = j;
        print(n - 1, k, A);
      }
    }
  }
}
