package com.github4sanjay.dsalgo.tree.bst;

import com.github4sanjay.dsalgo.tree.binary.structure.BinaryNode;

public class FindInBST {

  public static void main(String[] args) {
    var root = BSTUtil.create(new int[] {1, 2, 3, 4, 5, 6, 7});
    System.out.println(FindInBST.recursive(root, 6)); // true
    System.out.println(FindInBST.recursive(root, 8)); // false
  }

  // efficient
  public static boolean recursive(BinaryNode root, int data) {

    if (root == null) {
      return false;
    } else if (root.getData() == data) {
      return true;
    } else if (data < root.getData()) {
      return recursive(root.getLeft(), data);
    } else {
      return recursive(root.getRight(), data);
    }
  }

  // normal
  public static boolean recursiveNormal(BinaryNode root, int data) {
    if (root == null) {
      return false;
    }
    var findInLeft = recursiveNormal(root.getLeft(), data);
    var findInRight = recursiveNormal(root.getRight(), data);
    return findInLeft || findInRight || root.getData() == data;
  }
}
