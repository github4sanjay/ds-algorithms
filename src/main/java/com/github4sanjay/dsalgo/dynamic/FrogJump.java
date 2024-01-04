package com.github4sanjay.dsalgo.dynamic;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * A frog is crossing a river. The river is divided into some number of units, and at each unit,
 * there may or may not exist a stone. The frog can jump on a stone, but it must not jump into the
 * water.
 *
 * <p>Given a list of stones positions (in units) in sorted ascending order, determine if the frog
 * can cross the river by landing on the last stone. Initially, the frog is on the first stone and
 * assumes the first jump must be 1 unit.
 *
 * <p>If the frog's last jump was k units, its next jump must be either k - 1, k, or k + 1 units.
 * The frog can only jump in the forward direction.
 *
 * <p>Example 1:
 *
 * <p>Input: stones = [0,1,3,5,6,8,12,17] Output: true Explanation: The frog can jump to the last
 * stone by jumping 1 unit to the 2nd stone, then 2 units to the 3rd stone, then 2 units to the 4th
 * stone, then 3 units to the 6th stone, 4 units to the 7th stone, and 5 units to the 8th stone.
 * Example 2:
 *
 * <p>Input: stones = [0,1,2,3,4,8,9,11] Output: false Explanation: There is no way to jump to the
 * last stone as the gap between the 5th and 6th stone is too large.
 */
public class FrogJump {

  public static boolean recursion(int[] stones) {
    var set = new HashSet<Integer>();
    for (var stone : stones) {
      set.add(stone);
    }
    return recursion(stones, set, 1, 1);
  }

  private static boolean recursion(
      int[] stones, Set<Integer> set, int index, int previousJumpLength) {
    if (previousJumpLength == 0) {
      return false;
    }
    if (index > stones[stones.length - 1]) {
      return false;
    }
    if (!set.contains(index)) {
      return false;
    }
    if (index == stones[stones.length - 1]) {
      return true;
    }

    return recursion(stones, set, index + previousJumpLength - 1, previousJumpLength - 1)
        || recursion(stones, set, index + previousJumpLength, previousJumpLength)
        || recursion(stones, set, index + previousJumpLength + 1, previousJumpLength + 1);
  }

  public static boolean dp(int[] stones) {
    var dp = new HashMap<Integer, Set<Integer>>();
    for (int i = 0; i < stones.length; i++) {
      dp.put(stones[i], new HashSet<>());
    }
    var availableJumpsLengthAt0 = dp.get(stones[0]);
    availableJumpsLengthAt0.add(1); // from 0 one jump is available
    dp(stones, dp);
    return !dp.get(stones[stones.length - 1]).isEmpty();
  }

  private static void dp(int[] stones, Map<Integer, Set<Integer>> dp) {
    for (int i = 0; i < stones.length; i++) {
      var currentStone = stones[i];
      // from ith stone how many jumps are possible
      var jumps = dp.get(currentStone);
      for (var jump : jumps) {
        // stone position can reach after this jump from current stone
        var pos = currentStone + jump;
        if (dp.containsKey(pos)) {
          // add the available jumps possible on pos
          var availableJumpsLengthAtStoneIndexAfterJump = dp.get(pos);
          if (jump - 1 > 0) {
            availableJumpsLengthAtStoneIndexAfterJump.add(jump - 1);
          }
          availableJumpsLengthAtStoneIndexAfterJump.add(jump);
          availableJumpsLengthAtStoneIndexAfterJump.add(jump + 1);
          dp.put(pos, availableJumpsLengthAtStoneIndexAfterJump);
        }
      }
    }
  }
}
