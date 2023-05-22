package com.github4sanjay.dsalgo.java.stream;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindFirstNonRepeatElementInString {

  public static void main(String[] args) {
    System.out.println(get("ilovesanjay"));
    System.out.println(get("ixxbbcdi"));
  }

  private static String get(String str) {
    return Arrays.stream(str.split(""))
        .collect(
            Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
        .entrySet()
        .stream()
        .filter(entry -> entry.getValue() == 1)
        .map(Map.Entry::getKey)
        .findFirst()
        .orElse(null);
  }
}
