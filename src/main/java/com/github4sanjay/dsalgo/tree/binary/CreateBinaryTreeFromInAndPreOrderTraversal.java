package com.github4sanjay.dsalgo.tree.binary;

import com.github4sanjay.dsalgo.tree.binary.structure.BinaryNode;
import com.github4sanjay.dsalgo.tree.binary.structure.BinaryTreeUtil;

public class CreateBinaryTreeFromInAndPreOrderTraversal {

  public static void main(String[] args) {

    var root =
        BinaryTreeUtil.create(
            new int[] {50, 25, 12, -1, -1, 37, 30, -1, -1, -1, 75, 62, -1, 70, -1, -1, 87, -1, -1});
    var answer = TraversalBinaryTree.recursive(root);
    System.out.println(answer);
    var answer1 =
        TraversalBinaryTree.recursive(
            buildTree(
                answer.getInorder().toArray(Integer[]::new),
                answer.getPreorder().toArray(Integer[]::new)));
    System.out.println(answer1.getPostorder());
  }

  public static BinaryNode buildTree(Integer[] in, Integer[] pre) {
    Index pIndex = new Index();
    pIndex.index = 0;
    return buildUtil(in, pre, 0, in.length - 1, pIndex);
  }

  public static BinaryNode buildUtil(
      Integer[] in, Integer[] pre, int inStrt, int inEnd, Index pIndex) {
    if (inStrt > inEnd) return null;

    BinaryNode node = new BinaryNode(pre[pIndex.index]);
    (pIndex.index)++;

    if (inStrt == inEnd) return node;

    int iIndex = search(in, inStrt, inEnd, node.getData());

    node.setLeft(buildUtil(in, pre, inStrt, iIndex - 1, pIndex));
    node.setRight(buildUtil(in, pre, iIndex + 1, inEnd, pIndex));
    return node;
  }

  public static int search(Integer[] arr, int strt, int end, int value) {
    int i;
    for (i = strt; i <= end; i++) {
      if (arr[i] == value) break;
    }
    return i;
  }

  public static class Index {
    int index;
  }
}
