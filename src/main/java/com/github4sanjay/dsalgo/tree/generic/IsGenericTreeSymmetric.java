package com.github4sanjay.dsalgo.tree.generic;

import com.github4sanjay.dsalgo.tree.generic.structure.Node;

public class IsGenericTreeSymmetric {

  // if symmetric then mirror image of itself
  public static boolean check(Node root) {
    return AreTreesMirrorInShape.check(root, root);
  }
}
