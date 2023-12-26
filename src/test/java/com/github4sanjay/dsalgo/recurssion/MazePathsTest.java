package com.github4sanjay.dsalgo.recurssion;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MazePathsTest {

  @Test
  public void testPrint() {
    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));

    MazePaths.print(1, 1, 3, 3);
    var expectedOutput =
        """
                vvhh
                vhvh
                hvvh
                vhhv
                hvhv
                hhvv
                                """;

    Assertions.assertEquals(expectedOutput, outContent.toString());
  }

  @Test
  public void testGet() {

    var result = MazePaths.get(1, 1, 3, 3);
    Assertions.assertEquals("[vvhh, vhvh, vhhv, hvvh, hvhv, hhvv]", result.toString());
  }
}
