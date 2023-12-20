package com.github4sanjay.dsalgo.tree.generic;

import static org.junit.jupiter.api.Assertions.*;

import com.github4sanjay.dsalgo.tree.generic.structure.GenericTreeUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class FindInGenericTreeTest {

  @Test
  public void test() {
    var root =
        GenericTreeUtil.createTree(new int[] {10, 20, -1, 30, 50, -1, 60, -1, -1, 40, -1, -1});
    Assertions.assertTrue(FindInGenericTree.find(root, 40));
    Assertions.assertTrue(FindInGenericTree.findRecursion(root, 40));

    Assertions.assertFalse(FindInGenericTree.find(root, 140));
    Assertions.assertFalse(FindInGenericTree.findRecursion(root, 140));
  }
}
