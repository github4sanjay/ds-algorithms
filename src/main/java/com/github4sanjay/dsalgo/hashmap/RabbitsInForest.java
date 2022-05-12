package com.github4sanjay.dsalgo.hashmap;

import java.util.HashMap;

/**
 * There is a forest with an unknown number of rabbits. We asked n rabbits "How many rabbits have
 * the same color as you?" and collected the answers in an integer array answers where answers[i] is
 * the answer of the ith rabbit.
 *
 * <p>Given the array answers, return the minimum number of rabbits that could be in the forest.
 *
 * <p>Example 1:
 *
 * <p>Input: answers = [1,1,2] Output: 5 Explanation: The two rabbits that answered "1" could both
 * be the same color, say red. The rabbit that answered "2" can't be red or the answers would be
 * inconsistent. Say the rabbit that answered "2" was blue. Then there should be 2 other blue
 * rabbits in the forest that didn't answer into the array. The smallest possible number of rabbits
 * in the forest is therefore 5: 3 that answered plus 2 that didn't. Example 2:
 *
 * <p>Input: answers = [10,10,10] Output: 11
 *
 * <p>Constraints:
 *
 * <p>1 <= answers.length <= 1000 0 <= answers[i] < 1000
 */
public class RabbitsInForest {

  public static int find(int[] answers) {
    int count = 0;
    // map of number of rabbits of same color said by how many rabbits
    var map = new HashMap<Integer, Integer>();
    for (var answer : answers) {
      var numberOfRabbitInformed = map.getOrDefault(answer, 0);
      map.put(answer, numberOfRabbitInformed + 1);
    }
    for (var entry : map.entrySet()) {
      count = count + (entry.getKey() + 1) * (entry.getValue() / (entry.getKey() + 1));
      var remainder = entry.getValue() % (entry.getKey() + 1);
      if (remainder != 0) count = count + entry.getKey() + 1;
    }
    return count;
  }
}
