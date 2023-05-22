package com.github4sanjay.dsalgo.java.stream;

import java.util.Arrays;

public class FindLongestStringInArray {

  public static void main(String[] args) {
    System.out.println(get(new String[] {"sanjay", "san", "jay", "iron man"}));
  }

  private static String get(String[] strs) {
    return Arrays.stream(strs)
        .reduce((word1, word2) -> word1.length() > word2.length() ? word1 : word2)
        .orElse(null);
  }
}
