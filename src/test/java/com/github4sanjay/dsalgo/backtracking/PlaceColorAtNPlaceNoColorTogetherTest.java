package com.github4sanjay.dsalgo.backtracking;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class PlaceColorAtNPlaceNoColorTogetherTest {

  @Test
  public void testPrint() {

    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));

    PlaceColorAtNPlaceNoColorTogether.print(5, "rbg");
    var expectedOutput =
        """
                rbrbr
                gbrbr
                rgrbr
                bgrbr
                brgbr
                grgbr
                rbgbr
                gbgbr
                rbrgr
                gbrgr
                rgrgr
                bgrgr
                brbgr
                grbgr
                rgbgr
                bgbgr
                brbrb
                grbrb
                rgbrb
                bgbrb
                brgrb
                grgrb
                rbgrb
                gbgrb
                rbrgb
                gbrgb
                rgrgb
                bgrgb
                brbgb
                grbgb
                rgbgb
                bgbgb
                brbrg
                grbrg
                rgbrg
                bgbrg
                brgrg
                grgrg
                rbgrg
                gbgrg
                rbrbg
                gbrbg
                rgrbg
                bgrbg
                brgbg
                grgbg
                rbgbg
                gbgbg
                """;
    Assertions.assertEquals(expectedOutput, outContent.toString());
  }
}
