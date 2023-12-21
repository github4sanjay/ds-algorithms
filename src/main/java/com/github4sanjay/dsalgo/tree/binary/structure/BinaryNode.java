package com.github4sanjay.dsalgo.tree.binary.structure;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class BinaryNode {
  private int data;
  private BinaryNode left;
  private BinaryNode right;

  public BinaryNode(int data, BinaryNode left, BinaryNode right) {
    this.data = data;
    this.left = left;
    this.right = right;
  }

  public BinaryNode(int data) {
    this.data = data;
    this.left = null;
    this.right = null;
  }
}
