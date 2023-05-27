package com.github4sanjay.dsalgo;

import java.io.*;
import java.util.*;

public class Solution {

  public static void main(String[] args) {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
    Scanner scanner = new Scanner(System.in);
    int tests = scanner.nextInt();
    for (int i = 0; i < tests; i++) {
      int numberOfIds = scanner.nextInt();

      Set<Integer> set1 = new HashSet<>();
      for (int j = 0; j < numberOfIds; j++) {
        int temp = scanner.nextInt();
        set1.add(temp);
      }

      for (int j = 0; j < numberOfIds - 1; j++) {
        set1.remove(scanner.nextInt());
      }

      for (int item : set1) {
        System.out.println(item);
      }
    }
  }
}
