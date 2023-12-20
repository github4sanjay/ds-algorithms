package com.github4sanjay.dsalgo.tree.generic;

import static org.junit.jupiter.api.Assertions.*;

import com.github4sanjay.dsalgo.tree.generic.structure.GenericTreeUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MaxGenericTreeTest {

  @Test
  public void testMaxGenericTree() {
    var root =
        GenericTreeUtil.createTree(new int[] {10, 20, -1, 30, 50, -1, 60, -1, -1, 40, -1, -1});
    Assertions.assertEquals(60, MaxGenericTree.find(root));
    Assertions.assertEquals(60, MaxGenericTree.findRecursion(root));
  }
}
