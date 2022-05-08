package com.github4sanjay.dsalgo.designpattern.visitor;

public interface Employee {
  <T> T accept(Visitor<T> visitor);
}
