package com.github4sanjay.dsalgo.tree.generic;

import com.github4sanjay.dsalgo.tree.generic.structure.Node;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class LevelOrderZigzagGenericTree {

  // use queue and null as differentiator of level
  public static List<List<Integer>> traverse(Node root) {
    var queue = new LinkedList<Node>();
    queue.offer(root);
    queue.offer(null);
    var finalList = new ArrayList<List<Integer>>();
    var list = new ArrayList<Integer>();
    boolean leftToRight = false;
    while (!queue.isEmpty()) {
      var node = queue.poll();
      if (node != null) {
        list.add(node.getData());
        for (var child : node.getChildren()) {
          queue.offer(child);
        }
      } else {
        if (leftToRight) {
          finalList.add(list);
        } else {
          Collections.reverse(list);
          finalList.add(list);
        }
        leftToRight = !leftToRight;
        if (!queue.isEmpty()) {
          list = new ArrayList<>();
          queue.offer(null);
        }
      }
    }
    return finalList;
  }

  // with the help of two queue
  public static List<List<Integer>> traverseAlt(Node root) {
    var queue = new LinkedList<Node>();
    var childQueue = new LinkedList<Node>();
    queue.offer(root);
    var finalList = new ArrayList<List<Integer>>();
    var list = new ArrayList<Integer>();
    boolean leftToRight = false;
    while (!(queue.isEmpty() && childQueue.isEmpty())) {
      if (!queue.isEmpty()) {
        var node = queue.poll();
        list.add(node.getData());
        for (var child : node.getChildren()) {
          childQueue.offer(child);
        }
      } else {
        if (leftToRight) {
          finalList.add(list);
        } else {
          Collections.reverse(list);
          finalList.add(list);
        }
        leftToRight = !leftToRight;
        list = new ArrayList<>();
        while (!childQueue.isEmpty()) {
          queue.offer(childQueue.poll());
        }
      }
    }
    if (leftToRight) {
      finalList.add(list);
    } else {
      Collections.reverse(list);
      finalList.add(list);
    }
    return finalList;
  }

  public static List<List<Integer>> traverseThirdWay(Node root) {
    var queue = new LinkedList<Node>();
    queue.offer(root);
    var finalList = new ArrayList<List<Integer>>();
    var list = new ArrayList<Integer>();
    boolean leftToRight = false;
    while (!queue.isEmpty()) {
      var size = queue.size();
      for (int i = 0; i < size; i++) {
        var node = queue.poll();
        list.add(node.getData());
        for (var child : node.getChildren()) {
          queue.offer(child);
        }
      }
      if (leftToRight) {
        finalList.add(list);
      } else {
        Collections.reverse(list);
        finalList.add(list);
      }
      leftToRight = !leftToRight;
      list = new ArrayList<>();
    }
    return finalList;
  }
}
