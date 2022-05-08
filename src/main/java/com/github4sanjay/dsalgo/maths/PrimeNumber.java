package com.github4sanjay.dsalgo.maths;

public class PrimeNumber {

  public static void main(String[] args) {
    System.out.println(PrimeNumber.isPrime(11));
    System.out.println(PrimeNumber.isPrime(17));
    System.out.println(PrimeNumber.isPrime(12));
  }

  public static boolean isPrime(int val) {
    for (int div = 2; div * div <= val; div++) {
      if (val % div == 0) {
        return false;
      }
    }
    return true;
  }

  public static boolean isPrimeWithSchoolMethod(int val) {
    if (val <= 1) return false;
    if (val <= 3) return true;

    // This is checked so that we can skip
    // middle five numbers in below loop
    if (val % 2 == 0 || val % 3 == 0) return false;
    for (int div = 5; div * div <= val; div = div + 6) {
      if (val % div == 0 || val % (div + 2) == 0) {
        return false;
      }
    }
    return true;
  }
}
