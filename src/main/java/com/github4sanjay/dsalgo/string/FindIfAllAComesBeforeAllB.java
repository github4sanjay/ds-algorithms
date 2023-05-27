package com.github4sanjay.dsalgo.string;

public class FindIfAllAComesBeforeAllB {

  public static void main(String[] args) {
    System.out.println(checkString("ababbb"));
    System.out.println(checkString("aabbb"));
  }

  public static boolean checkString(String s) {
    int count = 0;
    char[] c = s.toCharArray();
    for (char ch : c) if (ch == 'a') count++;

    for (int i = 0; i < c.length; i++) {
      if (c[i] == 'b') if (i < count) return false;
    }
    return true;
  }
}
