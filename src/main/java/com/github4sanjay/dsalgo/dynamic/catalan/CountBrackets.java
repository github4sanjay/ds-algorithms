package com.github4sanjay.dsalgo.dynamic.catalan;

/*
 * 1. You are given a number n, representing the number of opening brackets ( and closing brackets )
 * 2. You are required to find the number of ways in which you can arrange the brackets if the closing brackets should never exceed opening brackets
 * e.g.
 * for 1, answer is 1 -> ()
 * for 2, answer is 2 -> ()(), (())
 * for 3, asnwer is 5 -> ()()(), () (()), (())(), (()()), ((()))
 *
 *
 */
public class CountBrackets {

  public static void main(String[] args) {
    System.out.println(CountBrackets.find(4));
  }

  /*
   * 0 ---> 1
   * 1 ---> ()
   * 2 ---> ()(), (())
   * 3 ---> (   )                   ------->   ()()(), ()(())
   *        0 inside 2 outside
   *
   *        (   )                   ------->   (())()
   *        1 inside  1 outside
   *
   *        (   )                   ------->   (()()), ((()))
   *        2 inside  0 outside
   *
   * 4 --->  (   )    (   )    (   )    (   )
   *           C0*C3    C1*C2   C2*C1   C3*C0 = C(4)
   *
   *
   *
   */
  private static int find(int n) {
    return CatalanNumber.tabulation(n);
  }
}
