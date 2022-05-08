package com.github4sanjay.dsalgo.search;

/**
 * Given a sorted array with possibly duplicate elements, the task is to find indexes of first and
 * last occurrences of an element x in the given array. Examples:
 *
 * <p>Input : arr[] = {1, 3, 5, 5, 5, 5, 67, 123, 125} x = 5 Output : First Occurrence = 2 Last
 * Occurrence = 5
 *
 * <p>Input : arr[] = {1, 3, 5, 5, 5, 5, 7, 123, 125 } x = 7 Output : First Occurrence = 6 Last
 * Occurrence = 6
 */
public class FirstAndLastIndex {
  public static void main(String[] args) {
    System.out.println(FirstAndLastIndex.find(new int[] {1, 3, 5, 5, 5, 5, 67, 123, 125}, 5));
    System.out.println(FirstAndLastIndex.find(new int[] {1, 3, 5, 5, 5, 5, 7, 123, 125}, 7));
  }

  public static Pair find(int[] array, int element) {
    var pair = new Pair(0, array.length - 1);
    searchLast(array, element, pair, 0, array.length - 1);
    searchFirst(array, element, pair, 0, array.length - 1);
    return pair;
  }

  public static void searchFirst(int[] array, int element, Pair pair, int low, int high) {
    while (low <= high) {
      int mid = (low + high) / 2;
      if (element > array[mid]) {
        low = mid + 1;
      } else if (element < array[mid]) {
        high = mid - 1;
      } else {
        pair.firstIndex = mid;
        high = mid - 1;
      }
    }
  }

  public static void searchLast(int[] array, int element, Pair pair, int low, int high) {
    while (low <= high) {
      int mid = (low + high) / 2;
      if (element > array[mid]) {
        low = mid + 1;
      } else if (element < array[mid]) {
        high = mid - 1;
      } else {
        pair.lastIndex = mid;
        low = mid + 1;
      }
    }
  }

  public static class Pair {
    int firstIndex;
    int lastIndex;

    public Pair(int firstIndex, int lastIndex) {
      this.firstIndex = firstIndex;
      this.lastIndex = lastIndex;
    }

    @Override
    public String toString() {
      return "Pair{" + "firstIndex=" + firstIndex + ", lastIndex=" + lastIndex + '}';
    }
  }
}
