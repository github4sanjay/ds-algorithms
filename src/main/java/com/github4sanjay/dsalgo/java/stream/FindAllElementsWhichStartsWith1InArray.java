package com.github4sanjay.dsalgo.java.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FindAllElementsWhichStartsWith1InArray {

  public static void main(String[] args) {
    System.out.println(get(new int[] {5, 9, 11, 2, 8, 21, 1}));

    var list = new ArrayList<Integer>();
    Arrays.stream(new int[] {5, 9, 11, 2, 8, 21, 1})
        .boxed()
        .parallel()
        .forEach(integer -> list.add(integer + 1));
    System.out.println(list);
  }

  private static List<String> get(int[] arr) {
    return Arrays.stream(arr)
        .boxed()
        .map(String::valueOf)
        .filter(s -> s.startsWith("1"))
        .collect(Collectors.toList());
  }
}
