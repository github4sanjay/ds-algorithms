package com.github4sanjay.dsalgo.dynamic.catalan;

/*
 * 1. You are given a number N, which represents the number of sides in a polygon. 2. You have to
 * find the total number of ways in which the given polygon can be triangulated.
 */
public class NumberOfWaysOfTriangulation {

  public static void main(String[] args) {
    System.out.print(NumberOfWaysOfTriangulation.find(4));
  }

  /** Check number-of-ways-of-triangulation.png */
  public static int find(int n) {
    if (n < 2) return 0;
    return CatalanNumber.tabulation(n - 2);
  }
}
