package com.github4sanjay.dsalgo.dynamic;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class WeightedJobSchedulingTest {

  @Test
  void phoneCalls() {
    Assertions.assertEquals(
        250,
        WeightedJobScheduling.find(
            new int[][] {
              {1, 2, 50},
              {3, 5, 20},
              {6, 19, 100},
              {2, 100, 200}
            }));

    Assertions.assertEquals(
        420,
        WeightedJobScheduling.find(
            new int[][] {
              {2, 5, 50},
              {1, 2, 20},
              {6, 9, 70},
              {2, 50, 400}
            }));
  }
}
