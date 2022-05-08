package com.github4sanjay.dsalgo.recurssion;

public class PrintNumber {

  public static void main(String[] args) {
    // PrintNumber.printDecreasing(5);
    // PrintNumber.printIncreasing(5);
    PrintNumber.printDecreasingIncreasing(5);
  }

  /** when input 5 output: 5 4 3 2 1 0 */
  private static void printDecreasing(int i) {
    if (i < 0) {
      return;
    }
    System.out.println(i);
    printDecreasing(i - 1);
  }

  private static void printIncreasing(int i) {
    if (i < 0) {
      return;
    }
    printIncreasing(i - 1);
    System.out.println(i);
  }

  private static void printDecreasingIncreasing(int i) {
    if (i < 0) {
      return;
    }
    System.out.println(i);
    printDecreasingIncreasing(i - 1);
    System.out.println(i);
  }
}
