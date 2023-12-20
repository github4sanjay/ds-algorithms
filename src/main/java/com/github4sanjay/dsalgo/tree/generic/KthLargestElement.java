package com.github4sanjay.dsalgo.tree.generic;

import com.github4sanjay.dsalgo.tree.generic.structure.Node;

public class KthLargestElement {

  /** floor of Integer.MAX_VALUE will be first largest value */
  public static int find(Node root, int k) {
    var floor = Integer.MAX_VALUE;
    for (int i = 0; i < k; i++) {
      var answer = CeilAndFloor.iterative(root, floor);
      floor = answer.floor;
    }
    return floor;
  }
}
