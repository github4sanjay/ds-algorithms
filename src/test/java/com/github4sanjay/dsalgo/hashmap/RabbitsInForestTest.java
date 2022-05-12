package com.github4sanjay.dsalgo.hashmap;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class RabbitsInForestTest {

  @Test
  public void test() {
    Assertions.assertEquals(5, RabbitsInForest.find(new int[] {1, 1, 2}));
    Assertions.assertEquals(11, RabbitsInForest.find(new int[] {10, 10, 10}));
    Assertions.assertEquals(5, RabbitsInForest.find(new int[] {1, 0, 1, 0, 0}));
  }
}
