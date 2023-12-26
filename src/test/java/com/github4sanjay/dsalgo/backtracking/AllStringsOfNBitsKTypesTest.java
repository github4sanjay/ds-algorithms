package com.github4sanjay.dsalgo.backtracking;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class AllStringsOfNBitsKTypesTest {

  @Test
  public void testPrint() {
    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));
    AllStringsOfNBitsKTypes.print(4, 3);
    var expectedOutput =
        """
              0000
              1000
              2000
              0100
              1100
              2100
              0200
              1200
              2200
              0010
              1010
              2010
              0110
              1110
              2110
              0210
              1210
              2210
              0020
              1020
              2020
              0120
              1120
              2120
              0220
              1220
              2220
              0001
              1001
              2001
              0101
              1101
              2101
              0201
              1201
              2201
              0011
              1011
              2011
              0111
              1111
              2111
              0211
              1211
              2211
              0021
              1021
              2021
              0121
              1121
              2121
              0221
              1221
              2221
              0002
              1002
              2002
              0102
              1102
              2102
              0202
              1202
              2202
              0012
              1012
              2012
              0112
              1112
              2112
              0212
              1212
              2212
              0022
              1022
              2022
              0122
              1122
              2122
              0222
              1222
              2222
                """;
    Assertions.assertEquals(expectedOutput, outContent.toString());
  }
}
