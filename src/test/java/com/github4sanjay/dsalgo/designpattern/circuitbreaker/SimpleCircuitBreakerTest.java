package com.github4sanjay.dsalgo.designpattern.circuitbreaker;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class SimpleCircuitBreakerTest {

  @Test
  public void testCircuitBreakerOpen() {
    CircuitBreaker circuitBreaker = new SimpleCircuitBreaker(3); // Set a failure threshold of 3

    assertTrue(circuitBreaker.allowExecution());

    circuitBreaker.onFailure();
    circuitBreaker.onFailure();
    circuitBreaker.onFailure();

    assertFalse(circuitBreaker.allowExecution()); // Circuit breaker should be open now
  }

  @Test
  public void testCircuitBreakerClosedAfterSuccess() {
    CircuitBreaker circuitBreaker = new SimpleCircuitBreaker(2); // Set a failure threshold of 2

    assertTrue(circuitBreaker.allowExecution());

    circuitBreaker.onFailure();
    circuitBreaker.onFailure();

    assertFalse(circuitBreaker.allowExecution()); // Circuit breaker should be open

    circuitBreaker.onSuccess();

    assertTrue(circuitBreaker.allowExecution()); // Circuit breaker should be closed after success
  }
}
