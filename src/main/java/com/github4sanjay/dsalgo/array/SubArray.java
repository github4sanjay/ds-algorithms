package com.github4sanjay.dsalgo.array;

public class SubArray {

  public static void main(String[] args) {
    find(new int[] {1, 2, 3, 4, 5});
  }

  public static void find(int[] arr) {
    for (int i = 0; i < arr.length; i++) {
      for (int j = i; j < arr.length; j++) {
        for (int k = i; k <= j; k++) {
          System.out.print(arr[k] + "\t");
        }
        System.out.println();
      }
    }
  }
}
