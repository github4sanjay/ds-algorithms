package com.github4sanjay.dsalgo.linkedlist.structure;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class LinkNode<T> {
  private T data;
  private LinkNode<T> next;

  public LinkNode(T data, LinkNode<T> next) {
    this.data = data;
    this.next = next;
  }
}
