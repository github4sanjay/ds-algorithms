package com.github4sanjay.dsalgo.dynamic.category8;

/*
 * Count ways to divide circle using N non-intersecting chords
 *
 * Given a number N, find the number of ways you can draw N chords in a circle with 2*N points such that no 2 chords intersect.
 * Two ways are different if there exists a chord which is present in one way and not in other.
 *
 * Examples:
 *
 * Input : N = 2
 * Output : 2
 * Explanation: If points are numbered 1 to 4 in
 * clockwise direction, then different ways to
 * draw chords are:
 * {(1-2), (3-4)} and {(1-4), (2-3)}
 *
 *
 * Input : N = 1
 * Output : 1
 * Explanation: Draw a chord between points 1 and 2.
 */
public class CircleAndChords {

  public static void main(String[] args) {
    System.out.println(CircleAndChords.find(4));
  }

  /** Check circle-and-chords.png for explanation */
  private static int find(int n) {
    return CatalanNumber.find(n);
  }
}
