package com.github4sanjay.dsalgo.backtracking;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class JosephusCircleTest {

  @Test
  public void test() {
    Assertions.assertEquals(12, JosephusCircle.find(14, 2));
    Assertions.assertEquals(2, JosephusCircle.find(5, 2));
    Assertions.assertEquals(0, JosephusCircle.find(9, 4));
    Assertions.assertEquals(3, JosephusCircle.find(7, 3));
  }
}
