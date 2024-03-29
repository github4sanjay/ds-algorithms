package com.github4sanjay.dsalgo.maths;

import java.util.HashSet;
import java.util.Set;

public class SieveOfEratosthenes {

  public static void main(String[] args) {
    System.out.println(SieveOfEratosthenes.find(30));
  }

  public static Set<Integer> find(int n) {
    // Create a boolean array "prime[0..n]" and initialize
    // all entries it as true. A value in prime[i] will
    // finally be false if i is Not a prime, else true.
    boolean[] prime = new boolean[n + 1];
    for (int i = 0; i < n; i++) {
      prime[i] = true;
    }

    for (int p = 2; p * p <= n; p++) {
      // If prime[p] is not changed, then it is a prime
      if (prime[p]) {
        // Update all multiples of p greater than equal to square of p
        for (int i = p * p; i <= n; i += p) prime[i] = false;
      }
    }

    var set = new HashSet<Integer>();
    for (int i = 2; i <= n; i++) {
      if (prime[i]) {
        set.add(i);
      }
    }
    return set;
  }
}
