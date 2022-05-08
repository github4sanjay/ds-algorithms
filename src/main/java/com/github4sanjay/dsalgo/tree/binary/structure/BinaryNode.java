package com.github4sanjay.dsalgo.tree.binary.structure;

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

  public int getData() {
    return data;
  }

  public void setData(int data) {
    this.data = data;
  }

  public BinaryNode getLeft() {
    return left;
  }

  public void setLeft(BinaryNode left) {
    this.left = left;
  }

  public BinaryNode getRight() {
    return right;
  }

  public void setRight(BinaryNode right) {
    this.right = right;
  }
}
