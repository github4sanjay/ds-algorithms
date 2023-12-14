package com.github4sanjay.dsalgo.array;

public class BarChart {

  public static void main(String[] args) {
    process(new int[] {1, 2, 3, 4, 5});
    processAlt(new int[] {3, 2, 7, 0, 5});
  }

  public static void process(int[] arr) {
    var max = Integer.MIN_VALUE;
    for (var item : arr) {
      max = Math.max(max, item);
    }

    for (int i = max; i > 0; i--) {
      for (int j = 0; j < arr.length; j++) {
        if (arr[j] >= i) {
          System.out.print("*");
        } else {
          System.out.print(" ");
        }
      }
      System.out.println();
    }
  }

  public static void processAlt(int[] arr) {
    var max = Integer.MIN_VALUE;
    for (var item : arr) {
      max = Math.max(max, item);
    }

    for (int i = 0; i < max; i++) {
      for (int j = 0; j < arr.length; j++) {
        if (arr[j] + i >= max) {
          System.out.print("*");
        } else {
          System.out.print(" ");
        }
      }
      System.out.println();
    }
  }
}
