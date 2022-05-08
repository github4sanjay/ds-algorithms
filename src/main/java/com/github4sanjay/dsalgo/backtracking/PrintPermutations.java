package com.github4sanjay.dsalgo.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 1. You are give a number of boxes (nboxes) and number of non-identical items (ritems). 2. You are
 * required to place the items in those boxes and print all such configurations possible.
 *
 * <p>Items are numbered from 1 to ritems. Note 1 -> Number of boxes is greater than number of
 * items, hence some of the boxes may remain empty.
 *
 * <p>npr - > n!/(n-r)!
 */
public class PrintPermutations {

  public static void main(String[] args) {

    // [120, 102, 210, 012, 201, 021, 120, 102, 210, 012, 201, 021, 120, 102, 210, 012, 201, 021]
    System.out.println(PrintPermutations.get(3, 2));

    // [1200, 1020, 1002, 2100, 0120, 0102, 2010, 0210, 0012, 2001, 0201, 0021, 1200, 1020, 1002,
    // 2100, 0120, 0102,
    // 2010, 0210, 0012, 2001, 0201, 0021, 1200, 1020, 1002, 2100, 0120, 0102, 2010, 0210, 0012,
    // 2001, 0201, 0021,
    // 1200, 1020, 1002, 2100, 0120, 0102, 2010, 0210, 0012, 2001, 0201, 0021]
    System.out.println(PrintPermutations.get(4, 2));
  }

  public static List<String> get(int boxes, int items) {
    var list = new ArrayList<String>();
    print(new int[boxes], items, 0, list);
    return list;
  }

  private static void print(int[] boxes, int totalItems, int currentItem, List<String> list) {
    if (currentItem > totalItems) {
      var str = new StringBuilder();
      for (int box : boxes) {
        str.append(box);
      }
      list.add(str.toString());
      return;
    }
    for (int i = 0; i < boxes.length; i++) {
      if (boxes[i] == 0) {
        boxes[i] = currentItem;
        print(boxes, totalItems, currentItem + 1, list);
        boxes[i] = 0;
      }
    }
  }

  // with combination trick (box decides whom to place choices are no one, 1 or 2)
  public static void printWithCombinationTrick(
      int totalItems, int totalBox, int noOfSelected, int currentBox, String ans, boolean[] items) {
    if (currentBox > totalBox) {
      if (noOfSelected == totalItems) {
        System.out.println(ans);
      }
      return;
    }

    for (int i = 0; i < totalItems; i++) {
      if (!items[i]) {
        items[i] = true;
        printWithCombinationTrick(
            totalItems, totalBox, noOfSelected + 1, currentBox + 1, ans + (i + 1), items);
        items[i] = false;
      }
    }
    printWithCombinationTrick(totalItems, totalBox, noOfSelected, currentBox + 1, ans + 0, items);
  }
}
