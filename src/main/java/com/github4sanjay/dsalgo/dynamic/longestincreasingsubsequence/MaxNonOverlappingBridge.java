package com.github4sanjay.dsalgo.dynamic.longestincreasingsubsequence;

import java.util.ArrayList;
import java.util.Collections;

/*
 * Consider a 2-D map with a horizontal river passing through its center.
 * There are n cities on the southern bank with x-coordinates a(1) … a(n) and n cities on the northern bank with x-coordinates b(1) … b(n).
 * You want to connect as many north-south pairs of cities as possible with bridges such that no two bridges cross.
 * When connecting cities, you can only connect city a(i) on the northern bank to city b(i) on the southern bank.
 * Maximum number of bridges that can be built to connect north-south pairs with the aforementioned constraints.
 *
 * The values in the upper bank can be considered as the northern x-coordinates of the cities and the values in the
 * bottom bank can be considered as the corresponding southern x-coordinates of the cities to which the northern x-coordinate city can be connected.
 *
 * Examples:
 *
 * Input : 6 4 2 1
 *         2 3 6 5
 * Output : Maximum number of bridges = 2
 * Explanation: Let the north-south x-coordinates
 * be written in increasing order.
 *
 * 1  2  3  4  5  6
 *   \  \
 *    \  \        For the north-south pairs
 *     \  \       (2, 6) and (1, 5)
 *      \  \      the bridges can be built.
 *       \  \     We can consider other pairs also,
 *        \  \    but then only one bridge can be built
 *         \  \   because more than one bridge built will
 *          \  \  then cross each other.
 *           \  \
 * 1  2  3  4  5  6
 *
 * Input : 8, 1, 4, 3, 5, 2, 6, 7
 *         1, 2, 3, 4, 5, 6, 7, 8
 * Output : Maximum number of bridges = 5
 *
 */
public class MaxNonOverlappingBridge {

  /*
     brute force approach will need to find all subsets 2^n and then n2 to find which is valid
     LIS solution :
         sort first on north basis so it is always increasing
         then calculate lis based on south
  */
  public static int find(int[] north, int[] south) {
    var bridges = new ArrayList<Bridge>();
    for (int i = 0; i < north.length; i++) {
      bridges.add(new Bridge(north[i], south[i]));
    }
    Collections.sort(bridges);

    int[] dp = new int[bridges.size()];
    dp[0] = 1;
    int max = 1;
    for (int i = 1; i < bridges.size(); i++) {
      var currentBridge = bridges.get(i);
      int localMax = Integer.MIN_VALUE;
      for (int j = 0; j < i; j++) {
        var comparingBridge = bridges.get(j);
        if (currentBridge.south > comparingBridge.south) {
          localMax = Math.max(localMax, dp[j]);
        }
      }

      if (localMax == Integer.MIN_VALUE) {
        dp[i] = 1;
      } else {
        dp[i] = localMax + 1;
      }

      max = Math.max(max, dp[i]);
    }
    return max;
  }

  private static class Bridge implements Comparable<Bridge> {
    Integer north;
    Integer south;

    public Bridge(int north, int south) {
      this.north = north;
      this.south = south;
    }

    @Override
    public int compareTo(Bridge o) {
      if (!this.north.equals(o.north)) { // if north not equal sort on basis of north
        return this.north.compareTo(o.north);
      } else { // else sort on basis of south
        return this.south.compareTo(o.south);
      }
    }
  }
}
