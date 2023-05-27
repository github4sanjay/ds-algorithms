package com.github4sanjay.dsalgo;

public class NextMeetup {

  public static void main(String[] args) {
    if (willMeet(4, 8, 6, 6)) {
      System.out.println("Yes");
    } else {
      System.out.println("No");
    }

    if (willMeet(10, 10, 25, 8)) {
      System.out.println("Yes");
    } else {
      System.out.println("No");
    }
  }

  private static boolean willMeet(int x1, int v1, int x2, int v2) {
    if (x1 < x2 && v1 <= v2) {
      return false;
    }
    if (x1 > x2 && v1 >= v2) {
      return false;
    }

    if (x1 < x2) {
      swap(x1, x2);
      swap(v1, v2);
    }

    return ((x1 - x2) % (v1 - v2) == 0);
  }

  private static void swap(int a, int b) {
    int t = a;
    a = b;
    b = t;
  }
}
