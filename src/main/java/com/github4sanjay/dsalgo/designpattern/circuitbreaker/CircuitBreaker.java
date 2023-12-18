package com.github4sanjay.dsalgo.designpattern.circuitbreaker;

public interface CircuitBreaker {
  boolean allowExecution();

  void onSuccess();

  void onFailure();
}
