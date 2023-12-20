package com.github4sanjay.dsalgo.tree.generic;

import static org.junit.jupiter.api.Assertions.*;

import com.github4sanjay.dsalgo.tree.generic.structure.GenericTreeUtil;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class LevelOrderZigzagGenericTreeTest {

  @Test
  public void test() {
    var root =
        GenericTreeUtil.createTree(
            new int[] {
              10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120, -1, -1, 90, -1, -1, 40, 100,
              -1, -1, -1
            });
    var expected =
        List.of(
            List.of(10), List.of(20, 30, 40), List.of(100, 90, 80, 70, 60, 50), List.of(110, 120));
    Assertions.assertEquals(expected, LevelOrderZigzagGenericTree.traverse(root));
    Assertions.assertEquals(expected, LevelOrderZigzagGenericTree.traverseAlt(root));
    Assertions.assertEquals(expected, LevelOrderZigzagGenericTree.traverseThirdWay(root));
  }
}
