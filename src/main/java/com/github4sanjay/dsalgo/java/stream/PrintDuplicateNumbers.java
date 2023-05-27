package com.github4sanjay.dsalgo.java.stream;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class PrintDuplicateNumbers {

  public static void main(String[] args) {
    var list = List.of(11, 15, 11, 45, 46, 99, 10, 99);
    Set<Integer> collect =
        list.stream().filter(e -> Collections.frequency(list, e) > 1).collect(Collectors.toSet());
    System.out.println(collect);

    var altSet = new HashSet<Integer>();
    var set = list.stream().filter(e -> !altSet.add(e)).collect(Collectors.toSet());
    System.out.println(set);
  }
}
