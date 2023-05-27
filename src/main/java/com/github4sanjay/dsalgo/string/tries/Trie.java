package com.github4sanjay.dsalgo.string.tries;

public class Trie {
  private final TrieNode root;

  public Trie() {
    this.root = new TrieNode();
    ;
  }

  public void insert(String str) {
    var node = root;
    for (int i = 0; i < str.length(); i++) {
      char ch = str.charAt(i);
      var characterNode = node.getCharacterNode(ch);
      if (characterNode == null) {
        characterNode = new TrieNode();
        node.putCharacterNode(ch, characterNode);
      }
      node = characterNode;
    }
    node.setCompleteWord(true);
  }

  public boolean search(String str) {
    var node = root;
    for (int i = 0; i < str.length(); i++) {
      var ch = str.charAt(i);
      var characterNode = node.getCharacterNode(ch);
      if (characterNode == null) {
        return false;
      } else {
        node = characterNode;
      }
    }
    return node.isCompleteWord();
  }

  public boolean delete(String str) {
    var node = root;
    for (int i = 0; i < str.length(); i++) {
      var ch = str.charAt(i);
      var characterNode = node.getCharacterNode(ch);
      if (characterNode == null) {
        return false;
      } else {
        node = characterNode;
      }
    }
    node.setCompleteWord(false);
    return true;
  }

  public boolean startsWith(String prefix) {
    var node = root;
    for (int i = 0; i < prefix.length(); i++) {
      var ch = prefix.charAt(i);
      var currentNode = node.getCharacterNode(ch);
      if (currentNode == null) {
        return false;
      } else {
        node = currentNode;
      }
    }
    return node != null;
  }
}
