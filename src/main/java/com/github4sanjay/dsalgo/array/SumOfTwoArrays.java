package com.github4sanjay.dsalgo.array;

import com.github4sanjay.dsalgo.maths.GetNumberFromList;
import java.util.ArrayList;

/**
 * Given two array A[0….n-1] and B[0….m-1] of size n and m respectively, representing two numbers
 * such that every element of arrays represent a digit.
 *
 * <p>For example, A[] = { 1, 2, 3} and B[] = { 2, 1, 4 } represent 123 and 214 respectively. The
 * task is to find the sum of both the number. In above case, answer is 337.
 *
 * <p>Examples :
 *
 * <p>Input : n = 3, m = 3 a[] = { 1, 2, 3 } b[] = { 2, 1, 4 } Output : 337 123 + 214 = 337
 *
 * <p>Input : n = 4, m = 3 a[] = { 9, 5, 4, 9 } b[] = { 2, 1, 4 } Output : 9763
 */
public class SumOfTwoArrays {

  public static void main(String[] args) {
    System.out.println(SumOfTwoArrays.findAlt(new int[] {9, 5, 4, 9}, new int[] {2, 1, 4})); // 9763
    System.out.println(
        SumOfTwoArrays.findAlt(new int[] {3, 1, 0, 7, 5}, new int[] {1, 1, 1, 1, 1, 1})); // 142186

    System.out.println(SumOfTwoArrays.find(new int[] {9, 5, 4, 9}, new int[] {2, 1, 4})); // 9763
    System.out.println(
        SumOfTwoArrays.find(new int[] {3, 1, 0, 7, 5}, new int[] {1, 1, 1, 1, 1, 1})); // 142186
  }

  private static int find(int[] array1, int[] array2) {
    var list = new ArrayList<Integer>();
    int size = Math.max(array1.length, array2.length);
    int k = 0;
    int carry = 0;
    while (k < size) {
      int digit1 = 0;
      if (array1.length - 1 - k >= 0) {
        digit1 = array1[array1.length - 1 - k];
      }

      int digit2 = 0;
      if (array2.length - 1 - k >= 0) {
        digit2 = array2[array2.length - 1 - k];
      }

      int digitSum = digit1 + digit2 + carry;
      if (digitSum >= 10) {
        carry = digitSum / 10;
        digitSum = digitSum % 10;
      } else {
        carry = 0;
      }

      list.add(digitSum);
      k++;
    }
    list.add(carry);
    return GetNumberFromList.getNumberFromList(list);
  }

  private static int findAlt(int[] array1, int[] array2) {
    int size = Math.max(array1.length, array2.length);
    int k = size - 1;
    int i = array1.length - 1;
    int j = array2.length - 1;
    int carry = 0;
    int sum = 0;
    int p = 1;
    while (k >= 0) {
      int digit1 = 0;
      if (i >= 0) {
        digit1 = array1[i];
      }

      int digit2 = 0;
      if (j >= 0) {
        digit2 = array2[j];
      }

      int digitSum = digit1 + digit2 + carry;
      if (digitSum >= 10) {
        carry = digitSum / 10;
        digitSum = digitSum % 10;
      } else {
        carry = 0;
      }

      sum = sum + digitSum * p;
      p = p * 10;
      k--;
      i--;
      j--;
    }
    return sum;
  }
}
