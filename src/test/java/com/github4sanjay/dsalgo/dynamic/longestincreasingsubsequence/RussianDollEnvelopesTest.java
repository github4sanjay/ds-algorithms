package com.github4sanjay.dsalgo.dynamic.longestincreasingsubsequence;

import static com.github4sanjay.dsalgo.dynamic.longestincreasingsubsequence.RussianDollEnvelopes.maxEnvelopes;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class RussianDollEnvelopesTest {

  @Test
  public void test() {
    Assertions.assertEquals(3, maxEnvelopes(new int[][] {{5, 4}, {6, 4}, {6, 7}, {2, 3}})); // 3
    Assertions.assertEquals(
        5,
        maxEnvelopes(
            new int[][] {
              {17, 5}, {26, 18}, {25, 34}, {48, 84}, {63, 72}, {42, 86}, {9, 55}, {4, 70}, {21, 45},
              {68, 76}, {58, 51}
            })); // 5
  }
}
