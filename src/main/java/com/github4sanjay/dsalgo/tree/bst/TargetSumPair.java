package com.github4sanjay.dsalgo.tree.bst;

import com.github4sanjay.dsalgo.array.FindPair;
import com.github4sanjay.dsalgo.tree.binary.IterativeTraversalBinaryTree;
import com.github4sanjay.dsalgo.tree.binary.TraversalBinaryTree;
import com.github4sanjay.dsalgo.tree.binary.structure.BinaryNode;
import com.github4sanjay.dsalgo.util.Pair;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TargetSumPair {

  public static List<Pair> mostEfficient(BinaryNode root, int targetSum) {
    var list = new ArrayList<Pair>();
    var inOrderStack = new Stack<IterativeTraversalBinaryTree.Pair>();
    var reverseInOrderStack = new Stack<IterativeTraversalBinaryTree.Pair>();

    inOrderStack.push(new IterativeTraversalBinaryTree.Pair(root, 0));
    reverseInOrderStack.push(new IterativeTraversalBinaryTree.Pair(root, 0));

    var left = IterativeTraversalBinaryTree.getNextFromNormalInOrder(inOrderStack);
    var right = IterativeTraversalBinaryTree.getNextFromReverseInOrder(reverseInOrderStack);

    while (left.getData() < right.getData()) {
      if (left.getData() + right.getData() < targetSum) {
        left = IterativeTraversalBinaryTree.getNextFromNormalInOrder(inOrderStack);
      } else if (left.getData() + right.getData() > targetSum) {
        right = IterativeTraversalBinaryTree.getNextFromReverseInOrder(reverseInOrderStack);
      } else {
        list.add(new Pair(left.getData(), right.getData()));
        left = IterativeTraversalBinaryTree.getNextFromNormalInOrder(inOrderStack);
        right = IterativeTraversalBinaryTree.getNextFromReverseInOrder(reverseInOrderStack);
      }
    }

    return list;
  }

  // efficient : first find inorder gives sorted array then find pair
  public static List<Pair> findEfficient(BinaryNode root, int targetSum) {
    var traversal = TraversalBinaryTree.recursive(root);
    return FindPair.find(traversal.getInorder(), targetSum);
  }

  // Time complexity O(nlogn)
  public static List<Pair> find(BinaryNode root, int targetSum) {
    var list = new ArrayList<Pair>();
    find(root, root, targetSum, list);
    return list;
  }

  private static void find(
      BinaryNode root, BinaryNode currentRoot, int targetSum, List<Pair> list) {
    if (currentRoot == null) return;

    find(root, currentRoot.getLeft(), targetSum, list);
    int complement = targetSum - currentRoot.getData();
    if (currentRoot.getData() < complement) { // remove duplicates
      if (FindInBST.recursive(root, complement)) {
        list.add(new Pair(currentRoot.getData(), complement));
      }
    }
    find(root, currentRoot.getRight(), targetSum, list);
  }
}
