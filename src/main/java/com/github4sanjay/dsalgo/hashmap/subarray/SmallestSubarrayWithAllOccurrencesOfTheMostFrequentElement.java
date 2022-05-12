package com.github4sanjay.dsalgo.hashmap.subarray;

import java.util.HashMap;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * Smallest Subarray With All Occurrences Of The Most Frequent Element Medium
 *
 * <p>1. You are given an array(arr) of integers. 2. You have to find the element(x) with maximum
 * frequency in the given array. 3. Also, you have to find the smallest subarray which has all
 * occurrences of the most frequent element i.e x.
 *
 * <p>Note -> If there are two or more elements with maximum frequency and the same subarray size
 * then print the subarray which occurs first in the given array.
 *
 * <p>Constraints 1 <= N <= 10^6 1 <= arr[i] <= 10^5
 *
 * <p>Format Input A number N arr1 arr2.. N numbers
 *
 * <p>Output A number(x) representing the maximum frequency element in the given array. Two numbers
 * representing the start and end index of the smallest subarray with all occurrences of the most
 * frequent element.
 *
 * <p>Example Sample Input
 *
 * <p>8 4 1 1 2 2 1 3 3
 *
 * <p>Sample Output 1 1 5
 */
public class SmallestSubarrayWithAllOccurrencesOfTheMostFrequentElement {

  @Getter
  @Setter
  @AllArgsConstructor
  public static class Answer {
    private int element;
    private int startIndex;
    private int lastIndex;
  }

  public static Answer find(int[] input) {
    var frequencyMap = new HashMap<Integer, Integer>();
    var startIndexMap = new HashMap<Integer, Integer>();
    var maxFrequency = 0;
    var maxFrequencyElement = 0;
    var startIndex = -1;
    var lastIndex = -1;
    for (int i = 0; i < input.length; i++) {
      var frequency = frequencyMap.getOrDefault(input[i], 0) + 1;
      frequencyMap.put(input[i], frequency);
      if (!startIndexMap.containsKey(input[i])) {
        startIndexMap.put(input[i], i);
      }
      if (frequency > maxFrequency) {
        maxFrequency = frequency;
        maxFrequencyElement = input[i];
        startIndex = startIndexMap.get(input[i]);
        lastIndex = i;
      } else if (frequency == maxFrequency) {
        var startIndexOfCurrent = startIndexMap.get(input[i]);
        if (i - startIndexOfCurrent + 1 > lastIndex - startIndex + 1) {
          maxFrequencyElement = input[i];
          startIndex = startIndexOfCurrent;
          lastIndex = i;
        }
      }
    }
    return new Answer(maxFrequencyElement, startIndex, lastIndex);
  }
}
