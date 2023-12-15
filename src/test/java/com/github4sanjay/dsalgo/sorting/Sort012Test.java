package com.github4sanjay.dsalgo.sorting;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Sort012Test {

  @Test
  @DisplayName("Segregating 0s, 1s, and 2s in an array")
  public void testSegregate01And2() {
    int[] arr = {0, 1, 2, 1, 0, 2, 1};
    Sort012.segregate01And2(arr);
    assertArrayEquals(new int[] {0, 0, 1, 1, 1, 2, 2}, arr);
  }

  @Test
  @DisplayName("Segregating when array has only 0s")
  public void testSegregate01And2Only0s() {
    int[] arr = {0, 0, 0, 0};
    Sort012.segregate01And2(arr);
    assertArrayEquals(new int[] {0, 0, 0, 0}, arr);
  }

  @Test
  @DisplayName("Segregating when array has only 1s")
  public void testSegregate01And2Only1s() {
    int[] arr = {1, 1, 1, 1};
    Sort012.segregate01And2(arr);
    assertArrayEquals(new int[] {1, 1, 1, 1}, arr);
  }

  @Test
  @DisplayName("Segregating when array has only 2s")
  public void testSegregate01And2Only2s() {
    int[] arr = {2, 2, 2, 2};
    Sort012.segregate01And2(arr);
    assertArrayEquals(new int[] {2, 2, 2, 2}, arr);
  }

  @Test
  @DisplayName("Segregating when array is empty")
  public void testSegregate01And2EmptyArray() {
    int[] arr = {};
    Sort012.segregate01And2(arr);
    assertArrayEquals(new int[] {}, arr);
  }

  @Test
  @DisplayName("Segregating when array has alternating 0s, 1s, and 2s")
  public void testSegregate01And2Alternating() {
    int[] arr = {0, 1, 2, 0, 1, 2};
    Sort012.segregate01And2(arr);
    assertArrayEquals(new int[] {0, 0, 1, 1, 2, 2}, arr);
  }
}
