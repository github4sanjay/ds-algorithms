package com.github4sanjay.dsalgo.java.stream;

import java.util.List;

public class StringJoinExample {

  public static void main(String[] args) {
    var stream = List.of("sanjay", "Kumar");

    System.out.println(String.join(" ", stream));
  }
}
