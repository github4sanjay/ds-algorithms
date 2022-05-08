package com.github4sanjay.dsalgo.tree.binary;

import com.github4sanjay.dsalgo.tree.binary.structure.BinaryNode;
import com.github4sanjay.dsalgo.tree.binary.structure.BinaryTreeUtil;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class GetAllKLevelsDown {

  public static void main(String[] args) {
    var root =
        BinaryTreeUtil.create(
            new int[] {50, 25, 12, -1, -1, 37, 30, -1, -1, -1, 75, 62, -1, 70, -1, -1, 87, -1, -1});
    System.out.println(GetAllKLevelsDown.iterative(root, 2)); // [12, 37, 62, 87]
    System.out.println(GetAllKLevelsDown.iterative(root, 2, 75)); // with blocker [12, 37]
    System.out.println(GetAllKLevelsDown.recursive(root, 3)); // [30, 70]
  }

  private static List<Integer> recursive(BinaryNode root, int k) {
    var list = new ArrayList<Integer>();
    recursive(root, k, list);
    return list;
  }

  private static void recursive(BinaryNode root, int k, List<Integer> list) {
    if (root == null || k < 0) {
      return;
    }
    if (k == 0) {
      list.add(root.getData());
    }
    recursive(root.getLeft(), k - 1, list);
    recursive(root.getRight(), k - 1, list);
  }

  public static List<Integer> iterative(BinaryNode root, int k) {
    var list = new ArrayList<Integer>();
    var queue = new LinkedList<BinaryNode>();
    queue.offer(root);
    int count = 0;
    while (!queue.isEmpty() && count <= k) {
      var size = queue.size();
      for (int i = 0; i < size; i++) {
        var node = queue.poll();
        if (count == k) {
          list.add(node.getData());
        }
        if (node.getLeft() != null) {
          queue.offer(node.getLeft());
        }
        if (node.getRight() != null) {
          queue.offer(node.getRight());
        }
      }
      count++;
    }
    return list;
  }

  public static List<Integer> iterative(BinaryNode root, int k, int blocker) {
    var list = new ArrayList<Integer>();
    var queue = new LinkedList<BinaryNode>();
    queue.offer(root);
    int count = 0;
    while (!queue.isEmpty() && count <= k) {
      var size = queue.size();
      for (int i = 0; i < size; i++) {
        var node = queue.poll();
        if (node.getData() == blocker) continue; // if blocker don't go ahead
        if (count == k) {
          list.add(node.getData());
        }
        if (node.getLeft() != null) {
          queue.offer(node.getLeft());
        }
        if (node.getRight() != null) {
          queue.offer(node.getRight());
        }
      }
      count++;
    }
    return list;
  }

  public static List<Integer> iterative(BinaryNode root, int k, BinaryNode blocker) {
    var list = new ArrayList<Integer>();
    var queue = new LinkedList<BinaryNode>();
    queue.offer(root);
    int count = 0;
    while (!queue.isEmpty() && count <= k) {
      var size = queue.size();
      for (int i = 0; i < size; i++) {
        var node = queue.poll();
        if (node == blocker) continue; // if blocker don't go ahead
        if (count == k) {
          list.add(node.getData());
        }
        if (node.getLeft() != null) {
          queue.offer(node.getLeft());
        }
        if (node.getRight() != null) {
          queue.offer(node.getRight());
        }
      }
      count++;
    }
    return list;
  }
}
