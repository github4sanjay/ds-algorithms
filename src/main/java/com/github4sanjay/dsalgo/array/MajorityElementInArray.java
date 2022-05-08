package com.github4sanjay.dsalgo.array;

/**
 * Write a function which takes an array and prints the majority element (if it exists), otherwise
 * prints “No Majority Element”. A majority element in an array A[] of size n is an element that
 * appears more than n/2 times (and hence there is at most one such element).
 *
 * <p>Examples :
 *
 * <p>Input : {3, 3, 4, 2, 4, 4, 2, 4, 4} Output : 4 Explanation: The frequency of 4 is 5 which is
 * greater than the half of the size of the array size.
 *
 * <p>Input : {3, 3, 4, 2, 4, 4, 2, 4} Output : No Majority Element Explanation: There is no element
 * whose frequency is greater than the half of the size of the array size.
 */
public class MajorityElementInArray {

  public static void main(String[] args) {
    System.out.println(findByMooreVotingAlgorithm(new int[] {3, 3, 4, 2, 4, 4, 2, 4, 4}));
  }

  // Moore voting algorithm
  private static int findByMooreVotingAlgorithm(int[] array) {

    int majorityElementIndex = 0;
    int count = 1;
    for (var i = 1; i < array.length; i++) {
      if (array[i] == array[majorityElementIndex]) {
        count++;
      } else {
        count--;
      }
      if (count == 0) {
        majorityElementIndex = i;
        count = 1;
      }
    }

    count = 0;

    for (int element : array) {
      if (array[majorityElementIndex] == element) {
        count++;
      }
    }
    if (count > array.length / 2) {
      return array[majorityElementIndex];
    } else {
      throw new RuntimeException("No majority element");
    }
  }
}
