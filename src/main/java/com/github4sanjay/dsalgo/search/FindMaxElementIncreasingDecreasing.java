package com.github4sanjay.dsalgo.search;

/**
 * Find the maximum element in an array which is first increasing and then decreasing
 *
 * <p>Given an array of integers which is initially increasing and then decreasing, find the maximum
 * value in the array. Examples :
 *
 * <p>Input: arr[] = {8, 10, 20, 80, 100, 200, 400, 500, 3, 2, 1} Output: 500
 *
 * <p>Input: arr[] = {1, 3, 50, 10, 9, 7, 6} Output: 50
 *
 * <p>Corner case (No decreasing part) Input: arr[] = {10, 20, 30, 40, 50} Output: 50
 *
 * <p>Corner case (No increasing part) Input: arr[] = {120, 100, 80, 20, 0} Output: 120
 */
public class FindMaxElementIncreasingDecreasing {

  public static void main(String[] args) {
    System.out.println(find(new int[] {8, 10, 20, 80, 100, 200, 400, 500, 3, 2, 1}));
    System.out.println(find(new int[] {8, 10, 20, 80, 100, 200, 400, 500, 600, 700, 800}));
    System.out.println(find(new int[] {8, 10, 20, 80, 100, 200, 400, 500, 600, 700, 800, 9}));
    System.out.println(find(new int[] {8, 7, 5, 4, 3, 2, 1}));
    System.out.println(find(new int[] {-4, -3, -2, 4, 6, 8, 9}));
  }

  private static int find(int[] array) {
    int low = 0;
    int high = array.length - 1;
    while (low <= high) {
      int mid = (low + high) / 2;
      if (low == high) {
        return array[low];
      }
      if (array[mid - 1] < array[mid] && array[mid] < array[mid + 1]) {
        low = mid + 1;
      } else if (array[mid - 1] > array[mid] && array[mid] > array[mid + 1]) {
        high = mid - 1;
      } else if (array[mid] > array[mid - 1] && array[mid] > array[mid + 1]) {
        return array[mid];
      }
    }
    return 0;
  }
}
