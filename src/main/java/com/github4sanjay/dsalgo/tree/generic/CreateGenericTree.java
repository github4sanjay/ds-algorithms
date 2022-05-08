package com.github4sanjay.dsalgo.tree.generic;

import com.github4sanjay.dsalgo.tree.generic.structure.GenericTreeUtil;

public class CreateGenericTree {

  public static void main(String[] args) {
    int[] arr =
        new int[] {
          10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120, -1, -1, 90, -1, -1, 40, 100, -1,
          -1, -1
        };

    var root = GenericTreeUtil.createTree(arr);
    // {80=[110, 120], 50=[], 100=[], 20=[50, 60], 70=[], 40=[100], 120=[], 10=[20, 30, 40], 90=[],
    // 60=[], 30=[70, 80, 90], 110=[]}
    System.out.println(GenericTreeUtil.displayRecursion(root));

    GenericTreeUtil.display(root);
  }
}
