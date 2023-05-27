package com.github4sanjay.dsalgo.java.stream;

import java.util.Arrays;

public class ArrayStringToArrayInteger {

  public static void main(String[] args) {
    var arr = new String[] {"123", "11", "S124"};

    var result =
        Arrays.stream(arr)
            .filter(
                s -> {
                  try {
                    Integer.valueOf(s);
                  } catch (Exception e) {
                    return false;
                  }
                  return true;
                })
            .map(Integer::valueOf)
            .toArray(Integer[]::new);

    System.out.println(Arrays.toString(result));
  }
}
