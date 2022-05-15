package com.github4sanjay.dsalgo.string;

import com.github4sanjay.dsalgo.recurssion.Factorial;
import java.util.ArrayList;
import java.util.List;

public class FindAllPermutationsOfString {

  public static void main(String[] args) {
    System.out.println(FindAllPermutationsOfString.find("abc"));
  }

  /*
   *  For abc total permutation = 3! = 6
   *  So from 0 to 5
   *    3  |     0                           3  |     1                              3  |     2
   *  _____|______________                 _____|______________                    _____|______________
   *    2  |   0 - 0                         2  |   0 - 1                            2  |   0 - 2
   *  _____|______________                 _____|______________                    _____|______________
   *    1  |   0 - 0                         1  |   0 - 0                            1  |   0 - 0
   *  _____|______________                 _____|______________                    _____|______________
   *       |   0 - 0                            |   0 - 0                               |   0 - 0
   *  _____|______________                 _____|______________                    _____|______________
   *       |   abc                              |   bac                                 |   cab
   *
   *
   *      3  |     3                          3  |     4                               3  |     5
   *    _____|______________                _____|______________                     _____|______________
   *      2  |   1 - 0                        2  |   1 - 1                             2  |   1 - 2
   *    _____|______________                _____|______________                     _____|______________
   *      1  |   0 - 1                        1  |   0 - 1                             1  |   0 - 1
   *    _____|______________                _____|______________                     _____|______________
   *         |   0 - 0                           |   0 - 0                                |   0 - 0
   *    _____|______________                _____|______________                     _____|______________
   *         |   acb                             |   bca                                  |    cba
   *
   *
   */
  public static List<String> find(String str) {
    var list = new ArrayList<String>();
    var numberOfPermutations = Factorial.factorial(str.length());
    for (int i = 0; i < numberOfPermutations; i++) {
      var listOfChar = new ArrayList<Character>();
      for (char ch : str.toCharArray()) {
        listOfChar.add(ch);
      }
      var string = new StringBuilder();
      var dividend = i;
      for (int j = str.length(); j > 0; j--) {
        var quotient = dividend / j;
        var remainder = i % j;
        string.append(listOfChar.remove(remainder));
        dividend = quotient;
      }
      list.add(string.toString());
    }
    return list;
  }
}
