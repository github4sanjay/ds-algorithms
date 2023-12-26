package com.github4sanjay.dsalgo.backtracking;

/** Generate all string of n bits / Print Permutations */
public class AllStringsOfNBits {

  private static void print(int n, int[] A, String str) {
    if (n < 1) {
      String tempStr = "";
      for (int value : A) {
        tempStr = tempStr.concat(String.valueOf(str.charAt(value)));
      }
      System.out.println(tempStr);
    } else {
      for (int j = 0; j < str.length(); j++) {
        A[n - 1] = j;
        print(n - 1, A, str);
      }
    }
  }

  public static void print(int n, String str) {
    int[] A = new int[n];
    print(n, A, str);
  }
}
