package com.github4sanjay.dsalgo.stack;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class InfixEvaluationTest {

  @Test
  public void testInfixEvaluation() {
    assertEquals(2, InfixEvaluation.calculate("2 + 6 * 4 / 8 - 3"));
    assertEquals(1, InfixEvaluation.calculate("1 * ( 2 + 2 ) / 4"));
    assertEquals(10, InfixEvaluation.calculate("1 + 2 * 3 + 3"));
    assertEquals(9, InfixEvaluation.calculate("6 / 2 * (1 + 2)"));
    assertEquals(1, InfixEvaluation.calculate("3 + 4 * 2 / (1 - 5)"));
  }
}
