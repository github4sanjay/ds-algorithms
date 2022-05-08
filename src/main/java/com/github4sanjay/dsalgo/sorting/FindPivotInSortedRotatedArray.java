package com.github4sanjay.dsalgo.sorting;

public class FindPivotInSortedRotatedArray {

  /** output logn pivot : 10 */
  public static void main(String[] args) {
    int arr1[] = {50, 10, 20, 30, 40};
    System.out.println("Index of the element is : " + pivotedBinarySearch(arr1));

    int arr2[] = {50, 60, 70, 80, 90, 100, 110, 120, 5, 10, 20, 30, 40};
    System.out.println("Index of the element is : " + pivotedBinarySearch(arr2));
  }

  private static int pivotedBinarySearch(int[] arr) {
    int low = 0;
    int high = arr.length - 1;
    while (low < high) {
      int mid = (low + high) / 2;
      if (arr[mid] < arr[high]) {
        high = mid;
      } else {
        low = mid + 1;
      }
    }
    return arr[low];
  }
}
