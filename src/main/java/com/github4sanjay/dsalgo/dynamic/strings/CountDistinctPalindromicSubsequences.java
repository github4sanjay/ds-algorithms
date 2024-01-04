package com.github4sanjay.dsalgo.dynamic.strings;

import java.util.HashMap;

/*
 * Given a string S, find the number of different non-empty palindromic subsequences in S, and return that number modulo 10^9 + 7.
 * A subsequence of a string S is obtained by deleting 0 or more characters from S.
 * A sequence is palindromic if it is equal to the sequence reversed.
 * Two sequences A_1, A_2, ... and B_1, B_2, ... are different if there is some i for which A_i != B_i.
 *
 * **EXAMPLE - 1:**
 * Input:
 * S = 'bccb'
 * Output: 6
 * Explanation:
 * The 6 different non-empty palindromic subsequences are 'b', 'c', 'bb', 'cc', 'bcb', 'bccb'.
 * Note that 'bcb' is counted only once, even though it occurs twice.
 */
public class CountDistinctPalindromicSubsequences {

  public static void main(String[] args) {
    System.out.println(CountDistinctPalindromicSubsequences.count("bccb"));
  }

  /*
   *____________________________________________Explanation__________________________________________________________
   *  s(abcd) = set(bc) + a_set(bc) + set(bc)_d + a_set(bc)_d
   *             s1          s2          s3          s4
   *  s(abc) = set(bc) + a_set(bc)
   *  s(bcd) = set(bc) + set(bc)_d
   *
   *  how to find unique elements between 2 sets: s = s1 + s2 - (s1 intersection s2)
   *  how to find unique elements between 3 sets: s = s1 + s2 + s3 - (s1 intersection s2) - (s1 intersection s3)
   *                                           -  (s2 intersection s3) + (s1 intersection s2 intersection s3)
   * Assume str = c1_m_c2 then :
   * when c1 != c2:
   *               s4 = 0 (cannot be palindrome since a != d)
   *               s2 intersection s3 = 0    ( since s2 contains a and s3 contains b )
   *               s1 intersection s2 intersection s3 = 0  ( since s2 contains a and s3 contains b )
   *
   * dps(abcd) = s1 + s2 + s3 - (s1 intersection s2) - (s1 intersection s3)
   *           = s1 + s2 + s3 - (s1 intersection s2) - (s1 intersection s3) + s1 - s1
   *           = [s1 + s2 - (s1 intersection s2)] + [s1 + s3 - (s1 intersection s3)] - s1
   *           =         count(c1m)               +      count(c2m)                  - count(m)
   *  Hence proved,
   *     count(str) = count(c1m) + count(mc2) - count(m)
   *
   * when c1 == c2,
   *  s(abcba) = set(bcb) + a_set(bcb) + set(bcb)_a + a_set(bcb)_a
   *             s1          s2          s3          s4
   *
   *   1. case when no 'a' in between
   *    here s2 and s3 will have just one palindrome which will be formed from "" -> a"" or ""a = a
   *    and s4 = s1 + 1 --> number would be same as s1 as a is added at front and back plus 1 as "" --> a""a = aa
   *
   *     count = 2set(bcb)+2 = 2*count(m)+2
   *
   *   2. case when one 'a' in between
   *   s(abaca) = set(bac) + a_set(bac) + set(bac)_a + a_set(bac)_a
   *              s1          s2          s3          s4
   *   dps = s1 + s2 + s3 + s4 - s1s2 - s1s3 - s1s4 - s2s3 - s2s4 - s3s4 + s1s2s3 + s2s3s4 + s1s2s4 + s1s3s4 - s1s2s3s4
   *                                             X                                       X        X         X
   *                         since s1 has 1 'a' and s4 has min 2 'a' so no intersection possible
   *
   *
   *                    |''''''''''''''''|'''''''''''''|
   *              |'''''''''''''''|''''''''''''|       |       |''''''|''''''''|
   *  dps = s1 + s2  + s3 + s4 - s1s2 - s1s3 - s2s4 - s3s4 - s2s3 + s1s2s3 + s2s3s4
   *        a    a    aca   aaa   a      a       a     aa    a       a        aa
   *        b    aa    a    aba                 aba   aca    aa
   *        c    aba   aa   aca
   *                        aa
   *  after cancelling, dps = s1 + s3 + s4
   *  and s4 is same as s1 just one extra with "" -> aa
   *    dps = 2*s1 + 1
   *    count = 2*count(m)+1
   *
   *  3. case when more than one 'a' in between
   *  consider "abacada"
   *    dps = s1 + s4 - aa - aca
   *        = 2*s1 -aca
   *        = 2*s1-dps(m')
   *    count = 2*count(m)-count(m')
   *
   *  there are three cases as follows:
   *
   *                    (no a)            |           (just 1 a)             |   (more than 1 a)
   *                  a___m___a           |            a___m___a             |       a__a__m'__a__a
   *            ________________________________________________________________________________________
   * count --->    2*count(m)+2           |        2*count(m)+1              |    2*count(m)-count(m')
   *
   * when just one 'a' next and previous equal
   *
   *      a   b   a   c   d   a
   *      |_______|___________|
   *     next                prev
   *
   *
   *  when no 'a' next and previous equals to each other
   *
   *      a   b   a   c   d   a   e   a
   *              |___________|
   *              next       prev
   *
   *  when more than one 'a' next and previous not equal
   *
   *                    m'
   *                  |```|
   *      a   b   a   c   d   a   e   a
   *      |_______|___________|_______|
   *________________________________________________________________________________________________________________
   *
   * For str = "ababda"
   *
   *                    -----------> end
   *
   *                  a       b       a       b        d        a
   *   |           |+++++++|+++++++|+++++++|++++++++|++++++++|++++++++|
   *   | s      a  |    a  |   ab  |  aba  |  abab  | ababd  | ababda |
   *   | t         |+++++++|+++++++|+++++++|++++++++|++++++++|++++++++|
   *   | a      b  |   x   |    b  |  ba   |   bab  | babd   | babda  |
   *   | r         |+++++++|+++++++|+++++++|++++++++|++++++++|++++++++|
   *   | t      a  |   x   |   x   |   a   |   ab   |   abd  | abda   |
   *   |           |+++++++|+++++++|+++++++|++++++++|++++++++|++++++++|
   *   V        b  |   x   |   x   |   x   |   b    |   bd   |   bda  |
   *               |+++++++|+++++++|+++++++|++++++++|++++++++|++++++++|
   *            d  |   x   |   x   |   x   |    x   |   d    |   da   |
   *               |+++++++|+++++++|+++++++|++++++++|++++++++|++++++++|
   *            a  |   x   |   x   |   x   |   x    |    x   |    a   |
   *               |+++++++|+++++++|+++++++|++++++++|++++++++|++++++++|
   *
   *
   *
   *               |   a      |     b      |     a      |      b     |     d       |    a       |
   *               |++++++++++|++++++++++++|++++++++++++|++++++++++++|+++++++++++++|++++++++++++|
   *            a  |    1     |     2      |    2*1+2   |    4+4-2   |    6+5-4    |   5*2+1    |
   *               |          |            |     = 4    |    = 6     |    =7       |   = 11     |
   *               |++++++++++|++++++++++++|++++++++++++|++++++++++++|+++++++++++++|++++++++++++|
   *               |          |            |            |            |             |            |
   *            b  |   x      |      1     |      2     |    2*1+2   |    4+3-2    |   5+6-3    |
   *               |          |            |            |     = 4    |    = 5      |    = 8     |
   *               |++++++++++|++++++++++ +| ++++++++++ | ++++++++++ | +++++++++++ | +++++++++++|
   *               |          |            |            |            |   2+2-1     |    2*2+2   |
   *            a  |   x      |      x     |     1      |      2     |    = 3      |     =6     |
   *               |++++++++++|++++++++++ +| ++++++++++ | ++++++++++ | +++++++++++ | +++++++++++|
   *               |          |            |            |            |             |            |
   *            b  |   x      |      x     |     x      |      1     |        2    |    2+2-1   |
   *               |          |            |            |            |             |     = 3    |
   *               |++++++++++|++++++++++ +| ++++++++++ | ++++++++++ | +++++++++++ | +++++++++++|
   *               |          |            |            |            |             |            |
   *            d  |   x      |      x     |    x       |       x    |         1   |      2     |
   *               |          |            |            |            |             |            |
   *               |++++++++++|++++++++++ +| ++++++++++ | ++++++++++ | +++++++++++ | +++++++++++|
   *               |          |            |            |            |             |            |
   *            a  |   x      |      x     |    x       |       x    |          x  |       1    |
   *               |          |            |            |            |             |            |
   *               |++++++++++|++++++++++ +| ++++++++++ | ++++++++++ | +++++++++++ | +++++++++++|
   *
   * for two length like ab = a, b so 2 palindrome
   * for two length like aa = a, aa so 2 palindrome
   *
   * @param str input string
   * @return count of distinct palindromic subsequences
   */
  private static int count(String str) {

    int[] prev = new int[str.length()];
    var prevMap = new HashMap<Character, Integer>();
    for (int i = 0; i < str.length(); i++) {
      char ch = str.charAt(i);
      if (prevMap.containsKey(ch)) {
        prev[i] = prevMap.get(ch);
      } else {
        prev[i] = -1;
      }
      prevMap.put(ch, i);
    }

    int[] next = new int[str.length()];
    var nextMap = new HashMap<Character, Integer>();
    for (int i = str.length() - 1; i >= 0; i--) {
      char ch = str.charAt(i);
      if (nextMap.containsKey(ch)) {
        next[i] = nextMap.get(ch);
      } else {
        next[i] = -1;
      }
      nextMap.put(ch, i);
    }

    int[][] dp = new int[str.length()][str.length()];
    for (int gap = 0; gap < str.length(); gap++) {
      for (int i = 0, j = gap; j < str.length(); i++, j++) {
        if (gap == 0) {
          dp[i][j] = 1;
        } else if (gap == 1) {
          dp[i][j] = 2; // check comments
        } else {
          if (str.charAt(i) == str.charAt(j)) {
            int nextIndex = next[i]; // next index of start
            int prevIndex = prev[j]; // previous index of end
            if (nextIndex == prevIndex) {
              dp[i][j] = 2 * dp[i + 1][j - 1] + 1;
            } else if (nextIndex > prevIndex) {
              dp[i][j] = 2 * dp[i + 1][j - 1] + 2;
            } else {
              dp[i][j] = 2 * dp[i + 1][j - 1] - dp[nextIndex + 1][prevIndex - 1];
            }
          } else {
            dp[i][j] = dp[i][j - 1] + dp[i + 1][j] - dp[i + 1][j - 1];
          }
        }
      }
    }
    return dp[0][str.length() - 1];
  }
}
