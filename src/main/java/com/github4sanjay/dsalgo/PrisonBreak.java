package com.github4sanjay.dsalgo;

import java.util.List;

/*
   Consider a prison gate having N horizontal rods and M vertical rods.
   You are also provided with two vectors hor and ver containing the
   row number of missing horizontal rods and vertical rods respectively.
   Return the area of biggest hole in the prison gate.
   1 <= N, M <= 1000000
   1 <= hor[i] <= N
   1 <= ver[i] <= M
   All the elements of a vector are distinct
   O(N + M)
*/
public class PrisonBreak {
  public static long minimumGroups(int n, int m, List<Integer> h, List<Integer> v) {
    boolean[] xs = new boolean[n + 1];
    boolean[] ys = new boolean[m + 1];
    for (int x : h) xs[x] = true;
    for (int y : v) ys[y] = true;
    int xm = 0, ym = 0;

    // find maximum consecutive horizontal space
    for (int i = 1, j = 0; i <= n; i++) {
      if (!xs[i]) j = 0;
      else xm = Math.max(xm, ++j);
    }

    // find maximum consecutive vertical space
    for (int i = 1, j = 0; i <= m; i++) {
      if (!ys[i]) j = 0;
      else ym = Math.max(ym, ++j);
    }
    return (long) (xm + 1) * (ym + 1);
  }
}
