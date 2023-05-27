package com.github4sanjay.dsalgo.java.stream;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FlatMapExample {

  public static void main(String[] args) {
    String[][] array = new String[][] {{"a", "b"}, {"c", "d"}, {"e", "f"}};
    List<String> collect =
        Stream.of(array) // Stream<String[]>
            .flatMap(Stream::of) // Stream<String>
            .filter(x -> !"a".equals(x)) // filter out the a
            .collect(Collectors.toList()); // return a List

    collect.forEach(System.out::println);
  }
}
