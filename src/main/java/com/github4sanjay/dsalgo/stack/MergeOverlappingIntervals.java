package com.github4sanjay.dsalgo.stack;

import com.github4sanjay.dsalgo.util.AlgoUtil;
import java.util.*;

/**
 * Given a set of time intervals in any order, merge all overlapping intervals into one and output
 * the result which should have only mutually exclusive intervals. Let the intervals be represented
 * as pairs of integers for simplicity.
 *
 * <p>For example, let the given set of intervals be {{1,3}, {2,4}, {5,7}, {6,8}}. The intervals
 * {1,3} and {2,4} overlap with each other, so they should be merged and become {1, 4}.
 *
 * <p>Similarly, {5, 7} and {6, 8} should be merged and become {5, 8}
 */
public class MergeOverlappingIntervals {

  public static void main(String[] args) {
    AlgoUtil.print(
        MergeOverlappingIntervals.find(
            new int[][] {
              {22, 28},
              {1, 8},
              {25, 27},
              {14, 19},
              {27, 30},
              {5, 12}
            }));
  }

  /**
   * 1. Sort the intervals first on the basis of start time 2. Create two stacks one for start time
   * and one for end time 3. Push first interval start and end time in the stacks 4. Traverse from
   * 2nd interval a. check if the current interval start time is greater than peek of end time stack
   * then push the start in start time and end in end stack b. if smaller then pop the end stack and
   * push new end time 5. At the end elements left in the stack will be merged intervals
   */
  public static int[][] find(int[][] intervals) {
    var list = new ArrayList<Interval>();
    for (int[] interval : intervals) {
      list.add(new Interval(interval[0], interval[1]));
    }

    Collections.sort(list);

    var stackStart = new Stack<Integer>();
    var stackEnd = new Stack<Integer>();
    var firstInterval = list.get(0);
    stackStart.push(firstInterval.start);
    stackEnd.push(firstInterval.end);
    for (int i = 1; i < list.size(); i++) {
      var interval = list.get(i);
      if (interval.start > stackEnd.peek()) {
        stackStart.push(interval.start);
        stackEnd.push(interval.end);
      } else {
        var peek = stackEnd.pop();
        stackEnd.push(interval.end > peek ? interval.end : peek);
      }
    }
    var finalList = new int[stackStart.size()][2];
    for (int i = finalList.length - 1; i >= 0; i--) {
      finalList[i][0] = stackStart.pop();
      finalList[i][1] = stackEnd.pop();
    }
    return finalList;
  }

  public static class Interval implements Comparable<Interval> {
    Integer start;
    Integer end;

    public Interval(Integer start, Integer end) {
      this.start = start;
      this.end = end;
    }

    @Override
    public int compareTo(Interval o) {
      if (!start.equals(o.start)) {
        return start.compareTo(o.start);
      } else {
        return end.compareTo(o.end);
      }
    }
  }
}
