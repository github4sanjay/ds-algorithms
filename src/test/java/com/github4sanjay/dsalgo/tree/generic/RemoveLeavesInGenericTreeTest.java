package com.github4sanjay.dsalgo.tree.generic;

import static org.junit.jupiter.api.Assertions.*;

import com.github4sanjay.dsalgo.tree.generic.structure.GenericTreeUtil;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class RemoveLeavesInGenericTreeTest {

  @Test
  public void testRemoveLeavesInGenericTree() {
    var root =
        GenericTreeUtil.createTree(
            new int[] {
              10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120, -1, -1, 90, -1, -1, 40, 100,
              -1, -1, -1
            });

    RemoveLeavesInGenericTree.remove(root);
    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));
    GenericTreeUtil.display(root);

    var expectedOutput =
        """
                        10--->[20, 30, 40]
                        20--->[]
                        30--->[80]
                        80--->[]
                        40--->[]
                        """;

    Assertions.assertEquals(expectedOutput, outContent.toString());
  }

  @Test
  public void testRemoveLeavesInGenericTreeRecursion() {
    var root =
        GenericTreeUtil.createTree(
            new int[] {
              10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120, -1, -1, 90, -1, -1, 40, 100,
              -1, -1, -1
            });

    RemoveLeavesInGenericTree.removeRecursion(root);

    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));
    GenericTreeUtil.display(root);

    var expectedOutput =
        """
                                10--->[20, 30, 40]
                                20--->[]
                                30--->[80]
                                80--->[]
                                40--->[]
                                """;

    Assertions.assertEquals(expectedOutput, outContent.toString());
  }
}
