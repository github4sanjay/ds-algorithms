package com.github4sanjay.dsalgo.sorting;

import java.util.Arrays;

public class PartitioningArray {

  public static void main(String[] args) {
    var example1 = new int[] {2, 3, 1, 7, 5, 4, 8, 9};
    PartitioningArray.partition(example1, 4);
    System.out.println(Arrays.toString(example1));

    var example2 = new int[] {8, 2, 3, 1, 7};
    PartitioningArray.partition(example2, 7);
    System.out.println(Arrays.toString(example2));
  }

  /**
   * [0,j-1] are smaller/equal to pivot [j,i] are greater than pivot [i, end] are unknown
   *
   * @param array Array
   * @param pivot Pivot
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
