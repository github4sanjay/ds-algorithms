package com.github4sanjay.dsalgo.java.stream;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class AllDuplicateElementInString {

  public static void main(String[] args) {
    var str = "ilovesanjay";
    var list =
        Arrays.stream(str.split(""))
            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
            .entrySet()
            .stream()
            .filter(entry -> entry.getValue() > 1)
            .map(Map.Entry::getKey)
            .toList();

    System.out.println(list);
  }
}
