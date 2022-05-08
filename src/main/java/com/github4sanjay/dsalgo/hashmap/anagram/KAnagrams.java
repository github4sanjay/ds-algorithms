package com.github4sanjay.dsalgo.hashmap.anagram;

import com.github4sanjay.dsalgo.util.MapUtil;

/**
 * Given two strings of lowercase alphabets and a value k, the task is to find if two strings are
 * K-anagrams of each other or not. Two strings are called k-anagrams if following two conditions
 * are true.
 *
 * <p>Both have same number of characters. Two strings can become anagram by changing at most k
 * characters in a string. Examples :
 *
 * <p>Input: str1 = "anagram" , str2 = "grammar" , k = 3 Output: Yes Explanation: We can update
 * maximum 3 values and it can be done in changing only 'r' to 'n' and 'm' to 'a' in str2.
 *
 * <p>Input: str1 = "geeks", str2 = "eggkf", k = 1 Output: No Explanation: We can update or modify
 * only 1 value but there is a need of modifying 2 characters. i.e. g and f in str 2.
 */
public class KAnagrams {

  public static void main(String[] args) {
    System.out.println(KAnagrams.check("anagram", "grammar", 3));
    System.out.println(KAnagrams.check("geeks", "eggkf", 1));
  }

  /**
   * consider a n a g r a m and g r a m m a r a3 n1 g1 r1 m1 a2 n0 g1 r2 m2 '''''''''''''''''' +1 +1
   * 0 -1 -1 '''''''''''''''''' We can take either positive or negative sum as if u change one it
   * effects to char automatically so +1 + +1 = 2 which is less than 3 so true
   *
   * <p>consider g e e k s and e g g k f g1 e2 k1 s1 f0 g2 e1 k1 s0 f1 '''''''''''''''''' -1 +1 0 +1
   * -1 '''''''''''''''''' so +1 + +1 = 2 which is not less than 1 so false
   */
  public static boolean check(String str1, String str2, int k) {
    var stringToFrequencyMap1 = MapUtil.stringToFrequencyMap(str1);
    var stringToFrequencyMap2 = MapUtil.stringToFrequencyMap(str2);
    int diffSum = 0;
    for (var entry : stringToFrequencyMap1.entrySet()) {
      int diff = entry.getValue() - stringToFrequencyMap2.getOrDefault(entry.getKey(), 0);
      if (diff > 0) {
        diffSum = diffSum + diff;
      }
    }
    return diffSum <= k;
  }
}
