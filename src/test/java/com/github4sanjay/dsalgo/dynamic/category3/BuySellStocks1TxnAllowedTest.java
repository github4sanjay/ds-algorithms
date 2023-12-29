package com.github4sanjay.dsalgo.dynamic.category3;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class BuySellStocks1TxnAllowedTest {

  @Test
  public void test() {
    Assertions.assertEquals(
        17, BuySellStocks1TxnAllowed.find(new int[] {11, 6, 7, 19, 4, 1, 6, 18, 4}));
  }
}
