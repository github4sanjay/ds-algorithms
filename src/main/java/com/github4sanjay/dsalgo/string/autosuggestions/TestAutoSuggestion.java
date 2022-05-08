package com.github4sanjay.dsalgo.string.autosuggestions;

public class TestAutoSuggestion {

  public static void main(String[] args) {
    var trie = new Trie();
    trie.add("god", 100);
    trie.add("dog", 90);
    trie.add("elephant", 55);
    trie.add("ant", 10);
    trie.add("antena", 11);
    trie.add("antern", 12);
    trie.add("fix", 9);
    trie.add("fixed", 8);
    trie.add("fixer", 7);
    System.out.println(trie.getSuggestions("fix"));
    System.out.println(trie.getSuggestions("ant"));
  }
}
