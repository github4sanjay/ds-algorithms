package com.github4sanjay.dsalgo.backtracking;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class AbbreviationTest {

  @Test
  public void testPrint() {
    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));
    Abbreviation.print("ANKS");
    var expectedOutput =
        """
                ANKS
                1NKS
                A1KS
                2KS
                AN1S
                1N1S
                A2S
                3S
                ANK1
                1NK1
                A1K1
                2K1
                AN2
                1N2
                A3
                4
                """;
    Assertions.assertEquals(expectedOutput, outContent.toString());
  }

  @Test
  public void testPrintWithoutBinary() {
    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));
    Abbreviation.printWithoutBinary("ANKS");
    var expectedOutput =
        """
                       ANKS
                       ANK1
                       AN1S
                       AN2
                       A1KS
                       A1K1
                       A2S
                       A3
                       1NKS
                       1NK1
                       1N1S
                       1N2
                       2KS
                       2K1
                       3S
                       4
                        """;
    Assertions.assertEquals(expectedOutput, outContent.toString());
  }
}
