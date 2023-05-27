package com.github4sanjay.dsalgo.string;

import java.util.HashSet;
import java.util.List;

/**
 * Maximum Length of a Concatenated String with Unique Characters You are given an array of strings
 * arr. A string s is formed by the concatenation of a subsequence of arr that has unique
 * characters.
 *
 * <p>Return the maximum possible length of s. A subsequence is an array that can be derived from
 * another array by deleting some or no elements without changing the order of the remaining
 * elements.
 */
public class MaximumLengthOfAConcatenatedString {

  public static void main(String[] args) {
    System.out.println(maxLength(List.of("un", "iq", "ue")));
  }

  static int ans = 0;

  public static int maxLength(List<String> arr) {
    // storing unique characters in it
    HashSet<Character> hs = new HashSet<>();
    helper(arr, 0, 0, hs);
    return ans;
  }

  // count variable store the length of unique concatenated string
  public static int helper(List<String> arr, int idx, int count, HashSet<Character> hs) {
    if (idx == arr.size()) {
      return count;
    }
    for (int i = idx; i < arr.size(); i++) {
      boolean flag = true;
      HashSet<Character> temp = new HashSet<>();
      for (int j = 0; j < arr.get(i).length(); j++) {
        // if the ith string has any character which occurred before in previous string then made
        // flag false and break the loop
        if (hs.contains(arr.get(i).charAt(j))) {
          flag = false;
          break;
        }
        // here we are adding all characters in different hashset to check that any character in ith
        // string occurred 2 or more times or not.
        temp.add(arr.get(i).charAt(j));
      }
      // if ith string does not contain any character which occurred before and in ith string also
      // does not have any character which occurred 2 or more times.
      if (flag && temp.size() == arr.get(i).length()) {
        for (int j = 0; j < arr.get(i).length(); j++) {
          hs.add(arr.get(i).charAt(j));
        }
        // if ith string  does not contain any same character then add the length of ith string in
        // count and move to the next string
        ans = Math.max(ans, helper(arr, i + 1, count + arr.get(i).length(), hs));
        for (int j = 0; j < arr.get(i).length(); j++) {
          // in back tracking remove those characters which we have added before
          hs.remove(arr.get(i).charAt(j));
        }
      } else {
        // if ith string containing any same character then we move on to the next index without
        // including the ith string.
        ans = Math.max(ans, helper(arr, i + 1, count, hs));
      }
    }
    return ans; // return maximum concatenated unique character string
  }
}
