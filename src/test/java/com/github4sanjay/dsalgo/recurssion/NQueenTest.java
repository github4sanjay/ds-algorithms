package com.github4sanjay.dsalgo.recurssion;

import com.github4sanjay.dsalgo.util.AlgoUtil;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class NQueenTest {

  @Test
  public void test() {
    var boards = NQueen.place(4);
    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));
    for (var board : boards) {
      AlgoUtil.print(board);
      System.out.println();
    }
    var expectedOutput =
        """
              [0, 1, 0, 0]
              [0, 0, 0, 1]
              [1, 0, 0, 0]
              [0, 0, 1, 0]

              [0, 0, 1, 0]
              [1, 0, 0, 0]
              [0, 0, 0, 1]
              [0, 1, 0, 0]

                """;
    Assertions.assertEquals(expectedOutput, outContent.toString());
  }

  @Test
  public void testPrint() {
    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));
    NQueen.print(4);
    var expectedOutput =
        """
                  0-1, 1-3, 2-0, 3-2,\s
                  0-2, 1-0, 2-3, 3-1,\s
                    """;
    Assertions.assertEquals(expectedOutput, outContent.toString());
  }
}
