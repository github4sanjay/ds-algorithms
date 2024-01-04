package com.github4sanjay.dsalgo.dynamic.catalan;

/*
 * Given an integer n, the task is to count Dyck words possible of length n.
 * A DYCK word is a word containing only characters ‘X’ and ‘Y’ such that in every prefix of the word frequency(‘X’) ≥ frequency(‘Y’)
 *
 * Examples:
 *
 * Input: n = 2
 * Output: 2
 * “XY” and “XX” are the only possible DYCK words of length 2.
 *
 * Input: n = 5
 * Output: 42
 */
public class DyckWords {

  public static void main(String[] args) {
    System.out.println(DyckWords.find(3));
  }

  /*
   * 0 -> 1
   * 1 -> VH
   * 2 -> VHVH, VVHH
   * 3 -> V H           V H                    V H
   *       2 inside     1 inside 1 outside        2 outside
   *       V VVHH H     V VH H VH              V H VHVH
   *       V VHVH H                            V H VVHH
   *
   */
  private static int find(int i) {
    return CatalanNumber.tabulation(i);
  }
}
