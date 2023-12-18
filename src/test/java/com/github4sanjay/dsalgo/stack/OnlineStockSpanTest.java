package com.github4sanjay.dsalgo.stack;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class OnlineStockSpanTest {

  @Test
  public void testStockSpan() {
    assertArrayEquals(
        new int[] {1, 1, 1, 2, 1, 4, 6}, StockSpan.find(new int[] {100, 80, 60, 70, 60, 75, 85}));
    assertArrayEquals(
        new int[] {1, 1, 2, 4, 5, 1}, StockSpan.find(new int[] {10, 4, 5, 90, 120, 80}));
    assertArrayEquals(
        new int[] {1, 2, 3, 1, 1, 6, 1, 2, 1},
        StockSpan.find(new int[] {2, 5, 9, 3, 1, 12, 6, 8, 7}));
  }

  @Test
  public void test() {
    var stockSpanner = new OnlineStockSpan.StockSpanner();
    var input1 = new int[] {100, 80, 60, 70, 60, 75, 85};
    var expected = new int[] {1, 1, 1, 2, 1, 4, 6};
    for (int i = 0; i < input1.length; i++) {
      var price = input1[i];
      Assertions.assertEquals(expected[i], stockSpanner.next(price));
    }
  }
}
