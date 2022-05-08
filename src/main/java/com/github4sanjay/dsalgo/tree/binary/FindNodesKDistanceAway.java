package com.github4sanjay.dsalgo.tree.binary;

import com.github4sanjay.dsalgo.tree.binary.structure.BinaryNode;
import com.github4sanjay.dsalgo.tree.binary.structure.BinaryTreeUtil;
import java.util.ArrayList;
import java.util.List;

public class FindNodesKDistanceAway {

  public static void main(String[] args) {
    var root =
        BinaryTreeUtil.create(
            new int[] {50, 25, 12, -1, -1, 37, 30, -1, -1, -1, 75, 62, -1, 70, -1, -1, 87, -1, -1});
    System.out.println(FindNodesKDistanceAway.iterative(root, 37, 2)); // [12, 50]
  }

  /**
   * Find node to root path first Iterate over each node and find nodes k level down putting k
   * distance as k-index of node in path and blocker will be previous node in path
   */
  private static List<Integer> iterative(BinaryNode root, int data, int k) {
    var list = new ArrayList<Integer>();
    var path = NodeToRootPath.recursiveForNode(root, data);
    for (int i = 0; i < path.size(); i++) {
      var tempRoot = path.get(i);
      list.addAll(GetAllKLevelsDown.iterative(tempRoot, k - i, i == 0 ? null : path.get(i - 1)));
    }
    return list;
  }
}
