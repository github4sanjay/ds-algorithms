package com.github4sanjay.dsalgo.recurssion;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TargetSumSubsetsTest {

  @Test
  public void testPrint() {
    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));
    TargetSumSubsets.print(new int[] {10, 20, 30, 40, 50}, 70);
    var expectedOutput =
        """
                30,40,
                20,50,
                10,20,40,
                """;
    Assertions.assertEquals(expectedOutput, outContent.toString());
  }

  @Test
  public void testFind() {
    var result = TargetSumSubsets.find(new int[] {10, 20, 30, 40, 50}, 70);
    var expectedOutput = "[[30, 40], [20, 50], [10, 20, 40]]";
    Assertions.assertEquals(expectedOutput, result.toString());
  }
}
