package com.github4sanjay.dsalgo.sorting;

public class SortDates {

  public static void sort(String[] arr) {
    CountSort.sort(arr, 1000000, 100, 32); // days
    CountSort.sort(arr, 10000, 100, 13); // month
    CountSort.sort(arr, 1, 10000, 2501); // years
  }
}
