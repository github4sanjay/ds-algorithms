package com.github4sanjay.dsalgo.tree.bst;

import static org.junit.jupiter.api.Assertions.*;

import com.github4sanjay.dsalgo.tree.binary.structure.BinaryTreeUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class FindBetweenRangeTest {

  @Test
  public void test() {
    int n = -1;
    var root =
        BinaryTreeUtil.create(
            new int[] {50, 25, 12, n, n, 37, 30, n, n, n, 75, 62, 60, n, n, 70, n, n, 87, n, n});
    Assertions.assertEquals(
        "[12, 25, 30, 37, 50, 60, 62]", FindBetweenRange.find(root, 12, 65).toString());
  }
}
