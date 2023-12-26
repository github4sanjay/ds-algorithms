package com.github4sanjay.dsalgo.backtracking;

/**
 * U have 5 places and unlimited red green and blue balls what are the combinations possible write
 * program for this Like- ggg, ggb, gbb etc
 */
public class PlaceColorAtNPlaceNoColorTogether {

  public static void print(int n, String str) {
    binary(n, new int[n], str);
  }

  private static void binary(int n, int[] A, String str) {
    if (n == 0) {
      String tempStr = "";
      boolean duplicate = false;
      for (int i = 0; i < A.length; i++) {
        tempStr = tempStr.concat(String.valueOf(str.charAt(A[i])));
        if (tempStr.length() > 1
            && tempStr.charAt(tempStr.length() - 2) == tempStr.charAt(tempStr.length() - 1)) {
          duplicate = true;
          break;
        }
      }
      if (!duplicate) {
        System.out.println(tempStr);
      }
    } else {
      for (int j = 0; j < str.length(); j++) {
        A[n - 1] = j;
        binary(n - 1, A, str);
      }
    }
  }
}
