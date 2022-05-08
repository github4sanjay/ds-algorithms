package com.github4sanjay.dsalgo.tree.generic;

import com.github4sanjay.dsalgo.tree.generic.structure.GenericTreeUtil;
import com.github4sanjay.dsalgo.tree.generic.structure.Node;

public class IsGenericTreeSymmetric {

  public static void main(String[] args) {
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

    System.out.println(IsGenericTreeSymmetric.check(root1));
    System.out.println(IsGenericTreeSymmetric.check(root2));

    var root3 =
        GenericTreeUtil.createTree(new int[] {10, 20, -1, 30, 50, -1, 60, -1, -1, 40, -1, -1});
    System.out.println(IsGenericTreeSymmetric.check(root3));

    var root4 =
        GenericTreeUtil.createTree(
            new int[] {
              10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, -1, 90, -1, -1, 40, 100, -1, 110, -1, -1,
              -1
            });
    System.out.println(IsGenericTreeSymmetric.check(root4));
  }

  // if symmetric then mirror image of itself
  private static boolean check(Node root) {
    return AreTreesMirrorInShape.check(root, root);
  }
}
