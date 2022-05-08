package com.github4sanjay.dsalgo.dynamic.category1;

public class Fibonacci {

  public static void main(String[] args) {
    int n = 0;
    System.out.println(Fibonacci.findByDP(n, new int[n + 1]));
  }

  // recursion
  private static int findByRecursion(int n) {
    if (n == 0) return 0;
    if (n == 1) return 1;
    return findByRecursion(n - 2) + findByRecursion(n - 1);
  }

  private static int findByDP(int n, int[] questionBank) {
    if (n == 0) return 0;
    if (n == 1) return 1;

    if (questionBank[n] != 0) {
      return questionBank[n];
    }

    int fib1 = findByRecursion(n - 1);
    int fib2 = findByRecursion(n - 2);
    int fib = fib1 + fib2;
    questionBank[n] = fib;
    return fib;
  }
}
