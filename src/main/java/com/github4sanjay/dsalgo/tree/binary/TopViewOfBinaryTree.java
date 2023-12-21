package com.github4sanjay.dsalgo.tree.binary;

import com.github4sanjay.dsalgo.tree.binary.structure.BinaryNode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TopViewOfBinaryTree {

  public static List<List<Integer>> find(BinaryNode root) {
    var map = new HashMap<Integer, List<Integer>>();
    find(root, 0, map);
    var list = new ArrayList<List<Integer>>();
    var size = map.size();
    for (int i = -size / 2; i <= size / 2; i++) {
      list.add(map.get(i));
    }
    return list;
  }

  private static void find(BinaryNode root, int i, HashMap<Integer, List<Integer>> map) {
    var list = map.computeIfAbsent(i, k -> new ArrayList<>());
    list.add(root.getData());
    if (root.getLeft() != null) find(root.getLeft(), i - 1, map);
    if (root.getRight() != null) find(root.getRight(), i + 1, map);
  }
}
