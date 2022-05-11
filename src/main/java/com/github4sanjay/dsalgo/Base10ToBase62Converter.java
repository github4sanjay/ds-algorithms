package com.github4sanjay.dsalgo;

public class Base10ToBase62Converter {

  public static final char[] ALPHABET =
      "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz".toCharArray();
  public static final int BASE = ALPHABET.length;

  public static String fromBase10(long i) {
    if (i == 0) {
      return "0";
    }
    var divisor = BASE;
    var dividend = i;
    var remainders = new StringBuilder();
    while (dividend > 0) {
      var quotient = dividend / divisor;
      remainders.append(ALPHABET[(int) (dividend % divisor)]);
      dividend = quotient;
    }
    return remainders.reverse().toString();
  }
}
