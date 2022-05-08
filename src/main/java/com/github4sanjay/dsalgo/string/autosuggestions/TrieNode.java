package com.github4sanjay.dsalgo.string.autosuggestions;

import java.util.*;

public class TrieNode {
  private final Map<Character, TrieNode> children;
  private final Set<Word> words;

  public TrieNode() {
    this.children = new HashMap<>();
    this.words = new TreeSet<>();
  }

  public Map<Character, TrieNode> getChildren() {
    return children;
  }

  public Set<Word> getWords() {
    return words;
  }

  public void addWord(Word word) {
    words.add(word);
  }

  public TrieNode getCharacterNode(char ch) {
    return children.get(ch);
  }

  public void putCharacterNode(char ch, TrieNode node) {
    children.put(ch, node);
  }

  public static class Word implements Comparable<Word> {
    private final String word;
    private final Integer rank;

    public Word(String word, int rank) {
      this.word = word;
      this.rank = rank;
    }

    public String getWord() {
      return word;
    }

    public int getRank() {
      return rank;
    }

    @Override
    public int compareTo(Word o) {
      return o.rank.compareTo(this.rank);
    }

    @Override
    public String toString() {
      return "Word{" + "word='" + word + '\'' + ", rank=" + rank + '}';
    }
  }
}
