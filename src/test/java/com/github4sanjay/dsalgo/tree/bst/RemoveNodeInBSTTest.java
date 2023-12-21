package com.github4sanjay.dsalgo.tree.bst;

import com.github4sanjay.dsalgo.tree.binary.TraversalBinaryTree;
import com.github4sanjay.dsalgo.tree.binary.structure.BinaryTreeUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class RemoveNodeInBSTTest {

  @Test
  public void test() {
    int n = -1;
    var root =
        BinaryTreeUtil.create(
            new int[] {
              50, 25, 12, n, n, 37, 30, n, n, 40, n, n, 75, 62, 60, n, n, 70, n, n, 87, n, n
            });

    RemoveNodeInBST.remove(root, 60);
    var traversal = TraversalBinaryTree.recursive(root);
    Assertions.assertEquals(
        "[12, 25, 30, 37, 40, 50, 62, 70, 75, 87]", traversal.getInorder().toString());
  }
}
