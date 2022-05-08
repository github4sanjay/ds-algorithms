package com.github4sanjay.dsalgo.tree.binary;

import static org.junit.jupiter.api.Assertions.*;

import com.github4sanjay.dsalgo.tree.binary.structure.BinaryTreeUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class HouseRobberInBinaryTreeTest {
  @Test
  public void test1() {
    var root1 =
        BinaryTreeUtil.create(new int[] {1, 1, -1, 1, 1, -1, 1, -1, -1, 1, -1, -1, 1, -1, -1});
    Assertions.assertEquals(4, HouseRobberInBinaryTree.get(root1));

    var root2 = BinaryTreeUtil.create(new int[] {3, 2, -1, 3, -1, -1, 3, -1, 1, -1, -1});
    Assertions.assertEquals(7, HouseRobberInBinaryTree.get(root2));

    var root3 = BinaryTreeUtil.create(new int[] {3, 4, 1, -1, -1, 3, -1, -1, 5, -1, 1, -1, -1});
    Assertions.assertEquals(9, HouseRobberInBinaryTree.get(root3));
  }
}
