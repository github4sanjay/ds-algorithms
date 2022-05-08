package com.github4sanjay.dsalgo.tree.binary;

import com.github4sanjay.dsalgo.tree.binary.structure.BinaryNode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 1. You are given a partially written function to solve. 2. The thief has found himself a new
 * place for his thievery again. There is only one entrance to this area, called the "root." Besides
 * the root, each house has one and only one parent house. After a tour, the smart thief realized
 * that "all houses in this place forms a binary tree". It will automatically contact the police if
 * two directly-linked houses were broken into on the same night. Determine the maximum amount of
 * money the thief can rob tonight without alerting the police. 3. Input and Output is managed for
 * you.
 *
 * <p>Constraints 0 <= Number of Nodes <= 10^9 -10^9 <= value of Node data <= 10^9
 *
 * <p>Format Input Input is managed for you.
 *
 * <p>Output Output is managed for you.
 *
 * <p>Example Sample Input
 *
 * <p>15 1 1 -1 1 1 -1 1 -1 -1 1 -1 -1 1 -1 -1
 *
 * <p>Sample Output 4
 */
public class HouseRobberInBinaryTree {

  public static Integer get(BinaryNode node) {
    var result = find(node);
    return Math.max(result.getWithRobbery(), result.getWithoutRobbery());
  }

  private static Money find(BinaryNode node) {
    if (node == null) return new Money();
    var lChild = find(node.getLeft());
    var rChild = find(node.getRight());
    // max of with or without robbery
    return new Money(
        lChild.getWithoutRobbery() + rChild.getWithoutRobbery() + node.getData(),
        Math.max(lChild.getWithRobbery(), lChild.getWithoutRobbery())
            + Math.max(rChild.getWithRobbery(), rChild.getWithoutRobbery()));
  }

  @Getter
  @NoArgsConstructor
  @AllArgsConstructor
  public static class Money {
    private int withRobbery;
    private int withoutRobbery;
  }
}
