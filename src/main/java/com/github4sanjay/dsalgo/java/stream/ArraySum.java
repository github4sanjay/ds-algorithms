package com.github4sanjay.dsalgo.java.stream;

import java.util.*;

class ArraySum {
  public static void main(String[] args) {
    var list = new ArrayList<Integer>();

    list.add(10);
    list.add(20);
    list.add(30);
    list.add(40);
    list.add(50);
    // Added the numbers into Arraylist
    System.out.println(sum(list));
  }

  public static int sum(List<Integer> list) {
    return list.stream().mapToInt(Integer::intValue).sum();
    // Found the total using sum() method after
    // converting it into Stream
  }
}
