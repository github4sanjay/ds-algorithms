package com.github4sanjay.dsalgo.util;

import java.util.Objects;
import lombok.Getter;

@Getter
public class Pair {

  int data1;
  int data2;

  public Pair(int data1, int data2) {
    this.data1 = data1;
    this.data2 = data2;
  }

  @Override
  public String toString() {
    return "Pair{" + "data1=" + data1 + ", data2=" + data2 + '}';
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null || getClass() != obj.getClass()) return false;
    Pair pair = (Pair) obj;
    return data1 == pair.data1 && data2 == pair.data2;
  }

  @Override
  public int hashCode() {
    return Objects.hash(data1, data2);
  }
}
