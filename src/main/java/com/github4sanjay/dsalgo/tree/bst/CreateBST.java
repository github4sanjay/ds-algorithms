package com.github4sanjay.dsalgo.tree.bst;

import com.github4sanjay.dsalgo.util.AlgoUtil;

public class CreateBST {

  public static void main(String[] args) {
    var root = BSTUtil.create(new int[] {12, 25, 37, 50, 62, 75, 87});
    AlgoUtil.print(BSTUtil.display(root));
  }
}
