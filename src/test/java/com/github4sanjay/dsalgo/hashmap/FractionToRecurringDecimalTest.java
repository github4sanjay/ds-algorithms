package com.github4sanjay.dsalgo.hashmap;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class FractionToRecurringDecimalTest {

  @Test
  public void find() {
    Assertions.assertEquals("2", FractionToRecurringDecimal.find(8, 4));
    Assertions.assertEquals("18.5", FractionToRecurringDecimal.find(37, 2));
    Assertions.assertEquals("3.424", FractionToRecurringDecimal.find(428, 125));
    Assertions.assertEquals("4.(6)", FractionToRecurringDecimal.find(14, 3));
    Assertions.assertEquals("2.6(1)", FractionToRecurringDecimal.find(47, 18));
    Assertions.assertEquals("13.(285714)", FractionToRecurringDecimal.find(93, 7));
  }
}
