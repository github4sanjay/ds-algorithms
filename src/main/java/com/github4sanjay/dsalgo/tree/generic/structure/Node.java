package com.github4sanjay.dsalgo.tree.generic.structure;

import java.util.ArrayList;
import java.util.List;

public class Node {
  private int data;
  private List<Node> children = new ArrayList<>();

  public int getData() {
    return data;
  }

  public List<Node> getChildren() {
    return children;
  }

  public void setData(int data) {
    this.data = data;
  }

  public void addChildren(Node node) {
    children.add(node);
  }
}
