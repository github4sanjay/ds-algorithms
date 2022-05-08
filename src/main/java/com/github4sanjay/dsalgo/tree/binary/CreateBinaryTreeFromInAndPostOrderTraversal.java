package com.github4sanjay.dsalgo.tree.binary;

import com.github4sanjay.dsalgo.tree.binary.structure.BinaryNode;
import com.github4sanjay.dsalgo.tree.binary.structure.BinaryTreeUtil;

public class CreateBinaryTreeFromInAndPostOrderTraversal {

  public static void main(String[] args) {
    var root =
        BinaryTreeUtil.create(
            new int[] {50, 25, 12, -1, -1, 37, 30, -1, -1, -1, 75, 62, -1, 70, -1, -1, 87, -1, -1});
    var answer = TraversalBinaryTree.recursive(root);
    var answer1 =
        TraversalBinaryTree.recursive(
            buildTree(
                answer.getInorder().toArray(Integer[]::new),
                answer.getPostorder().toArray(Integer[]::new)));
    System.out.println(answer1.getPreorder());
    System.out.println(answer.getPreorder());
  }

  public static BinaryNode buildTree(Integer[] in, Integer[] post) {
    Index pIndex = new Index();
    pIndex.index = in.length - 1;
    return buildUtil(in, post, 0, in.length - 1, pIndex);
  }

  public static BinaryNode buildUtil(
      Integer[] in, Integer[] post, int inStrt, int inEnd, Index pIndex) {
    if (inStrt > inEnd) return null;

    BinaryNode node = new BinaryNode(post[pIndex.index]);
    (pIndex.index)--;

    if (inStrt == inEnd) return node;

    int iIndex = search(in, inStrt, inEnd, node.getData());

    node.setRight(buildUtil(in, post, iIndex + 1, inEnd, pIndex));
    node.setLeft(buildUtil(in, post, inStrt, iIndex - 1, pIndex));

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
