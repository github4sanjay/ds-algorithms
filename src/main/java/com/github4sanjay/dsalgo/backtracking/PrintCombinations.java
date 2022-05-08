package com.github4sanjay.dsalgo.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 1. You are give a number of boxes (nboxes) and number of identical items (ritems). 2. You are
 * required to place the items in those boxes and print all such configurations possible.
 *
 * <p>Items are identical and all of them are named 'i'. Note 1 -> Number of boxes is greater than
 * number of items, hence some of the boxes may remain empty.
 *
 * <p>ncr - > n!/(n-r)!*r! 2^4 -> 4c0+4c1+4c2+4c3+4c4
 */
public class PrintCombinations {

  public static void main(String[] args) {
    System.out.println(get(3, 2)); // [0011, 0101, 0110, 1001, 1010, 1100]
  }

  public static List<String> get(int boxes, int items) {
    var list = new ArrayList<String>();
    get(boxes, items, 0, 0, "", list);
    return list;
  }

  // without array
  public static void get(
      int totalBox,
      int totalItems,
      int noOfSelected,
      int currentBox,
      String ans,
      List<String> strings) {
    if (currentBox > totalBox) {
      if (noOfSelected == totalItems) {
        strings.add(ans);
      }
      return;
    }

    get(totalBox, totalItems, noOfSelected, currentBox + 1, ans + "0", strings);
    get(totalBox, totalItems, noOfSelected + 1, currentBox + 1, ans + "1", strings);
  }

  // like permutation trick
  private static void print(int[] boxes, int totalItems, int currentItem, int lastBox) {
    if (currentItem > totalItems) {
      for (int i = 0; i < boxes.length; i++) {
        System.out.print(boxes[i]);
      }
      System.out.println("");
      return;
    }

    // next box after last
    for (int i = lastBox + 1; i < boxes.length; i++) {
      if (boxes[i] == 0) {
        boxes[i] = 1;
        print(boxes, totalItems, currentItem + 1, i);
        boxes[i] = 0;
      }
    }
  }
}
