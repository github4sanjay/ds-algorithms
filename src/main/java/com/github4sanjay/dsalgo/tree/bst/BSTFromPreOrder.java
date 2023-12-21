package com.github4sanjay.dsalgo.tree.bst;

import com.github4sanjay.dsalgo.tree.binary.structure.BinaryNode;

public class BSTFromPreOrder {

  public static BinaryNode createFromPreOrder(Integer[] ints) {
    var index = new Index();
    return createFromPreOrder(ints, Integer.MIN_VALUE, Integer.MAX_VALUE, index);
  }

  private static BinaryNode createFromPreOrder(
      Integer[] preOrder, int leftRange, int rightRange, Index index) {
    if (index.get() >= preOrder.length
        || preOrder[index.get()] > rightRange
        || preOrder[index.get()] < leftRange) {
      return null;
    }
    var node = new BinaryNode(preOrder[index.get()]);
    index.increment();
    node.setLeft(createFromPreOrder(preOrder, leftRange, node.getData(), index));
    node.setRight(createFromPreOrder(preOrder, node.getData(), rightRange, index));
    return node;
  }

  private static class Index {
    private int index = 0;

    public void increment() {
      index++;
    }

    public int get() {
      return index;
    }
  }
}
