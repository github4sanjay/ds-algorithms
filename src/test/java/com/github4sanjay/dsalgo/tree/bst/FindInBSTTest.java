package com.github4sanjay.dsalgo.tree.bst;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class FindInBSTTest {

  @Test
  public void test() {
    var root = BSTFromInOrder.createFromInOrder(new int[] {1, 2, 3, 4, 5, 6, 7});
    Assertions.assertTrue(FindInBST.recursive(root, 6)); // true
    Assertions.assertFalse(FindInBST.recursive(root, 8)); // false
  }
}
