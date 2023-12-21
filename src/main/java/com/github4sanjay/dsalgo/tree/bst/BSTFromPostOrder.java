package com.github4sanjay.dsalgo.tree.bst;

import com.github4sanjay.dsalgo.tree.binary.structure.BinaryNode;

public class BSTFromPostOrder {

  public static BinaryNode createFromPostOrder(Integer[] ints) {
    var index = new Index(ints.length - 1);
    return createFromPostOrder(ints, Integer.MIN_VALUE, Integer.MAX_VALUE, index);
  }

  private static BinaryNode createFromPostOrder(
      Integer[] postOrder, int leftRange, int rightRange, Index index) {
    if (index.get() < 0
        || postOrder[index.get()] > rightRange
        || postOrder[index.get()] < leftRange) {
      return null;
    }
    var node = new BinaryNode(postOrder[index.get()]);
    index.decrement();
    node.setRight(createFromPostOrder(postOrder, node.getData(), rightRange, index));
    node.setLeft(createFromPostOrder(postOrder, leftRange, node.getData(), index));
    return node;
  }

  private static class Index {
    private int index = 0;

    public Index(int initialValue) {
      this.index = initialValue;
    }

    public void decrement() {
      index--;
    }

    public int get() {
      return index;
    }
  }
}
