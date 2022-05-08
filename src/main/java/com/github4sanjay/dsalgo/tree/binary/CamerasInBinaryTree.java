package com.github4sanjay.dsalgo.tree.binary;

import com.github4sanjay.dsalgo.tree.binary.structure.BinaryNode;
import lombok.Getter;

/**
 * 1. You are given a partially written function to solve. 2. You are required to complete the body
 * of MinCamerasInBT_ function. The function is expected to return integer value representing
 * minimum number of camera(s) required for the coverage of complete tree. 3.A camera is placed on
 * any node will ensure coverage of parent-node as well as it's child-node(s), if any. 4. Input and
 * Output is managed for you.
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
 * <p>Sample Output 3
 */
public class CamerasInBinaryTree {

  public static Integer find(BinaryNode node) {
    var answer = new Answer();
    if (find(node, answer) == -1) {
      answer.increment();
    }
    return answer.getCamera();
  }

  /*
     if return
     -1 = need
     0 = have camera
     1 = covered
  */
  private static int find(BinaryNode node, Answer answer) {
    if (node == null) return 1;
    var lChild = find(node.getLeft(), answer);
    var rChild = find(node.getRight(), answer);
    if (lChild == -1 || rChild == -1) {
      answer.increment();
      return 0;
    }
    if (lChild == 0 || rChild == 0) {
      return 1;
    }
    return -1;
  }

  @Getter
  public static class Answer {
    private int camera;

    public void increment() {
      camera = camera + 1;
    }
  }
}
