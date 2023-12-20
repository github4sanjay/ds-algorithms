package com.github4sanjay.dsalgo.tree.generic;

import static org.junit.jupiter.api.Assertions.*;

import com.github4sanjay.dsalgo.tree.generic.structure.GenericTreeUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class NodeWithMaximumSubtreeSumTest {

  @Test
  public void test() {
    int[] arr =
        new int[] {
          10, 20, -50, -1, 60, -1, -1, 30, -70, -1, 80, -1, 90, -1, -1, 40, -100, -1, -1, -1
        };
    var root = GenericTreeUtil.createTree(arr);
    Assertions.assertEquals(
        "Answer{maxSum=130, node=30}", NodeWithMaximumSubtreeSum.find(root).toString());
  }
}
