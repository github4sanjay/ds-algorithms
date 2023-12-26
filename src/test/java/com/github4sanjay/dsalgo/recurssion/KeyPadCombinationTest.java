package com.github4sanjay.dsalgo.recurssion;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class KeyPadCombinationTest {

  private final String[] keys =
      new String[] {";;", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tu", "vwx", "yz"};

  @Test
  public void test() {

    var result = KeyPadCombination.find(keys, "678");
    var expected =
        "[ptv, ptw, ptx, puv, puw, pux, qtv, qtw, qtx, quv, quw, qux, rtv, rtw, rtx, ruv, ruw, rux, stv, stw, stx, suv, suw, sux]";
    Assertions.assertEquals(expected, result.toString());
  }

  @Test
  public void testPrint() {
    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));

    KeyPadCombination.print(keys, "678");
    var expectedOutput =
        """
                       ptv
                       ptw
                       ptx
                       puv
                       puw
                       pux
                       qtv
                       qtw
                       qtx
                       quv
                       quw
                       qux
                       rtv
                       rtw
                       rtx
                       ruv
                       ruw
                       rux
                       stv
                       stw
                       stx
                       suv
                       suw
                       sux
                        """;

    Assertions.assertEquals(expectedOutput, outContent.toString());
  }
}
