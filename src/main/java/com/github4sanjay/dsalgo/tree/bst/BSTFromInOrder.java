package com.github4sanjay.dsalgo.tree.bst;

import com.github4sanjay.dsalgo.tree.binary.structure.BinaryNode;

public class BSTFromInOrder {

  public static BinaryNode createFromInOrder(int[] ints) {
    return createFromInOrder(ints, 0, ints.length - 1);
  }

  private static BinaryNode createFromInOrder(int[] arr, int start, int end) {
    if (start > end) {
      return null;
    }
    int mid = (start + end) / 2;
    var node = new BinaryNode(arr[mid]);
    node.setLeft(createFromInOrder(arr, start, mid - 1));
    node.setRight(createFromInOrder(arr, mid + 1, end));
    return node;
  }
}
