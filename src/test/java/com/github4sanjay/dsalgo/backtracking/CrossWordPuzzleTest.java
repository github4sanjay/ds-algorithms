package com.github4sanjay.dsalgo.backtracking;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CrossWordPuzzleTest {

  @Test
  public void test() {
    char[][] crossword = {
      {'*', '#', '*', '*', '*', '*', '*', '*', '*', '*'},
      {'*', '#', '*', '*', '*', '*', '*', '*', '*', '*'},
      {'*', '#', '*', '*', '*', '*', '#', '*', '*', '*'},
      {'*', '#', '#', '*', '*', '*', '#', '#', '*', '*'},
      {'*', '#', '*', '*', '*', '*', '#', '*', '*', '*'},
      {'*', '#', '*', '*', '*', '*', '#', '*', '*', '*'},
      {'*', '#', '*', '*', '*', '*', '#', '*', '*', '*'},
      {'*', '#', '*', '#', '#', '#', '#', '#', '#', '*'},
      {'*', '#', '*', '*', '*', '*', '*', '*', '*', '*'},
      {'*', '*', '*', '#', '#', '#', '#', '#', '#', '#'}
    };

    String[] words = new String[] {"PUNJAB", "JHARKHAND", "MIZORAM", "MUMBAI"};

    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));

    CrossWordPuzzle.fill(crossword, words);
    var expectedOutput =
        """
                        [*, J, *, *, *, *, *, *, *, *]
                        [*, H, *, *, *, *, *, *, *, *]
                        [*, A, *, *, *, *, P, *, *, *]
                        [*, R, #, *, *, *, U, #, *, *]
                        [*, K, *, *, *, *, N, *, *, *]
                        [*, H, *, *, *, *, J, *, *, *]
                        [*, A, *, *, *, *, A, *, *, *]
                        [*, N, *, M, U, M, B, A, I, *]
                        [*, D, *, *, *, *, *, *, *, *]
                        [*, *, *, M, I, Z, O, R, A, M]
                        """;
    Assertions.assertEquals(expectedOutput, outContent.toString());
  }
}
