package com.github4sanjay.dsalgo.stack;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CircularNGETest {

  @Test
  public void find1() {
    var answer = CircularNGE.find(new int[] {3, 1, 2, 1});
    var expectedAnswer = new int[] {-1, 2, 3, 3};
    for (int i = 0; i < expectedAnswer.length; i++) {
      Assertions.assertEquals(expectedAnswer[i], answer[i]);
    }
  }

  @Test
  public void find2() {
    var answer = CircularNGE.find(new int[] {3, 8, 4, 1, 2});
    var expectedAnswer = new int[] {8, -1, 8, 2, 3};
    for (int i = 0; i < expectedAnswer.length; i++) {
      Assertions.assertEquals(expectedAnswer[i], answer[i]);
    }
  }
}
