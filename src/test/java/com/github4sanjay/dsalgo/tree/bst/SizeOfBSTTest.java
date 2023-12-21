package com.github4sanjay.dsalgo.tree.bst;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SizeOfBSTTest {

  @Test
  public void test() {
    var root = BSTFromInOrder.createFromInOrder(new int[] {12, 25, 37, 50, 62, 75, 87});
    Assertions.assertEquals(7, SizeOfBST.recursive(root)); // 7
  }
}
