package com.github4sanjay.dsalgo.recurssion;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class StairsPathTest {

  @Test
  public void testPrint() {

    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));

    StairsPath.print(5);
    var expectedOutput =
        """
                       11111
                       2111
                       1211
                       311
                       1121
                       221
                       131
                       1112
                       212
                       122
                       32
                       113
                       23
                                """;

    Assertions.assertEquals(expectedOutput, outContent.toString());
  }

  @Test
  public void testGet() {
    var result = StairsPath.get(5);
    var expectedOutput = "[11111, 1112, 1121, 113, 1211, 122, 131, 2111, 212, 221, 23, 311, 32]";

    Assertions.assertEquals(expectedOutput, result.toString());
  }
}
