package com.github4sanjay.dsalgo.recurssion;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class PermutationsTest {

  @Test
  public void testPrint() {
    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));
    Permutations.print("abc");
    var expectedOutput =
        """
                cba
                bca
                cab
                acb
                bac
                abc
                """;
    Assertions.assertEquals(expectedOutput, outContent.toString());
  }

  @Test
  public void testGet() {
    var result = Permutations.get("abc");
    var expectedOutput = "[abc, acb, bac, bca, cab, cba]";
    Assertions.assertEquals(expectedOutput, result.toString());
  }
}
