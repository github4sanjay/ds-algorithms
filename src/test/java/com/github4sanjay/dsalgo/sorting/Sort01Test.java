package com.github4sanjay.dsalgo.sorting;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Sort01Test {

  @Test
  @DisplayName("Segregating 0s and 1s in an array")
  public void testSegregate0and1() {
    int[] arr = {0, 1, 0, 1, 1, 0};
    Sort01.segregate0and1(arr);
    assertArrayEquals(new int[] {0, 0, 0, 1, 1, 1}, arr);
  }

  @Test
  @DisplayName("Segregating when array has only 0s")
  public void testSegregate0and1Only0s() {
    int[] arr = {0, 0, 0, 0};
    Sort01.segregate0and1(arr);
    assertArrayEquals(new int[] {0, 0, 0, 0}, arr);
  }

  @Test
  @DisplayName("Segregating when array has only 1s")
  public void testSegregate0and1Only1s() {
    int[] arr = {1, 1, 1, 1};
    Sort01.segregate0and1(arr);
    assertArrayEquals(new int[] {1, 1, 1, 1}, arr);
  }

  @Test
  @DisplayName("Segregating when array is empty")
  public void testSegregate0and1EmptyArray() {
    int[] arr = {};
    Sort01.segregate0and1(arr);
    assertArrayEquals(new int[] {}, arr);
  }

  @Test
  @DisplayName("Segregating when array has alternating 0s and 1s")
  public void testSegregate0and1Alternating() {
    int[] arr = {0, 1, 0, 1, 0, 1};
    Sort01.segregate0and1(arr);
    assertArrayEquals(new int[] {0, 0, 0, 1, 1, 1}, arr);
  }
}
