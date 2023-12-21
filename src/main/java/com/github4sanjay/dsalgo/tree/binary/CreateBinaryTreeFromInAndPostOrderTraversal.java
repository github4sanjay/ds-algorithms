package com.github4sanjay.dsalgo.tree.binary;

import com.github4sanjay.dsalgo.tree.binary.structure.BinaryNode;

public class CreateBinaryTreeFromInAndPostOrderTraversal {

  public static BinaryNode buildTree(Integer[] in, Integer[] post) {
    return buildUtil(in, post, 0, in.length - 1, 0, in.length - 1);
  }

  public static BinaryNode buildUtil(
      Integer[] in, Integer[] post, int inStrt, int inEnd, int postStrt, int postEnd) {
    if (inStrt > inEnd) return null;

    BinaryNode node = new BinaryNode(post[postEnd]);

    int indexOfNodeInInorder = search(in, inStrt, inEnd, node.getData());
    int totalElements = indexOfNodeInInorder - inStrt;
    node.setLeft(
        buildUtil(
            in, post, inStrt, indexOfNodeInInorder - 1, postStrt, postStrt + totalElements - 1));
    node.setRight(
        buildUtil(
            in, post, indexOfNodeInInorder + 1, inEnd, postStrt + totalElements, postEnd - 1));

    return node;
  }

  public static int search(Integer[] arr, int strt, int end, int value) {
    int i;
    for (i = strt; i <= end; i++) {
      if (arr[i] == value) break;
    }
    return i;
  }
}
