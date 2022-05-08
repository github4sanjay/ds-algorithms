package com.github4sanjay.dsalgo.maths;

public class AnyBaseToAnyBase {

  public static void main(String[] args) {
    System.out.println(AnyBaseToAnyBase.find(111001, 2, 3));
  }

  private static int find(int number, int fromBase, int toBase) {
    int decimal = AnyBaseToDecimal.find(number, fromBase);
    return DecimalToAnyBase.find(decimal, toBase);
  }
}
