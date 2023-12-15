package com.github4sanjay.dsalgo.sorting;

public class PartitioningArray {

  /*
   * [0,j-1] are smaller/equal to pivot
   * [j,i] are greater than pivot
   * [i, end] are unknown
   */
  public static void partition(int[] array, int pivot) {
    int i = 0, j = 0;
    while (i < array.length) {
      if (array[i] > pivot) {
        i++;
      } else {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
        j++;
        i++;
      }
    }
  }

  public static int partition(int[] array, int pivot, int low, int high) {
    int i = low, j = low;
    while (i <= high) {
      if (array[i] > pivot) {
        i++;
      } else {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
        j++;
        i++;
      }
    }
    return j - 1; // pivot index
  }
}
