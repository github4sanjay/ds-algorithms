package com.github4sanjay.dsalgo.hashmap.anagram;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Given two lists A and B, and B is an anagram of A. B is an anagram of A means B is made by
 * randomizing the order of the elements in A. We want to find an index mapping P, from A to B. A
 * mapping P[i] = j means the ith element in A appears in B at index j. These lists A and B may
 * contain duplicates. If there are multiple answers, output any of them.
 *
 * <p>A, B have equal lengths in range [1, 100]. A[i], B[i] are integers in range [0, 10^5].
 *
 * <p>Have you met this question in a real interview? Example
 *
 * <p>Example1
 *
 * <p>Input: A = [12, 28, 46, 32, 50] and B = [50, 12, 32, 46, 28] Output: [1, 4, 3, 2, 0]
 * Explanation: As P[0] = 1 because the 0th element of A appears at B[1], and P[1] = 4 because the
 * 1st element of A appears at B[4], and so on.
 *
 * <p>Example2
 *
 * <p>Input: A = [1, 2, 3, 4, 5] and B = [5, 4, 3, 2, 1] Output: [4, 3, 2, 1, 0] Explanation: As
 * P[0] = 4 because the 0th element of A appears at B[4], and P[1] = 3 because the 1st element of A
 * appears at B[3], and so on.
 */
public class FindAnagramsMapping {

  public static void main(String[] args) {
    System.out.println(
        Arrays.toString(
            FindAnagramsMapping.find(
                new int[] {12, 28, 46, 32, 50}, new int[] {50, 12, 32, 46, 28})));
    System.out.println(
        Arrays.toString(
            FindAnagramsMapping.find(new int[] {1, 2, 3, 4, 5}, new int[] {5, 4, 3, 2, 1})));
  }

  private static int[] find(int[] array, int[] anagram) {
    var map = new HashMap<Integer, Pair>();
    for (int i = 0; i < anagram.length; i++) {
      var pair = map.getOrDefault(anagram[i], new Pair(0));
      pair.addPosition(i);
      map.put(anagram[i], pair);
    }
    var mapping = new int[array.length];
    for (int i = 0; i < array.length; i++) {
      var pair = map.get(array[i]);
      mapping[i] = pair.getPosition();
    }
    return mapping;
  }

  public static class Pair {
    int index;
    List<Integer> positions;

    public Pair(int index) {
      this.index = index;
      this.positions = new ArrayList<>();
    }

    public void addPosition(int position) {
      positions.add(position);
    }

    public void increaseIndex() {
      index++;
    }

    public int getPosition() {
      int pos = positions.get(index);
      increaseIndex();
      return pos;
    }
  }
}
