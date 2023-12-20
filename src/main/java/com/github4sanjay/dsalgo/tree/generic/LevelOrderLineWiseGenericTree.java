package com.github4sanjay.dsalgo.tree.generic;

import com.github4sanjay.dsalgo.tree.generic.structure.Node;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LevelOrderLineWiseGenericTree {

  // use queue and null as marker of level
  public static List<List<Integer>> traverse(Node root) {
    var queue = new LinkedList<Node>();
    queue.offer(root);
    queue.offer(null);
    var finalList = new ArrayList<List<Integer>>();
    var list = new ArrayList<Integer>();
    while (!queue.isEmpty()) {
      var node = queue.poll();
      if (node != null) {
        list.add(node.getData());
        for (var child : node.getChildren()) {
          queue.offer(child);
        }
      } else {
        finalList.add(list);
        if (!queue.isEmpty()) {
          list = new ArrayList<>();
          queue.offer(null);
        }
      }
    }
    return finalList;
  }

  // with the help of two queue
  public static List<List<Integer>> traverseSecondWay(Node root) {
    var queue = new LinkedList<Node>();
    var childQueue = new LinkedList<Node>();
    queue.offer(root);
    var finalList = new ArrayList<List<Integer>>();
    var list = new ArrayList<Integer>();
    while (!(queue.isEmpty() && childQueue.isEmpty())) {
      if (!queue.isEmpty()) {
        var node = queue.poll();
        list.add(node.getData());
        for (var child : node.getChildren()) {
          childQueue.offer(child);
        }
      } else {
        finalList.add(list);
        list = new ArrayList<>();
        while (!childQueue.isEmpty()) {
          queue.offer(childQueue.poll());
        }
      }
    }
    finalList.add(list);
    return finalList;
  }

  public static List<List<Integer>> traverseThirdWay(Node root) {
    var queue = new LinkedList<Node>();
    queue.offer(root);
    var finalList = new ArrayList<List<Integer>>();
    var list = new ArrayList<Integer>();
    while (!queue.isEmpty()) {
      var size = queue.size();
      for (int i = 0; i < size; i++) {
        var node = queue.poll();
        list.add(node.getData());
        for (var child : node.getChildren()) {
          queue.offer(child);
        }
      }
      finalList.add(list);
      list = new ArrayList<>();
    }
    return finalList;
  }
}
