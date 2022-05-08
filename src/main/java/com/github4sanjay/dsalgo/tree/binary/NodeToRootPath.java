package com.github4sanjay.dsalgo.tree.binary;

import com.github4sanjay.dsalgo.tree.binary.structure.BinaryNode;
import com.github4sanjay.dsalgo.tree.binary.structure.BinaryTreeUtil;
import java.util.ArrayList;
import java.util.List;

public class NodeToRootPath {

  public static void main(String[] args) {
    var root =
        BinaryTreeUtil.create(
            new int[] {50, 25, 12, -1, -1, 37, 30, -1, -1, -1, 75, 62, -1, 70, -1, -1, 87, -1, -1});
    System.out.println(NodeToRootPath.recursive(root, 30));
  }

  public static List<Integer> recursive(BinaryNode root, int data) {
    if (root.getData() == data) {
      var path = new ArrayList<Integer>();
      path.add(root.getData());
      return path;
    }

    if (root.getLeft() != null) {
      var path = recursive(root.getLeft(), data);
      if (!path.isEmpty()) {
        path.add(root.getData());
        return path;
      }
    }

    if (root.getRight() != null) {
      var path = recursive(root.getRight(), data);
      if (!path.isEmpty()) {
        path.add(root.getData());
        return path;
      }
    }

    return new ArrayList<>();
  }

  public static List<BinaryNode> recursiveForNode(BinaryNode root, int data) {
    if (root.getData() == data) {
      var path = new ArrayList<BinaryNode>();
      path.add(root);
      return path;
    }

    if (root.getLeft() != null) {
      var path = recursiveForNode(root.getLeft(), data);
      if (!path.isEmpty()) {
        path.add(root);
        return path;
      }
    }

    if (root.getRight() != null) {
      var path = recursiveForNode(root.getRight(), data);
      if (!path.isEmpty()) {
        path.add(root);
        return path;
      }
    }

    return new ArrayList<>();
  }
}
