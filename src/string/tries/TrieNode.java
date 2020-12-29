package string.tries;

import java.util.HashMap;
import java.util.Map;

public class TrieNode {
    private Map<Character, TrieNode> children;
    private boolean isCompleteWord;

    public TrieNode() {
        this.children = new HashMap<>();
        this.isCompleteWord = false;
    }

    public TrieNode getCharacterNode(char ch) {
        return children.get(ch);
    }

    public void putCharacterNode(char ch, TrieNode node) {
        children.put(ch, node);
    }

    public Map<Character, TrieNode> getChildren() {
        return children;
    }

    public void setChildren(Map<Character, TrieNode> children) {
        this.children = children;
    }

    public boolean isCompleteWord() {
        return isCompleteWord;
    }

    public void setCompleteWord(boolean completeWord) {
        isCompleteWord = completeWord;
    }
}
