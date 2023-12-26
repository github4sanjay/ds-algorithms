package com.github4sanjay.dsalgo.recurssion;

import static org.junit.jupiter.api.Assertions.*;

import com.github4sanjay.dsalgo.util.AlgoUtil;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class FloodFillTest {

  @Test
  public void testFill1() {
    var matrix =
        new int[][] {
          {1, 1, 1, 1, 1, 1, 1, 2},
          {1, 1, 1, 1, 1, 1, 0, 0},
          {1, 0, 0, 1, 1, 0, 1, 1},
          {1, 2, 2, 2, 2, 0, 1, 0},
          {1, 1, 1, 2, 2, 0, 1, 0},
          {1, 1, 1, 2, 2, 2, 2, 0},
          {1, 1, 1, 1, 1, 2, 1, 1},
          {1, 1, 2, 1, 1, 2, 2, 1},
        };

    FloodFill.fill(matrix, 4, 4, 3);

    var outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));
    AlgoUtil.print(matrix);
    var expectedOutput =
        """
                [1, 1, 1, 1, 1, 1, 1, 2]
                [1, 1, 1, 1, 1, 1, 0, 0]
                [1, 0, 0, 1, 1, 0, 1, 1]
                [1, 3, 3, 3, 3, 0, 1, 0]
                [1, 1, 1, 3, 3, 0, 1, 0]
                [1, 1, 1, 3, 3, 3, 3, 0]
                [1, 1, 1, 1, 1, 3, 1, 1]
                [1, 1, 2, 1, 1, 3, 3, 1]
                """;
    Assertions.assertEquals(expectedOutput, outContent.toString());
  }

  @Test
  public void testFill() {
    var matrix =
        new int[][] {
          {1, 1, 1},
          {1, 1, 0},
          {1, 0, 1}
        };

    FloodFill.fill(matrix, 1, 1, 2);

    var outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));
    AlgoUtil.print(matrix);
    var expectedOutput =
        """
                        [2, 2, 2]
                        [2, 2, 0]
                        [2, 0, 1]
                        """;
    Assertions.assertEquals(expectedOutput, outContent.toString());
  }
}
