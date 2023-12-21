package com.github4sanjay.dsalgo.tree.binary;

import com.github4sanjay.dsalgo.tree.binary.structure.BinaryTreeUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TopViewOfBinaryTreeTest {

  @Test
  public void test() {
    var root =
        BinaryTreeUtil.create(
            new int[] {50, 25, 12, -1, -1, 37, 30, -1, -1, -1, 75, 62, -1, 70, -1, -1, 87, -1, -1});
    var list = TopViewOfBinaryTree.find(root);
    Assertions.assertEquals("[[12], [25, 30], [50, 37, 62], [75, 70], [87]]", list.toString());
  }
}
