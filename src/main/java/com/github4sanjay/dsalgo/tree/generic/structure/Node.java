package com.github4sanjay.dsalgo.tree.generic.structure;

import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Node {

  private int data;
  private final List<Node> children = new ArrayList<>();

  public void addChildren(Node node) {
    children.add(node);
  }
}
