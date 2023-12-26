package com.github4sanjay.dsalgo.recurssion;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class EncodingTest {

  @Test
  public void testPrintFor123() {
    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));
    Encoding.print("123");
    var expectedOutput = """
            abc
            aw
            lc
                """;
    Assertions.assertEquals(expectedOutput, outContent.toString());
  }

  @Test
  public void testPrintFor12103() {
    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));
    Encoding.print("12103");
    var expectedOutput = """
            abjc
            ljc
                """;
    Assertions.assertEquals(expectedOutput, outContent.toString());
  }

  @Test
  public void testPrintFor303() {
    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));
    Encoding.print("303");
    var expectedOutput = """
                """;
    Assertions.assertEquals(expectedOutput, outContent.toString());
  }

  @Test
  public void testPrintFor36() {
    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));
    Encoding.print("36");
    var expectedOutput = """
                cf
                """;
    Assertions.assertEquals(expectedOutput, outContent.toString());
  }
}
