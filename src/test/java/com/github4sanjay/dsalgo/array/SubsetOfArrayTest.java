package com.github4sanjay.dsalgo.array;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;

class SubsetOfArrayTest {

  @Test
  public void testFind() {
    int[] arr = {1, 2, 3};
    List<String> subsets = SubsetOfArray.find(arr);

    // Expected subsets for the array {1, 2, 3}
    List<String> expectedSubsets = List.of("", "1", "2", "12", "3", "13", "23", "123");

    assertEquals(expectedSubsets.size(), subsets.size());
    assertTrue(subsets.containsAll(expectedSubsets));
  }

  @Test
  public void testFindWithEmptyArray() {
    int[] arr = {};
    List<String> subsets = SubsetOfArray.find(arr);

    // Expected subset for an empty array should contain only an empty subset
    List<String> expectedSubsets = List.of("");

    assertEquals(expectedSubsets, subsets);
  }
}
