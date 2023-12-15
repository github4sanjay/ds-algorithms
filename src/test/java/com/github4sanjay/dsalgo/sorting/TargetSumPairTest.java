package com.github4sanjay.dsalgo.sorting;

import static org.junit.jupiter.api.Assertions.*;

import com.github4sanjay.dsalgo.util.Pair;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TargetSumPairTest {

  @Test
  @DisplayName("Finding pairs that sum up to a target")
  public void testFindPair() {
    int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
    int sum = 10;
    List<Pair> result = TargetSumPair.findPair(arr, sum);
    assertEquals(4, result.size());
  }
}
