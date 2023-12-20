package com.github4sanjay.dsalgo.tree.generic.structure;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class GenericTreeTest {

  @Test
  public void testGenericTreeCreation() {
    var arr =
        new int[] {
          10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 100, -1, -1, 90, -1, -1, 40, 100, -1,
          -1, -1
        };
    var tree = new GenericTree(arr);

    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));
    GenericTreeUtil.display(tree.getRoot());

    var expectedOutput =
        """
                10--->[20, 30, 40]
                20--->[50, 60]
                50--->[]
                60--->[]
                30--->[70, 80, 90]
                70--->[]
                80--->[110, 100]
                110--->[]
                100--->[]
                90--->[]
                40--->[100]
                100--->[]
                """;

    Assertions.assertEquals(expectedOutput, outContent.toString());
  }

  @Test
  public void testIterator() {
    var root =
        GenericTreeUtil.createTree(new int[] {10, 20, -1, 30, 50, -1, 60, -1, -1, 40, -1, -1});
    var genericTree = new GenericTree(root);
    var list = new ArrayList<Integer>();
    for (Integer integer : genericTree) {
      list.add(integer);
    }

    Assertions.assertEquals(List.of(10, 20, 30, 50, 60, 40), list);
  }
}
