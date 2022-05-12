package com.github4sanjay.dsalgo.hashmap.subarray;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SmallestSubarrayWithAllOccurrencesOfTheMostFrequentElementTest {

  @Test
  public void find() {
    var answer =
        SmallestSubarrayWithAllOccurrencesOfTheMostFrequentElement.find(
            new int[] {4, 1, 1, 2, 2, 1, 3, 3});
    Assertions.assertEquals(1, answer.getElement());
    Assertions.assertEquals(1, answer.getStartIndex());
    Assertions.assertEquals(5, answer.getLastIndex());
  }
}
