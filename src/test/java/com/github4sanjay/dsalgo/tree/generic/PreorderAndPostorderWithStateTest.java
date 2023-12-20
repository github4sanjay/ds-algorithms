package com.github4sanjay.dsalgo.tree.generic;

import static org.junit.jupiter.api.Assertions.*;

import com.github4sanjay.dsalgo.tree.generic.structure.GenericTreeUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class PreorderAndPostorderWithStateTest {

  @Test
  public void test() {
    var root =
        GenericTreeUtil.createTree(new int[] {10, 20, -1, 30, 50, -1, 60, -1, -1, 40, -1, -1});
    Assertions.assertEquals(
        "Answer{preorder=[10, 20, 30, 50, 60, 40], postorder=[20, 50, 60, 30, 40, 10]}",
        PreorderAndPostorderWithState.traverse(root).toString());
  }
}
