package com.github4sanjay.dsalgo.tree.bst;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SumOfBSTTest {

  @Test
  public void test() {
    var root = BSTFromInOrder.createFromInOrder(new int[] {1, 2, 3, 4, 5, 6, 7});
    Assertions.assertEquals(28, SumOfBST.recursive(root));
  }
}
