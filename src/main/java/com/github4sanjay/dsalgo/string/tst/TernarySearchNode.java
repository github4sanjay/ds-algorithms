package com.github4sanjay.dsalgo.string.tst;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class TernarySearchNode {

  private char data;
  private boolean isEndOfString;
  private TernarySearchNode left;
  private TernarySearchNode equal;
  private TernarySearchNode right;

  public TernarySearchNode(char data) {
    this.data = data;
  }

  public boolean isEndOfString() {
    return isEndOfString;
  }

  public void setEndOfString(boolean endOfString) {
    isEndOfString = endOfString;
  }
}
