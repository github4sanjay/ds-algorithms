package com.github4sanjay.dsalgo.tree.generic;

import static org.junit.jupiter.api.Assertions.*;

import com.github4sanjay.dsalgo.tree.generic.structure.GenericTreeUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class IsGenericTreeSymmetricTest {

  @Test
  public void test() {
    int[] arr1 =
        new int[] {
          10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120, -1, -1, 90, -1, -1, 40, 100, -1,
          -1, -1
        };
    var root1 = GenericTreeUtil.createTree(arr1);

    int[] arr2 =
        new int[] {
          1, 2, 5, -1, 6, -1, -1, 3, 7, -1, 8, 11, -1, 12, -1, -1, 9, -1, -1, 4, 10, -1, -1, -1
        };
    var root2 = GenericTreeUtil.createTree(arr2);

    Assertions.assertFalse(IsGenericTreeSymmetric.check(root1));
    Assertions.assertFalse(IsGenericTreeSymmetric.check(root2));

    var root3 =
        GenericTreeUtil.createTree(new int[] {10, 20, -1, 30, 50, -1, 60, -1, -1, 40, -1, -1});
    Assertions.assertTrue(IsGenericTreeSymmetric.check(root3));

    var root4 =
        GenericTreeUtil.createTree(
            new int[] {
              10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, -1, 90, -1, -1, 40, 100, -1, 110, -1, -1,
              -1
            });
    Assertions.assertTrue(IsGenericTreeSymmetric.check(root4));
  }
}
