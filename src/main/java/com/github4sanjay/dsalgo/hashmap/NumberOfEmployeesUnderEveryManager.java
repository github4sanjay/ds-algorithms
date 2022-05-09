package com.github4sanjay.dsalgo.hashmap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 1. You are given number N and 2*N number of strings that contains mapping of the employee and his
 * manager. 2. An employee directly reports to only one manager. 3. All managers are employees but
 * the reverse is not true. 4. An employee reporting to himself is the CEO of the company. 5. You
 * have to find the number of employees under each manager in the hierarchy not just their direct
 * reports.
 *
 * <p>Input: 6 A C B C C F D E E F F F
 *
 * <p>Output: A 0 B 0 C 2 D 0 E 1 F 5
 */
public class NumberOfEmployeesUnderEveryManager {

  public static Map<Character, Integer> find(char[][] relations) {
    var map = new HashMap<Character, Integer>();
    if (relations.length == 0) return map;
    var charVsNode = new HashMap<Character, Node>();
    Node root = null;
    for (char[] relation : relations) {
      char manager = relation[1];
      char employee = relation[0];
      var managerNode = charVsNode.get(manager);
      if (managerNode == null) {
        managerNode = new Node(manager);
        charVsNode.put(manager, managerNode);
      }

      if (manager == employee) { // CEO of company
        root = managerNode;
        continue;
      }

      var employeeNode = charVsNode.get(employee);
      if (employeeNode == null) {
        employeeNode = new Node(employee);
      }
      managerNode.addRelation(employeeNode);
    }
    traverse(root, map);
    return map;
  }

  private static int traverse(Node root, HashMap<Character, Integer> map) {

    int sum = 0;
    for (var relation : root.relations) {
      sum = sum + traverse(relation, map);
    }
    map.put(root.ch, sum);
    return sum + 1;
  }

  private static class Node {
    char ch;
    List<Node> relations;

    public Node(char ch) {
      this.ch = ch;
      this.relations = new ArrayList<>();
    }

    public void addRelation(Node child) {
      relations.add(child);
    }
  }
}
