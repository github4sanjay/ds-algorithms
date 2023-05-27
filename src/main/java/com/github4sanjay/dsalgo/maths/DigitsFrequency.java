package com.github4sanjay.dsalgo.maths;

public class DigitsFrequency {

  public static int find(int n, int digit) {
    int frequency = 0;
    while (n > 0) {
      if (n % 10 == digit) frequency++;
      n = n / 10;
    }
    return frequency;
  }

  public static void main(String[] args) {
    System.out.println(find(99879, 9));
    System.out.println(find(1111, 9));
    System.out.println(find(9, 9));
    System.out.println(find(99, 9));
  }
}
