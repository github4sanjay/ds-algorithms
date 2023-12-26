package com.github4sanjay.dsalgo.backtracking;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MaxScoreOfWordsTest {

  @Test
  public void test1() {
    String[] words = {"dog", "cat", "dad", "good"};
    String[] letters = {"a", "a", "c", "d", "d", "d", "g", "o", "o"};
    int[] score = {1, 0, 9, 5, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

    Assertions.assertEquals(23, MaxScoreOfWords.calculate(words, letters, score));
  }

  @Test
  public void test2() {
    String[] words = {"xxxz", "ax", "bx", "cx"};
    String[] letters = {"z", "a", "b", "c", "x", "x", "x"};
    int[] score = {4, 4, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5, 0, 10};

    Assertions.assertEquals(27, MaxScoreOfWords.calculate(words, letters, score));
  }

  @Test
  public void test3() {
    String[] words = {"leetcode"};
    String[] letters = {"l", "e", "t", "c", "o", "d"};
    int[] score = {0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0};

    Assertions.assertEquals(0, MaxScoreOfWords.calculate(words, letters, score));
  }
}
