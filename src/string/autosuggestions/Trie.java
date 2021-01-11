package string.autosuggestions;

import java.util.HashSet;
import java.util.Set;

public class Trie {
    private final TrieNode root;

    public Trie() {
        this.root = new TrieNode();
    }

    public void add(String word, int rank){
        var currentNode = root;
        var wordObj = new TrieNode.Word(word, rank);
        for (char ch : word.toCharArray()){
            currentNode.addWord(wordObj);
            var node = currentNode.getCharacterNode(ch);
            if (node == null){
                node = new TrieNode();
                currentNode.putCharacterNode(ch, node);
            }
            currentNode = node;
        }
    }

    public Set<TrieNode.Word> getSuggestions(String prefix) {
        var current = root;
        var prev = new TrieNode();
        for (char ch : prefix.toCharArray()) {
            var node = current.getCharacterNode(ch);
            if (node == null){
                return new HashSet<>();
            }
            prev = current;
            current = node;
        }
        return prev.getWords();
    }
}
