package com.github4sanjay.dsalgo.tree.binary;

import static org.junit.jupiter.api.Assertions.*;

import com.github4sanjay.dsalgo.tree.binary.structure.BinaryTreeUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CamerasInBinaryTreeTest {

  @Test
  public void test() {
    var root =
        BinaryTreeUtil.create(new int[] {1, 1, -1, 1, 1, -1, 1, -1, -1, 1, -1, -1, 1, -1, -1});
    Assertions.assertEquals(3, CamerasInBinaryTree.find(root));
  }
}
