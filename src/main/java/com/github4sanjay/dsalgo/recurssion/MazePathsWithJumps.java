package com.github4sanjay.dsalgo.recurssion;

import java.util.ArrayList;
import java.util.List;

public class MazePathsWithJumps {

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

    var finalList = new ArrayList<String>();
    for (int i = 1; i <= desRow - sourceRow; i++) {
      List<String> rowList = get(sourceRow + i, srcCol, desRow, desCol);
      for (String path : rowList) {
        finalList.add("v" + i + path);
      }
    }

    for (int i = 1; i <= desCol - srcCol; i++) {
      List<String> colList = get(sourceRow, srcCol + i, desRow, desCol);
      for (String path : colList) {
        finalList.add("h" + i + path);
      }
    }

    for (int i = 1; i <= desRow - sourceRow && i <= desCol - srcCol; i++) {
      List<String> diaList = get(sourceRow + i, srcCol + i, desRow, desCol);
      for (String path : diaList) {
        finalList.add("d" + i + path);
      }
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

    for (int i = 1; i <= desCol - srcCol; i++) {
      print(sourceRow, srcCol + i, desRow, desCol, "h" + i + answer);
    }

    for (int i = 1; i <= desRow - sourceRow; i++) {
      print(sourceRow + i, srcCol, desRow, desCol, "v" + i + answer);
    }

    for (int i = 1; i < Math.min(desRow, desCol); i++) {
      print(sourceRow + i, srcCol + i, desRow, desCol, "d" + i + answer);
    }
  }
}
