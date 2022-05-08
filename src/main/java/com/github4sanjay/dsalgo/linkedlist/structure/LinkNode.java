package com.github4sanjay.dsalgo.linkedlist.structure;

public class LinkNode<T> {
  private T data;
  private LinkNode<T> next;

  public LinkNode(T data, LinkNode<T> next) {
    this.data = data;
    this.next = next;
  }

  public T getData() {
    return data;
  }

  public void setData(T data) {
    this.data = data;
  }

  public LinkNode<T> getNext() {
    return next;
  }

  public void setNext(LinkNode<T> next) {
    this.next = next;
  }
}
