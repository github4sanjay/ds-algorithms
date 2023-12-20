package com.github4sanjay.dsalgo.tree.generic;

import static org.junit.jupiter.api.Assertions.*;

import com.github4sanjay.dsalgo.tree.generic.structure.GenericTreeUtil;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class LinearizeAGenericTreeTest {

  @Test
  public void testLinearizeAGenericTreeRecursion() {
    var root =
        GenericTreeUtil.createTree(
            new int[] {
              10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120, -1, -1, 90, -1, -1, 40, 100,
              -1, -1, -1
            });

    LinearizeAGenericTree.recursion(root);

    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));
    GenericTreeUtil.display(root);

    var expectedOutput =
        """
                        10--->[20]
                        20--->[50]
                        50--->[60]
                        60--->[30]
                        30--->[70]
                        70--->[80]
                        80--->[110]
                        110--->[120]
                        120--->[90]
                        90--->[40]
                        40--->[100]
                        100--->[]
                        """;

    Assertions.assertEquals(expectedOutput, outContent.toString());
  }

  @Test
  public void testLinearizeAGenericTree() {
    var root =
        GenericTreeUtil.createTree(
            new int[] {
              10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120, -1, -1, 90, -1, -1, 40, 100,
              -1, -1, -1
            });

    LinearizeAGenericTree.lenearize(root);

    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));
    GenericTreeUtil.display(root);

    var expectedOutput =
        """
                        10--->[20]
                        20--->[50]
                        50--->[60]
                        60--->[30]
                        30--->[70]
                        70--->[80]
                        80--->[110]
                        110--->[120]
                        120--->[90]
                        90--->[40]
                        40--->[100]
                        100--->[]
                        """;

    Assertions.assertEquals(expectedOutput, outContent.toString());
  }
}
