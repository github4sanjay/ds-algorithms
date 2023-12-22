package com.github4sanjay.dsalgo.heap;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class MergeKSortedList {
  public static class Holder {
    Integer li;
    Integer di;
    Integer val;

    public Holder(Integer li, Integer di, Integer val) {
      this.li = li;
      this.di = di;
      this.val = val;
    }
  }

  public static ArrayList<Integer> merge(List<List<Integer>> lists) {
    PriorityQueue<Holder> holders =
        new PriorityQueue<>(
            new Comparator<Holder>() {
              @Override
              public int compare(Holder o1, Holder o2) {
                return o1.val.compareTo(o2.val);
              }
            });
    for (int i = 0; i < lists.size(); i++) {
      holders.add(new Holder(i, 0, lists.get(i).get(0)));
    }
    var list = new ArrayList<Integer>();
    while (!holders.isEmpty()) {
      var holder = holders.remove();
      var nextDI = holder.di + 1;
      if (nextDI < lists.get(holder.li).size()) {
        holders.add(new Holder(holder.li, nextDI, lists.get(holder.li).get(nextDI)));
      }
      list.add(holder.val);
    }
    return list;
  }
}
