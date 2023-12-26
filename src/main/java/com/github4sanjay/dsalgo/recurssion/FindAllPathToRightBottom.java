package com.github4sanjay.dsalgo.recurssion;

public class FindAllPathToRightBottom {

  public static void find(int[][] arr) {
    find(arr, 0, 0, "", new int[arr.length][arr[0].length]);
  }

  private static void find(int[][] arr, int srcRow, int srcCol, String ans, int[][] visited) {
    if (srcRow < 0
        || srcCol < 0
        || srcRow == arr.length
        || srcCol == arr[0].length
        || arr[srcRow][srcCol] == 1
        || visited[srcRow][srcCol] == 1) {
      return;
    }

    if (srcRow == arr.length - 1 && srcCol == arr[0].length - 1) {
      System.out.println(ans);
      return;
    }

    visited[srcRow][srcCol] = 1;

    find(arr, srcRow - 1, srcCol, ans + "t", visited);
    find(arr, srcRow, srcCol - 1, ans + "l", visited);
    find(arr, srcRow + 1, srcCol, ans + "d", visited);
    find(arr, srcRow, srcCol + 1, ans + "r", visited);

    visited[srcRow][srcCol] = 0;
  }
}
