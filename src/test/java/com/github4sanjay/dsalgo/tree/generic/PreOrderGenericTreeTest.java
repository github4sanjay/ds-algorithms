package com.github4sanjay.dsalgo.tree.generic;

import com.github4sanjay.dsalgo.tree.generic.structure.GenericTreeUtil;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class PreOrderGenericTreeTest {

  @Test
  public void testPreOrderGenericTree() {
    var root =
        GenericTreeUtil.createTree(new int[] {10, 20, -1, 30, 50, -1, 60, -1, -1, 40, -1, -1});
    var expected = List.of(10, 20, 30, 50, 60, 40);
    Assertions.assertEquals(expected, PreOrderGenericTree.traverse(root));
    Assertions.assertEquals(expected, PreOrderGenericTree.traverseRecursion(root));
  }
}
