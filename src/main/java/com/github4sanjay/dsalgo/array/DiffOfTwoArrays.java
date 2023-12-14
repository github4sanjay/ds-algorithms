package com.github4sanjay.dsalgo.array;

public class DiffOfTwoArrays {

  public static void main(String[] args) {
    System.out.println(DiffOfTwoArrays.find(new int[] {9, 5, 4, 9}, new int[] {2, 1, 4})); //
    System.out.println(
        DiffOfTwoArrays.find(new int[] {3, 1, 0, 7, 5, 0, 0}, new int[] {1, 1, 1, 1, 1, 1})); //
  }

  private static int find(int[] a2, int[] a1) {
    int i = a1.length - 1;
    int j = a2.length - 1;
    int k = a2.length - 1;
    int[] diff = new int[a2.length];
    int c = 0;
    while (k >= 0) {
      int alv = i >= 0 ? a1[i] : 0;
      int d = 0;
      if (a2[j] + c >= alv) {
        d = a2[j] + c - alv;
        c = 0;
      } else {
        d = a2[j] + c + 10 - alv;
        c = -1;
      }
      diff[k] = d;
      i--;
      j--;
      k--;
    }

    int idx = 0;
    while (idx < diff.length) {
      if (diff[idx] == 0) {
        idx++;
      } else {
        break;
      }
    }
    StringBuilder s = new StringBuilder();
    while (idx < diff.length) {
      s.append(diff[idx]);
      idx++;
    }

    return Integer.parseInt(s.toString());
  }
}
