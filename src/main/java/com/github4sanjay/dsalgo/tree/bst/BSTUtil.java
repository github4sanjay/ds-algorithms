package com.github4sanjay.dsalgo.tree.bst;

import com.github4sanjay.dsalgo.tree.binary.structure.BinaryNode;
import java.util.ArrayList;
import java.util.List;

public class BSTUtil {

  public static BinaryNode create(int[] ints) {
    return create(ints, 0, ints.length - 1);
  }

  public static BinaryNode create(int[] arr, int start, int end) {
    if (start > end) {
      return null;
    }
    int mid = (start + end) / 2;
    var node = new BinaryNode(arr[mid]);
    node.setLeft(create(arr, start, mid - 1));
    node.setRight(create(arr, mid + 1, end));
    return node;
  }

  public static void inOrder(BinaryNode node) {
    if (node == null) {
      return;
    }
    inOrder(node.getLeft());
    System.out.print(node.getData() + " ");
    inOrder(node.getRight());
  }

  public static List<Display> display(BinaryNode root) {
    var list = new ArrayList<Display>();
    display(root, list);
    return list;
  }

  public static void display(BinaryNode root, List<Display> list) {
    if (root == null) {
      return;
    }
    list.add(
        new Display(
            root.getLeft() != null ? root.getLeft().getData() : -1,
            root.getData(),
            root.getRight() != null ? root.getRight().getData() : -1));
    display(root.getLeft(), list);
    display(root.getRight(), list);
  }

  public static class Display {
    int left;
    int root;
    int right;

    public Display(int left, int root, int right) {
      this.left = left;
      this.root = root;
      this.right = right;
    }

    @Override
    public String toString() {
      return "Display{" + "left=" + left + ", root=" + root + ", right=" + right + '}';
    }
  }
}
