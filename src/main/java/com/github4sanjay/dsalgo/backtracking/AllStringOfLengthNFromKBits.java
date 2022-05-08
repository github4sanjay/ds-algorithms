package com.github4sanjay.dsalgo.backtracking;

/**
 * U have 5 places and unlimited red green and blue balls what are the combinations possible write
 * program for this Like- ggg, ggb, gbb etc
 */
public class AllStringOfLengthNFromKBits {

  public static void binary(int n, int k, int[] A, String str) {
    if (n < 1) {
      String tempStr = "";
      boolean last = false;
      for (int i = 0; i < A.length; i++) {
        tempStr = tempStr.concat(String.valueOf(str.charAt(A[i])));
        if (tempStr.length() > 1
            && tempStr.charAt(tempStr.length() - 2) == tempStr.charAt(tempStr.length() - 1)) {
          last = true;
          break;
        }
      }
      if (!last && tempStr.length() == A.length) {
        System.out.println(tempStr);
      }

    } else {
      for (int j = 0; j < k; j++) {
        A[n - 1] = j;
        binary(n - 1, k, A, str);
      }
    }
  }

  public static void main(String[] args) {
    int n = 5;
    int[] A = new int[n];
    binary(n, 3, A, "rbg");
  }
}
