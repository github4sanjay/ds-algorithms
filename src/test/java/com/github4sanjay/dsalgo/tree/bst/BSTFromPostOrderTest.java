package com.github4sanjay.dsalgo.tree.bst;

import com.github4sanjay.dsalgo.tree.binary.IsBST;
import com.github4sanjay.dsalgo.tree.binary.SizeBinaryTree;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class BSTFromPostOrderTest {

  @Test
  public void test() {
    var postOrder = new Integer[] {15, 10, 23, 25, 20, 35, 42, 39, 30};
    var newRoot = BSTFromPostOrder.createFromPostOrder(postOrder);
    Assertions.assertEquals(postOrder.length, SizeBinaryTree.iterative(newRoot));
    Assertions.assertTrue(IsBST.recursive(newRoot).isBST());
  }
}
