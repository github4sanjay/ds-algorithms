package com.github4sanjay.dsalgo.tree.bst;

import com.github4sanjay.dsalgo.tree.binary.structure.BinaryNode;
import java.util.ArrayList;
import java.util.List;

public class FindBetweenRange {

  public static List<Integer> find(BinaryNode root, int low, int high) {
    var list = new ArrayList<Integer>();
    find(root, low, high, list);
    return list;
  }

  private static void find(BinaryNode root, int low, int high, List<Integer> list) {
    if (root == null) return;

    if (high < root.getData()) { // data is greater than range so go left
      find(root.getLeft(), low, high, list);
    } else if (low > root.getData()) { // data is smaller than range so go right
      find(root.getRight(), low, high, list);
    } else {
      find(root.getLeft(), low, high, list);
      list.add(root.getData());
      find(root.getRight(), low, high, list);
    }
  }
}
