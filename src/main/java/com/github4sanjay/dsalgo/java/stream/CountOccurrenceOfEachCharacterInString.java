package com.github4sanjay.dsalgo.java.stream;

import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CountOccurrenceOfEachCharacterInString {

  public static void main(String[] args) {

    var str = "ilovesanjay";
    var map =
        Arrays.stream(str.split(""))
            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

    System.out.println(map);

    var arr = new int[] {5, 9, 11, 2, 8, 21, 1};

    var map1 =
        Arrays.stream(arr)
            .boxed()
            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

    System.out.println(map1);
  }
}
