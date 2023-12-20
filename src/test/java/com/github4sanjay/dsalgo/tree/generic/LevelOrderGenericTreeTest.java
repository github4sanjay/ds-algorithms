package com.github4sanjay.dsalgo.tree.generic;

import com.github4sanjay.dsalgo.tree.generic.structure.GenericTreeUtil;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class LevelOrderGenericTreeTest {

  @Test
  public void testLevelOrderGenericTree() {
    var root =
        GenericTreeUtil.createTree(
            new int[] {
              10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120, -1, -1, 90, -1, -1, 40, 100,
              -1, -1, -1
            });
    Assertions.assertEquals(
        List.of(10, 20, 30, 40, 50, 60, 70, 80, 90, 100, 110, 120),
        LevelOrderGenericTree.traverse(root));
  }
}
