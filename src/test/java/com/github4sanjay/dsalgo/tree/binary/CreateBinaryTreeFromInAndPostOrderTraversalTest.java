package com.github4sanjay.dsalgo.tree.binary;

import static org.junit.jupiter.api.Assertions.*;

import com.github4sanjay.dsalgo.tree.binary.structure.BinaryTreeUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CreateBinaryTreeFromInAndPostOrderTraversalTest {

  @Test
  public void test() {

    var root =
        BinaryTreeUtil.create(
            new int[] {50, 25, 12, -1, -1, 37, 30, -1, -1, -1, 75, 62, -1, 70, -1, -1, 87, -1, -1});
    var answer = TraversalBinaryTree.recursive(root);

    var newRoot =
        CreateBinaryTreeFromInAndPostOrderTraversal.buildTree(
            answer.getInorder().toArray(Integer[]::new),
            answer.getPostorder().toArray(Integer[]::new));

    var newAnswer = TraversalBinaryTree.recursive(newRoot);
    Assertions.assertEquals(answer.getInorder(), newAnswer.getInorder());
    Assertions.assertEquals(answer.getPreorder(), newAnswer.getPreorder());
    Assertions.assertEquals(answer.getPostorder(), newAnswer.getPostorder());
  }
}
