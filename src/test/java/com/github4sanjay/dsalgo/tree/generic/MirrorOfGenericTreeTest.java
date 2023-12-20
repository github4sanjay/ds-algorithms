package com.github4sanjay.dsalgo.tree.generic;

import static org.junit.jupiter.api.Assertions.*;

import com.github4sanjay.dsalgo.tree.generic.structure.GenericTreeUtil;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MirrorOfGenericTreeTest {

  @Test
  public void testMirrorOfGenericTree() {
    var root =
        GenericTreeUtil.createTree(
            new int[] {
              10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120, -1, -1, 90, -1, -1, 40, 100,
              -1, -1, -1
            });
    MirrorOfGenericTree.mirror(root);

    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));
    GenericTreeUtil.display(root);

    var expectedOutput =
        """
                10--->[40, 30, 20]
                40--->[100]
                100--->[]
                30--->[90, 80, 70]
                90--->[]
                80--->[120, 110]
                120--->[]
                110--->[]
                70--->[]
                20--->[60, 50]
                60--->[]
                50--->[]
                """;

    Assertions.assertEquals(expectedOutput, outContent.toString());
  }

  @Test
  public void testMirrorOfGenericTreeRecursion() {
    var root =
        GenericTreeUtil.createTree(
            new int[] {
              10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120, -1, -1, 90, -1, -1, 40, 100,
              -1, -1, -1
            });
    MirrorOfGenericTree.mirror(root);

    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));
    GenericTreeUtil.displayRecursion(root);

    var expectedOutput =
        """
                10--->[40, 30, 20]
                40--->[100]
                100--->[]
                30--->[90, 80, 70]
                90--->[]
                80--->[120, 110]
                120--->[]
                110--->[]
                70--->[]
                20--->[60, 50]
                60--->[]
                50--->[]
                """;

    Assertions.assertEquals(expectedOutput, outContent.toString());
  }
}
