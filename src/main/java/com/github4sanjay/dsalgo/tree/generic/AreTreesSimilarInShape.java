package com.github4sanjay.dsalgo.tree.generic;

import com.github4sanjay.dsalgo.tree.generic.structure.Node;

public class AreTreesSimilarInShape {

  /**
   * root1 and root2 should have same number of children and all children at same position should
   * have same number of children
   */
  public static boolean check(Node root1, Node root2) {

    var children1 = root1.getChildren();
    var children2 = root2.getChildren();
    if (children1.size() != children2.size()) {
      return false;
    }

    for (int i = 0; i < children1.size(); i++) {
      if (!check(children1.get(i), children2.get(i))) {
        return false;
      }
    }
    return true;
  }
}
