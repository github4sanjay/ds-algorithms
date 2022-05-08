package com.github4sanjay.dsalgo.backtracking;

import com.github4sanjay.dsalgo.util.AlgoUtil;

public class CrossWordPuzzle {

  public static void main(String[] args) {
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

    CrossWordPuzzle.fill(crossword, words, 0);
  }

  private static void fill(char[][] crossword, String[] words, int wordIndex) {
    if (wordIndex == words.length) {
      AlgoUtil.print(crossword);
      return;
    }
    String currentWord = words[wordIndex];
    for (int i = 0; i < crossword.length; i++) {
      for (int j = 0; j < crossword.length; j++) {
        if (crossword[i][j] == '#' || crossword[i][j] == currentWord.charAt(0)) {
          if (tryFittingInRow(crossword, currentWord, i, j)) {
            boolean[] placed = placeWordInRow(crossword, currentWord, i, j);
            fill(crossword, words, wordIndex + 1);
            removeWordInRow(crossword, i, j, placed);
          }
          if (tryFittingInCol(crossword, currentWord, i, j)) {
            boolean[] placed = placeWordInCol(crossword, currentWord, i, j);
            fill(crossword, words, wordIndex + 1);
            removeWordInCol(crossword, i, j, placed);
          }
        }
      }
    }
  }

  private static void removeWordInRow(char[][] crossword, int row, int col, boolean[] placed) {
    for (int j = 0; j < placed.length; j++) {
      if (placed[j]) {
        crossword[row][col + j] = '#';
      }
    }
  }

  private static void removeWordInCol(char[][] crossword, int row, int col, boolean[] placed) {
    for (int i = 0; i < placed.length; i++) {
      if (placed[i]) {
        crossword[row + i][col] = '#';
      }
    }
  }

  private static boolean[] placeWordInRow(
      char[][] crossword, String currentWord, int row, int col) {
    boolean[] placed = new boolean[currentWord.length()];
    char[] chars = currentWord.toCharArray();
    for (int j = 0; j < chars.length; j++) {
      if (chars[j] != crossword[row][col + j]) {
        placed[j] = true;
        crossword[row][col + j] = chars[j];
      }
    }
    return placed;
  }

  private static boolean[] placeWordInCol(
      char[][] crossword, String currentWord, int row, int col) {
    boolean[] placed = new boolean[currentWord.length()];
    char[] chars = currentWord.toCharArray();
    for (int i = 0; i < chars.length; i++) {
      if (chars[i] != crossword[row + i][col]) {
        placed[i] = true;
        crossword[row + i][col] = chars[i];
      }
    }
    return placed;
  }

  private static boolean tryFittingInRow(char[][] crossword, String word, int row, int col) {
    if (col - 1 >= 0
        && crossword[row][col - 1] != '*') { // there should be some gap between two words
      return false;
    } else if (col + word.length() < crossword[0].length
        && crossword[row][col + word.length()] != '*') {
      return false;
    }

    for (int j = 0; j < word.length(); j++) {
      if (col + j >= crossword[0].length) {
        return false;
      }
      if (crossword[row][col + j] == '#' || crossword[row][col + j] == word.charAt(j)) {
        continue;
      } else {
        return false;
      }
    }
    return true;
  }

  private static boolean tryFittingInCol(char[][] crossword, String word, int row, int col) {
    if (row - 1 >= 0
        && crossword[row - 1][col] != '*') { // there should be some gap between two words
      return false;
    } else if (row + word.length() < crossword.length
        && crossword[row + word.length()][col] != '*') {
      return false;
    }

    for (int i = 0; i < word.length(); i++) {
      if (row + i >= crossword.length) {
        return false;
      }
      if (crossword[row + i][col] == '#' || crossword[row + i][col] == word.charAt(i)) {
        continue;
      } else {
        return false;
      }
    }
    return true;
  }
}
