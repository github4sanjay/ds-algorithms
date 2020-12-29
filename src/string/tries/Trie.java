package string.tries;

public class Trie {
    private TrieNode root;

    public Trie() {
        this.root = new TrieNode();;
    }

    public TrieNode getRoot() {
        return root;
    }

    public void setRoot(TrieNode root) {
        this.root = root;
    }

    public void insert(String str){
        var node = root;
        for (int i=0; i< str.length(); i++){
            char ch = str.charAt(i);
            var characterNode = node.getCharacterNode(ch);
            if (characterNode == null){
                characterNode = new TrieNode();
                node.putCharacterNode(ch, characterNode);
            }
            node = characterNode;
        }
        node.setCompleteWord(true);
    }

    public boolean search(String str){
        var node = root;
        for (int i=0; i<str.length();i++){
            var ch = str.charAt(i);
            var characterNode = node.getCharacterNode(ch);
            if (characterNode == null){
                return false;
            } else {
                node = characterNode;
            }
        }
        return node.isCompleteWord();
    }

    public boolean delete(String str){
        var node = root;
        for (int i=0; i<str.length();i++){
            var ch = str.charAt(i);
            var characterNode = node.getCharacterNode(ch);
            if (characterNode == null){
                return false;
            } else {
                node = characterNode;
            }
        }
        node.setCompleteWord(false);
        return true;
    }
}
