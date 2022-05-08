package com.github4sanjay.dsalgo.string;

import java.util.ArrayList;

public class Practice {

  public static int getSpecialSubstring(String str, int k, String charValue) {
    if (k == 0) return 0;
    var charValueArray = charValue.toCharArray();
    var strArray = str.toCharArray();
    int count = 0;
    int left = 0, right = 0, maxLength = 0;
    while (right < str.length()) {
      while (right < str.length() && count <= k) {
        int pos = strArray[right] - 'a';
        if (charValueArray[pos] == '0') {
          if (count + 1 > k) {
            break;
          } else {
            count++;
          }
        }
        right++;
        if (count <= k) {
          maxLength = Math.max(maxLength, right - left);
        }
      }
      while (left < right) {
        int pos = strArray[left] - 'a';
        left++;
        if (charValueArray[pos] == '0') {
          count--;
        }
        if (count < k) {
          break;
        }
      }
    }
    return maxLength;
  }

  public static int n2(String str, int k, String charValue) {
    ArrayList<String> list = new ArrayList<String>();
    for (int i = 1; i <= str.length(); i++) { // i is length of substring
      for (int j = 0; j + i <= str.length(); j++) {
        list.add(str.substring(j, j + i));
      }
    }
    int maxLength = 0;
    char[] charValueArr = charValue.toCharArray();
    System.out.println(charValueArr);
    for (String s : list) {
      int numberOfNormalChar = 0;
      for (char c : s.toCharArray()) {
        if (charValueArr[c - 97] == '0') {
          numberOfNormalChar++;
        }
      }
      if (numberOfNormalChar <= k) {
        if (maxLength < s.length()) {
          maxLength = s.length();
        }
      }
    }
    return maxLength;
  }

  public static void main(String[] args) {
    System.out.println(getSpecialSubstring("giraffe", 2, "01111001111111111011111111"));
  }
}
