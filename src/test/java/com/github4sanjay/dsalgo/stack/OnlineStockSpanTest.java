package com.github4sanjay.dsalgo.stack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class OnlineStockSpanTest {

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
