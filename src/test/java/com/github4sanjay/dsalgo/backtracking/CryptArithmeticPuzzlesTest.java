package com.github4sanjay.dsalgo.backtracking;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CryptArithmeticPuzzlesTest {

  @Test
  public void test() {
    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));
    CryptarithmeticPuzzles.find("send", "more", "money");
    var expectedOutput =
        """
                d-7 e-8 m-0 n-1 o-3 r-6 s-2 y-5\s
                d-9 e-8 m-0 n-1 o-3 r-6 s-2 y-7\s
                d-2 e-7 m-0 n-1 o-4 r-6 s-3 y-9\s
                d-9 e-7 m-0 n-1 o-4 r-5 s-3 y-6\s
                d-1 e-8 m-0 n-2 o-4 r-6 s-3 y-9\s
                d-9 e-8 m-0 n-2 o-4 r-5 s-3 y-7\s
                d-1 e-7 m-0 n-3 o-6 r-4 s-5 y-8\s
                d-2 e-7 m-0 n-3 o-6 r-4 s-5 y-9\s
                d-9 e-8 m-0 n-4 o-6 r-3 s-5 y-7\s
                d-5 e-4 m-0 n-1 o-7 r-3 s-6 y-9\s
                d-9 e-4 m-0 n-1 o-7 r-2 s-6 y-3\s
                d-4 e-5 m-0 n-2 o-7 r-3 s-6 y-9\s
                d-1 e-8 m-0 n-5 o-7 r-3 s-6 y-9\s
                d-3 e-8 m-0 n-5 o-7 r-2 s-6 y-1\s
                d-6 e-3 m-0 n-1 o-8 r-2 s-7 y-9\s
                d-9 e-4 m-0 n-2 o-8 r-1 s-7 y-3\s
                d-1 e-5 m-0 n-3 o-8 r-2 s-7 y-6\s
                d-4 e-5 m-0 n-3 o-8 r-2 s-7 y-9\s
                d-9 e-5 m-0 n-3 o-8 r-1 s-7 y-4\s
                d-3 e-6 m-0 n-4 o-8 r-2 s-7 y-9\s
                d-9 e-6 m-0 n-4 o-8 r-1 s-7 y-5\s
                d-4 e-3 m-0 n-2 o-9 r-1 s-8 y-7\s
                d-2 e-4 m-0 n-3 o-9 r-1 s-8 y-6\s
                d-2 e-5 m-0 n-4 o-9 r-1 s-8 y-7\s
                d-7 e-5 m-1 n-6 o-0 r-8 s-9 y-2\s
                """;
    Assertions.assertEquals(expectedOutput, outContent.toString());
  }
}
