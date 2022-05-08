package com.github4sanjay.dsalgo.mixed;

import java.util.ArrayList;
import java.util.List;

class BalancedArray {

  /*
   * Complete the 'balancedSum' function below.
   *
   * The function is expected to return an INTEGER.
   * The function accepts INTEGER_ARRAY arr as parameter.
   */

  public static int balancedSum(List<Integer> arr) {
    // Write your code here
    var sumList = new ArrayList<Integer>();
    int sum = 0;
    for (Integer element : arr) {
      sumList.add(sum);
      sum = sum + element;
    }
    // System.out.println(sumList);
    int min = Integer.MAX_VALUE;
    for (int i = 1; i < sumList.size(); i++) {
      var leftSum = sumList.get(i);
      var rightSum = sum - leftSum - arr.get(i);
      if (leftSum == rightSum) {
        min = Math.min(min, i);
      }
    }
    return min;
  }

  public static void main(String[] args) {
    System.out.println(balancedSum(List.of(1, 2, 3, 4, 6)));
  }
}
