package com.github4sanjay.dsalgo.dynamic.fibonacci;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class FibonacciTest {

  @Test
  public void testRecursion() {
    Assertions.assertEquals(5, Fibonacci.recursion(5));
    Assertions.assertEquals(0, Fibonacci.recursion(0));
    Assertions.assertEquals(1, Fibonacci.recursion(1));
    Assertions.assertEquals(55, Fibonacci.recursion(10));
    Assertions.assertEquals(6765, Fibonacci.recursion(20));
  }

  @Test
  public void testMemoization() {
    Assertions.assertEquals(5, Fibonacci.memoization(5));
    Assertions.assertEquals(0, Fibonacci.memoization(0));
    Assertions.assertEquals(1, Fibonacci.memoization(1));
    Assertions.assertEquals(55, Fibonacci.memoization(10));
    Assertions.assertEquals(6765, Fibonacci.memoization(20));
  }

  @Test
  public void testTabulation() {
    Assertions.assertEquals(5, Fibonacci.tabulation(5));
    Assertions.assertEquals(0, Fibonacci.tabulation(0));
    Assertions.assertEquals(1, Fibonacci.tabulation(1));
    Assertions.assertEquals(55, Fibonacci.tabulation(10));
    Assertions.assertEquals(6765, Fibonacci.tabulation(20));
  }
}
