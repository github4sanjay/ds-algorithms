package com.github4sanjay.dsalgo.recurssion;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MazePathsWithJumpsTest {

  @Test
  public void testPrint() {
    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));

    MazePathsWithJumps.print(1, 1, 3, 3);
    var expectedOutput =
        """
                           v1v1h1h1
                           v2h1h1
                           v1h1v1h1
                           h1v1v1h1
                           d1v1h1
                           h1v2h1
                           v1d1h1
                           v1v1h2
                           v2h2
                           v1h1h1v1
                           h1v1h1v1
                           d1h1v1
                           v1h2v1
                           h1h1v1v1
                           h2v1v1
                           h1d1v1
                           h1h1v2
                           h2v2
                           v1h1d1
                           h1v1d1
                           d1d1
                           d2
                                """;

    Assertions.assertEquals(expectedOutput, outContent.toString());
  }

  @Test
  public void testGet() {

    var result = MazePathsWithJumps.get(1, 1, 3, 3);
    var expectedOutput =
        "[v1v1h1h1, v1v1h2, v1h1v1h1, v1h1h1v1, v1h1d1, v1h2v1, v1d1h1, v2h1h1, v2h2, h1v1v1h1, h1v1h1v1, h1v1d1, h1v2h1, h1h1v1v1, h1h1v2, h1d1v1, h2v1v1, h2v2, d1v1h1, d1h1v1, d1d1, d2]";

    Assertions.assertEquals(expectedOutput, result.toString());
  }
}
