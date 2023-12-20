package com.github4sanjay.dsalgo.tree.generic;

import static org.junit.jupiter.api.Assertions.*;

import com.github4sanjay.dsalgo.tree.generic.structure.GenericTreeUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CeilAndFloorTest {

  @Test
  public void test() {
    int[] arr =
        new int[] {
          10, 20, -50, -1, 60, -1, -1, 30, 70, -1, -80, 110, -1, -120, -1, -1, 90, -1, -1, 40, -100,
          -1, -1, -1
        };
    var root = GenericTreeUtil.createTree(arr);
    Assertions.assertEquals(
        "Answer{ceil=90, floor=60}", CeilAndFloor.iterative(root, 70).toString());
    Assertions.assertEquals(
        "Answer{ceil=90, floor=60}", CeilAndFloor.recursive(root, 70).toString());

    Assertions.assertEquals(
        "Answer{ceil=-50, floor=-100}", CeilAndFloor.iterative(root, -80).toString());
    Assertions.assertEquals(
        "Answer{ceil=-50, floor=-100}", CeilAndFloor.recursive(root, -80).toString());

    Assertions.assertEquals(
        "Answer{ceil=2147483647, floor=110}", CeilAndFloor.iterative(root, 800).toString());
    Assertions.assertEquals(
        "Answer{ceil=-120, floor=-2147483648}", CeilAndFloor.recursive(root, -800).toString());
  }
}
