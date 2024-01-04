package com.github4sanjay.dsalgo.dynamic.longestincreasingsubsequence;

import java.util.ArrayList;
import java.util.Collections;

/*
 * You have a number of envelopes with widths and heights given as a pair of integers (w, h).
 * One envelope can fit into another if and only if both the width and height of one envelope is greater than the width and height of the other envelope.
 *
 * What is the maximum number of envelopes can you Russian doll? (put one inside other)
 *
 * Note:
 * Rotation is not allowed.
 *
 * Example:
 *
 * Input: [[5,4],[6,4],[6,7],[2,3]]
 * Output: 3
 * Explanation: The maximum number of envelopes you can Russian doll is 3 ([2,3] => [5,4] => [6,7]).
 */
public class RussianDollEnvelopes {

  public static class Envelope implements Comparable<Envelope> {
    Integer width;
    Integer height;

    public Envelope(Integer width, Integer height) {
      this.width = width;
      this.height = height;
    }

    @Override
    public int compareTo(Envelope o) {
      return this.width.compareTo(o.width);
    }
  }

  public static int maxEnvelopes(int[][] envelopes) {
    var list = new ArrayList<Envelope>();
    for (int[] envelope : envelopes) {
      list.add(new Envelope(envelope[0], envelope[1]));
    }

    Collections.sort(list);
    int[] dp = new int[list.size()];
    int max = 1;
    dp[0] = 1;
    for (int i = 1; i < dp.length; i++) {
      int localMax = Integer.MIN_VALUE;
      var currentEnvelope = list.get(i);
      for (int j = 0; j < i; j++) {
        var previousEnvelope = list.get(j);
        if (currentEnvelope.height > previousEnvelope.height
            && currentEnvelope.width > previousEnvelope.width) {
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
}
