package com.github4sanjay.dsalgo.tree.generic;

import com.github4sanjay.dsalgo.tree.generic.structure.Node;

public class AreTreesMirrorInShape {

  /**
   * Number of children of root1 first child and number of children of root2 last child should be
   * equal and same for other children at different positions
   */
  public static boolean check(Node root1, Node root2) {

    var children1 = root1.getChildren();
    var children2 = root2.getChildren();
    if (children1.size() != children2.size()) {
      return false;
    }

    for (int i = 0; i < children1.size(); i++) {
      if (!check(children1.get(i), children2.get(children1.size() - i - 1))) {
        return false;
      }
    }
    return true;
  }
}
