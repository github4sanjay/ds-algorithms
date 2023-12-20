package com.github4sanjay.dsalgo.tree.generic.structure;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class GenericTreeUtilTest {

  @Test
  public void testDisplay() {
    var arr =
        new int[] {
          10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 100, -1, -1, 90, -1, -1, 40, 100, -1,
          -1, -1
        };
    var root = GenericTreeUtil.createTree(arr);

    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));
    GenericTreeUtil.display(root);

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
  public void testDisplayRecursion() {
    var arr =
        new int[] {
          10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 100, -1, -1, 90, -1, -1, 40, 100, -1,
          -1, -1
        };
    var root = GenericTreeUtil.createTree(arr);

    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));
    GenericTreeUtil.displayRecursion(root);

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
}
