package com.github4sanjay.dsalgo.backtracking;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class AllStringsOfNBitsTest {

  @Test
  public void testPrint() {
    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));
    AllStringsOfNBits.print(4, "abc");
    var expectedOutput =
        """
                aaaa
                baaa
                caaa
                abaa
                bbaa
                cbaa
                acaa
                bcaa
                ccaa
                aaba
                baba
                caba
                abba
                bbba
                cbba
                acba
                bcba
                ccba
                aaca
                baca
                caca
                abca
                bbca
                cbca
                acca
                bcca
                ccca
                aaab
                baab
                caab
                abab
                bbab
                cbab
                acab
                bcab
                ccab
                aabb
                babb
                cabb
                abbb
                bbbb
                cbbb
                acbb
                bcbb
                ccbb
                aacb
                bacb
                cacb
                abcb
                bbcb
                cbcb
                accb
                bccb
                cccb
                aaac
                baac
                caac
                abac
                bbac
                cbac
                acac
                bcac
                ccac
                aabc
                babc
                cabc
                abbc
                bbbc
                cbbc
                acbc
                bcbc
                ccbc
                aacc
                bacc
                cacc
                abcc
                bbcc
                cbcc
                accc
                bccc
                cccc
                """;
    Assertions.assertEquals(expectedOutput, outContent.toString());
  }
}
