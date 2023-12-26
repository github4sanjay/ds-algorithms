package com.github4sanjay.dsalgo.recurssion;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class FindAllPathToRightBottomTest {

  @Test
  public void test() {

    var outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));

    int[][] arr =
        new int[][] {
          {0, 0, 0, 1, 0},
          {1, 0, 0, 1, 1},
          {0, 0, 0, 1, 0},
          {1, 0, 0, 0, 0},
          {0, 0, 1, 0, 0}
        };

    FindAllPathToRightBottom.find(arr);

    var expectedOutput =
        """
            rdddrrdr
            rdddrrrd
            rddrdrdr
            rddrdrrd
            rdrdldrrdr
            rdrdldrrrd
            rdrddrdr
            rdrddrrd
            rrdlddrrdr
            rrdlddrrrd
            rrdldrdrdr
            rrdldrdrrd
            rrddldrrdr
            rrddldrrrd
            rrdddrdr
            rrdddrrd
                """;
    Assertions.assertEquals(expectedOutput, outContent.toString());
  }
}
