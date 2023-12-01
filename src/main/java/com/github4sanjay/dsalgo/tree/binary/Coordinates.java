package com.github4sanjay.dsalgo.tree.binary;

import com.github4sanjay.dsalgo.tree.binary.structure.BinaryNode;
import com.github4sanjay.dsalgo.tree.binary.structure.BinaryTreeUtil;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
Find all occurrences of the element in the tree
List all coordinates right to left, top to bottom. Coordinates = (height, position from left)

X=35
               10
          /          \
       20               30
     /   \          /       \
    40   60       35        50
Output: [(3, 3)] // [10][30, 20][50, 35, 60, 40] 3, 3-1+1


X= 2
                 1
            /         \
         2            3
      /   \         /     \
   4       2      8        2
Output: [(2, 1), (3, 4), (3, 2)]

*/
public class Coordinates {
  public static void main(String[] args) {
    var root =
        BinaryTreeUtil.create(
            new int[] {10, 20, 40, -1, -1, 60, -1, -1, 30, 35, -1, -1, 50, -1, -1});
    System.out.println(getCoordinates(root, 35));

    root = BinaryTreeUtil.create(new int[] {1, 2, 4, -1, -1, 2, -1, -1, 3, 8, -1, -1, 2, -1, -1});
    System.out.println(getCoordinates(root, 2));
  }

  public static List<List<Integer>> getCoordinates(BinaryNode root, int element) {
    List<List<Integer>> result = new ArrayList<>();
    Queue<BinaryNode> queue = new LinkedList<>();
    queue.offer(root);
    queue.offer(null);
    int level = 1;
    int index = 1;
    int size = 1;
    while (!queue.isEmpty()) {
      BinaryNode current = queue.poll();
      if (current == null) {
        if (!queue.isEmpty()) {
          queue.offer(null);
        }
        level++;
        index = 1;
        size = queue.size() - 1;
        continue;
      }
      if (current.getData() == element) {
        result.add(List.of(level, size - index + 1));
      }
      if (current.getRight() != null) {
        queue.offer(current.getRight());
      }

      if (current.getLeft() != null) {
        queue.offer(current.getLeft());
      }
      index++;
    }

    return result;
  }
}
