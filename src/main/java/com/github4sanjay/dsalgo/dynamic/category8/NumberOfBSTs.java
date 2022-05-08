package com.github4sanjay.dsalgo.dynamic.category8;

/**
 * 1. You are given a number n, representing the number of elements. 2. You are required to find the
 * number of Binary Search Trees you can create using the elements.
 */
public class NumberOfBSTs {

  public static void main(String[] args) {
    System.out.println(NumberOfBSTs.find(4));
  }

  /**
   * when n, 0 = 1 1 = 1 2 {10,20} = 2 10 20 / \ 20 10
   *
   * <p>3 {10,20,30} 10 20 30 \ / \ / {10, 20} {10}{30} {10,20}
   *
   * <p>4 {10,20,30,40} 10 20 30 40 / \ / \ / \ \ {10,20,30} {10} {30,40} {10,20} {40} {20,30,40}
   * C0*C3 + C1*C2 + C2*C1 + C3*c1
   *
   * <p>So its catalan number
   */
  private static int find(int n) {
    return CatalanNumber.find(n);
  }
}
