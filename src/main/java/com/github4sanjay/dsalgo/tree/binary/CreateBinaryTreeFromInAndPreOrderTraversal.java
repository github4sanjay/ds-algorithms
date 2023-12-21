package com.github4sanjay.dsalgo.tree.binary;

import com.github4sanjay.dsalgo.tree.binary.structure.BinaryNode;

public class CreateBinaryTreeFromInAndPreOrderTraversal {

  public static BinaryNode buildTree(Integer[] in, Integer[] pre) {
    return buildUtil(in, pre, 0, in.length - 1, 0, in.length - 1);
  }

  public static BinaryNode buildUtil(
      Integer[] in, Integer[] pre, int inStrt, int inEnd, int preStrt, int preEnd) {
    if (inStrt > inEnd) return null;

    BinaryNode node = new BinaryNode(pre[preStrt]);

    int indexOfNodeInInorder = search(in, inStrt, inEnd, node.getData());
    int totalElements = indexOfNodeInInorder - inStrt;

    node.setLeft(
        buildUtil(in, pre, inStrt, indexOfNodeInInorder - 1, preStrt + 1, preStrt + totalElements));
    node.setRight(
        buildUtil(in, pre, indexOfNodeInInorder + 1, inEnd, preStrt + totalElements + 1, preEnd));
    return node;
  }

  private static int search(Integer[] arr, int strt, int end, int value) {
    int i;
    for (i = strt; i <= end; i++) {
      if (arr[i] == value) break;
    }
    return i;
  }
}
