package com.github4sanjay.dsalgo.tree.generic;

import static org.junit.jupiter.api.Assertions.*;

import com.github4sanjay.dsalgo.tree.generic.structure.GenericTreeUtil;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class LevelOrderLineWiseGenericTreeTest {

  @Test
  public void testLevelOrderLineWiseGenericTree() {
    var root =
        GenericTreeUtil.createTree(
            new int[] {
              10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120, -1, -1, 90, -1, -1, 40, 100,
              -1, -1, -1
            });
    var expected =
        List.of(
            List.of(10), List.of(20, 30, 40), List.of(50, 60, 70, 80, 90, 100), List.of(110, 120));

    Assertions.assertEquals(expected, LevelOrderLineWiseGenericTree.traverse(root));
    Assertions.assertEquals(expected, LevelOrderLineWiseGenericTree.traverseSecondWay(root));
    Assertions.assertEquals(expected, LevelOrderLineWiseGenericTree.traverseThirdWay(root));
  }
}
