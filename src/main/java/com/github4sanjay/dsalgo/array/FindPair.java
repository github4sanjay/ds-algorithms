package com.github4sanjay.dsalgo.array;

import com.github4sanjay.dsalgo.util.Pair;
import java.util.ArrayList;
import java.util.List;

public class FindPair {

  public static void main(String[] args) {
    System.out.println(FindPair.find(List.of(12, 25, 30, 37, 50, 60, 62, 70, 75, 87), 100));
  }

  public static List<Pair> find(List<Integer> sorted, int targetSum) {
    var list = new ArrayList<Pair>();
    int i = 0;
    int j = sorted.size() - 1;
    while (i < j) {
      int getI = sorted.get(i);
      int getJ = sorted.get(j);
      if (getI + getJ > targetSum) {
        j--;
      } else if (getI + getJ < targetSum) {
        i++;
      } else {
        list.add(new Pair(getI, getJ));
        i++;
        j--;
      }
    }
    return list;
  }
}
