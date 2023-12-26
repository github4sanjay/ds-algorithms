package com.github4sanjay.dsalgo.recurssion;

import java.util.ArrayList;
import java.util.List;

public class MazePaths {

  public static List<String> get(int sourceRow, int srcCol, int desRow, int desCol) {
    if (sourceRow == desRow && srcCol == desCol) {
      var initialList = new ArrayList<String>();
      initialList.add("");
      return initialList;
    } else if (sourceRow > desRow) {
      return new ArrayList<>();
    } else if (srcCol > desCol) {
      return new ArrayList<>();
    }

    List<String> rowList = get(sourceRow + 1, srcCol, desRow, desCol);
    List<String> colList = get(sourceRow, srcCol + 1, desRow, desCol);
    var finalList = new ArrayList<String>();
    for (String path : rowList) {
      finalList.add("v" + path);
    }

    for (String path : colList) {
      finalList.add("h" + path);
    }
    return finalList;
  }

  public static void print(int sourceRow, int srcCol, int desRow, int desCol) {
    print(sourceRow, srcCol, desRow, desCol, "");
  }

  private static void print(int sourceRow, int srcCol, int desRow, int desCol, String answer) {
    if (sourceRow == desRow && srcCol == desCol) {
      System.out.println(answer);
      return;
    } else if (sourceRow > desRow) {
      return;
    } else if (srcCol > desCol) {
      return;
    }

    print(sourceRow + 1, srcCol, desRow, desCol, "h" + answer);
    print(sourceRow, srcCol + 1, desRow, desCol, "v" + answer);
  }
}
