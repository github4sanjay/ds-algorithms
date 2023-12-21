package com.github4sanjay.dsalgo.tree.bst;

import com.github4sanjay.dsalgo.tree.binary.structure.BinaryNode;

public class LCA {

  // find place where two diverge on left and right side
  public static int find(BinaryNode root, int first, int second) {

    if (first < root.getData() && second < root.getData()) { // when both smaller
      return find(root.getLeft(), first, second);
    } else if (first > root.getData() && second > root.getData()) { // when both large
      return find(root.getRight(), first, second);
    } else {
      return root.getData();
    }
  }
}
