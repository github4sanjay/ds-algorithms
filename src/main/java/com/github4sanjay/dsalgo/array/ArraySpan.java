package com.github4sanjay.dsalgo.array;

public class ArraySpan {

  public static void main(String[] args) {
    System.out.println(ArraySpan.find(new int[] {15, 30, 40, 4, 11, 9}));
  }

  public static Pair find(int[] array) {
    var pair = new Pair();
    for (int item : array) {
      pair.max = Math.max(pair.max, item);
      pair.min = Math.min(pair.min, item);
    }
    return pair;
  }

  public static class Pair {
    int min;
    int max;

    public Pair() {
      this.min = Integer.MAX_VALUE;
      this.max = Integer.MIN_VALUE;
    }

    @Override
    public String toString() {
      return "Pair{" + "min=" + min + ", max=" + max + '}';
    }
  }
}
