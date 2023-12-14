package com.github4sanjay.dsalgo.search;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class FirstAndLastIndexTest {

  @Test
  public void testFind() {
    int[] array1 = {1, 3, 5, 5, 5, 5, 67, 123, 125};
    int[] array2 = {1, 3, 5, 5, 5, 5, 7, 123, 125};

    FirstAndLastIndex.Pair expectedResult1 = new FirstAndLastIndex.Pair(2, 5);
    FirstAndLastIndex.Pair expectedResult2 = new FirstAndLastIndex.Pair(6, 6);

    FirstAndLastIndex.Pair result1 = FirstAndLastIndex.find(array1, 5);
    FirstAndLastIndex.Pair result2 = FirstAndLastIndex.find(array2, 7);

    assertAll(
        () -> assertEquals(expectedResult1.firstIndex, result1.firstIndex),
        () -> assertEquals(expectedResult1.lastIndex, result1.lastIndex),
        () -> assertEquals(expectedResult2.firstIndex, result2.firstIndex),
        () -> assertEquals(expectedResult2.lastIndex, result2.lastIndex));
  }
}
