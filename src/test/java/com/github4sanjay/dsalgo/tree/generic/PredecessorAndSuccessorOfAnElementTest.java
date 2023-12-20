package com.github4sanjay.dsalgo.tree.generic;

import static org.junit.jupiter.api.Assertions.*;

import com.github4sanjay.dsalgo.tree.generic.structure.GenericTreeUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class PredecessorAndSuccessorOfAnElementTest {

  @Test
  public void test() {
    int[] arr =
        new int[] {
          10, 20, -50, -1, 60, -1, -1, 30, 70, -1, -80, 110, -1, -120, -1, -1, 90, -1, -1, 40, -100,
          -1, -1, -1
        };
    var root = GenericTreeUtil.createTree(arr);
    var answerIterative = PredecessorAndSuccessorOfAnElement.iterative(root, -120);
    var answerRecursive = PredecessorAndSuccessorOfAnElement.recursive(root, -120);

    Assertions.assertEquals("Answer{predecessor=110, successor=90}", answerIterative.toString());
    Assertions.assertEquals("Answer{predecessor=110, successor=90}", answerIterative.toString());
  }
}
