package com.github4sanjay.dsalgo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TheJungleBookTest {

  @Test
  public void find() {
    Assertions.assertEquals(5, TheJungleBook.find(new int[] {-1, 8, 6, 0, 7, 3, 8, 9, -1, 6, 1}));
  }
}
