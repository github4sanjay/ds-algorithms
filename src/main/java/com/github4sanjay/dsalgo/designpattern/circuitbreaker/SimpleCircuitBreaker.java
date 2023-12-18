package com.github4sanjay.dsalgo.designpattern.circuitbreaker;

public class SimpleCircuitBreaker implements CircuitBreaker {

  private int failureThreshold;
  private int failureCount;

  public SimpleCircuitBreaker(int failureThreshold) {
    this.failureThreshold = failureThreshold;
    this.failureCount = 0;
  }

  @Override
  public boolean allowExecution() {
    if (failureCount >= failureThreshold) {
      return false;
    }
    return true;
  }

  @Override
  public void onSuccess() {
    failureCount = 0;
  }

  @Override
  public void onFailure() {
    failureCount++;
  }
}
