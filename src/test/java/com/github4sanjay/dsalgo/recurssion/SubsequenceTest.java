package com.github4sanjay.dsalgo.recurssion;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SubsequenceTest {

  @Test
  public void test() {
    Assertions.assertEquals(
        "[a, ab, abc, ac, b, bc, c]", Subsequence.get("abc").stream().sorted().toList().toString());
  }

  @Test
  public void testPrint() {
    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));
    Subsequence.print("abc");

    var expectedOutput =
        """

                c
                b
                bc
                a
                ac
                ab
                abc
                """;

    Assertions.assertEquals(expectedOutput, outContent.toString());
  }
}
