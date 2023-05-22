package com.github4sanjay.dsalgo.java.concurrency;

import java.util.concurrent.RecursiveTask;

public class ForkJoinTest {

  public static void main(String[] args) {
    System.out.println(new Fibonacci(10).compute());
  }

  private static class Fibonacci extends RecursiveTask<Integer> {

    final int n;

    public Fibonacci(int n) {
      this.n = n;
    }

    @Override
    protected Integer compute() {
      if (n <= 1) {
        return n;
      }
      var f1 = new Fibonacci(n - 1);
      f1.fork();
      var f2 = new Fibonacci(n - 2);
      f2.fork();
      return f1.join() + f2.join();
    }
  }
}
