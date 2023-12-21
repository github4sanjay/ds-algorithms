package com.github4sanjay.dsalgo.tree.bst;

import static org.junit.jupiter.api.Assertions.*;

import com.github4sanjay.dsalgo.tree.binary.IsBST;
import com.github4sanjay.dsalgo.tree.binary.TraversalBinaryTree;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class BSTFromPreOrderTest {

  @Test
  public void test() {
    var root = BSTFromInOrder.createFromInOrder(new int[] {1, 2, 3, 4, 5, 6, 7});
    var answer = TraversalBinaryTree.recursive(root);
    var newRoot = BSTFromPreOrder.createFromPreOrder(answer.getPreorder().toArray(Integer[]::new));
    Assertions.assertTrue(IsBST.recursive(newRoot).isBST());
  }
}
