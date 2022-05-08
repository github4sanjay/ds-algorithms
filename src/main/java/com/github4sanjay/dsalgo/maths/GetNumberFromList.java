package com.github4sanjay.dsalgo.maths;

import java.util.List;

public class GetNumberFromList {

  public static int getNumberFromList(List<Integer> list) {
    int place = 1;
    int sum = 0;
    for (int integer : list) {
      sum = sum + place * integer;
      place = place * 10;
    }
    return sum;
  }
}
