package com.github4sanjay.dsalgo.tree.bst;

import static org.junit.jupiter.api.Assertions.*;

import com.github4sanjay.dsalgo.tree.binary.TraversalBinaryTree;
import com.github4sanjay.dsalgo.tree.binary.structure.BinaryTreeUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ReplaceSumOfLargerTest {

  @Test
  public void test() {
    int n = -1;
    var root =
        BinaryTreeUtil.create(new int[] {50, 25, 12, n, n, 37, n, n, 75, 62, n, n, 87, n, n});
    BSTUtil.inOrder(root);
    ReplaceSumOfLarger.replace(root);
    var traversal = TraversalBinaryTree.recursive(root);
    Assertions.assertEquals("[336, 311, 274, 224, 162, 87, 0]", traversal.getInorder().toString());
  }
}
